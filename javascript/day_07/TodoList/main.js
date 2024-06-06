const API_URL = "http://localhost:8000/todos"
let todos = [];

const ulEl = document.querySelector("ul")
const renderTodos = (todos) => {
    ulEl.innerHTML = "";
    if (todos.length === 0) {
        ulEl.insertAdjacentHTML("afterbegin", "<li>Danh sách công việc trống</li>");
        return;
    }

    let html = "";
    todos.forEach(todo => {
        html += `
                <li>
                    <input 
                    type="checkbox" 
                    ${todo.status ? "checked" : ""}
                    onchange="toggleStatus(${todo.id})"
                    >
                    <span class=${todo.status ? "active" : ""}>${todo.title}</span>
                    <button onclick="editTodo(${todo.id})">Edit</button>
                    <button onclick="deleteTodo(${todo.id})">Delete</button>
                </li>
                `;
        //    if(todo.status) {
        //         html += `
        //         <li>
        //             <input type="checkbox" checked>
        //             <span class="active">${todo.title}</span>
        //             <button>Edit</button>
        //             <button>Delete</button>
        //         </li>
        //         `;
        //    } else {
        //         html += `
        //         <li>
        //             <input type="checkbox" >
        //             <span>${todo.title}</span>
        //             <button>Edit</button>
        //             <button>Delete</button>
        //         </li>
        //         `;
        //    }
    });
    ulEl.innerHTML = html;
}

// Lấy danh sách todo trên server
const getAllTodos = async () => {
    try {
        const response = await axios.get(API_URL)
        console.log(response)

        todos = response.data; // Lưu lại danh sách todo vào biến todos
        renderTodos(todos); // render lại giao diện
    } catch (error) {
        console.log(error)
    }
}

// Thêm công việc
const inputTodo = document.getElementById("input-todo");
const btnAdd = document.getElementById("btn-add")

btnAdd.addEventListener("click", async () => {
    // lấy nội dung trong ô input
    const title = inputTodo.value.trim();
    // kiểm tra nội dung có rỗng không
    if (title === "") {
        alert("Vui lòng nhập công việc")
        return;
    }

    // tạo todo mới
    const newTodo = {
        title,
        status: false
    }

    try {
        const response = await axios.post(API_URL, newTodo)

        // thêm cv vào mảng todos
        todos.push(response.data);

        // render lại giao diện
        renderTodos(todos)

        inputTodo.value = ""
        inputTodo.focus();
    } catch (error) {
        console.log(error)
    }


})

// xóa công việc
const deleteTodo = async (id) => {
    const confirm = window.confirm("bạn có chắc muốn xóa không");
    if (!confirm)
        return;

    try {
        const response = await axios.delete(`${API_URL}/${id}`)
        if (response.status === 200) {
            // Xóa todo khỏi danh sách và render lại
            todos = todos.filter(todo => todo.id !== id);
            renderTodos(todos);
        } else {
            console.log("Xóa không thành công");
        }
    } catch (error) {
        console.log(error)
    }
}

// sửa tiêu đề công việc
const editTodo = async (id) => {
    const todo = todos.find(todo => todo.id === id)

    const newTitle = window.prompt("Mời bạn nhập title muốn thay đổi")
    if (newTitle === "" || newTitle == null) {
        alert("Không được để trống")
        return
    }

    const editTitle = {
        title: newTitle,
        status: todo.status
    }

    try {
        const response = await axios.put(`${API_URL}/${id}`, editTitle)
        if (response.status === 200) {
            todo.title = newTitle
            renderTodos(todos)
        } else {
            console.log("sửa không thành công")
        }
    } catch (error) {
        console.log(error)
    }
}

// thay đổi trạng thái công việc
const toggleStatus = async (id) => {
    const todo = todos.find(todo => todo.id === id)

    const newStatus = {
        title: todo.title,
        status: !todo.status
    }

    try {
        const response = await axios.put(`${API_URL}/${id}`, newStatus)
        if (response.status === 200) {
            todo.status = !todo.status
            renderTodos(todos)
        } else {
            console.log("không cập nhật được trạng thái")
        }
    } catch (error) {
        console.log
    }

}

// tìm kiếm công việc
const btnSearch = document.getElementById("btn-search")
const inputSearch = document.getElementById("search-input-todo")

btnSearch.addEventListener("click", async () => {
    const titleSearch = inputSearch.value.trim()
    if (titleSearch === "") {
        alert("Vui lòng nhập công việc cần tìm kiếm")
        return;
    }

    try {
        const response = await axios.get(`${API_URL}?title_like=${titleSearch}`);
        // render ra công việc được tìm kiếm
        renderTodos(response.data)
        inputSearch.value = "";
    } catch (error) {
        console.log(error)
    }

})


getAllTodos();