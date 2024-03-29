let todos = [
    {
        id: 1,
        title: "Làm bài tập về nhà",
        status: true
    }, 
    {
        id: 2,
        title: "Đi chơi",
        status: false
    },
    {
        id: 3,
        title: "Đá bóng",
        status: true
    }
];

const generateId = () => {
    if(todos.length === 0) {
        return 1;
    }
    return Math.max(...todos.map(todo => todo.id)) + 1;
}

const ulEl = document.querySelector("ul")
const renderTodos = (todos) => {
    ulEl.innerHTML = "";
    if(todos.length === 0) {
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

// Thêm công việc
const inputTodo = document.getElementById("input-todo");
const btnAdd = document.getElementById("btn-add")

btnAdd.addEventListener("click", () => {
    // lấy nội dung trong ô input
    const title = inputTodo.value.trim();
    // kiểm tra nội dung có rỗng không
    if(title === "") {
        alert("Vui lòng nhập công việc")
        return;
    }

    // tạo todo mới
    const newTodo = {
        id: generateId(),
        title,
        status: false
    }

    // thêm vào mảng todos
    todos.push(newTodo);

    // render lại giao diện
    renderTodos(todos)

    inputTodo.value = ""
    inputTodo.focus();
})

const deleteTodo = (id) => {
    const confirm = window.confirm("bạn có chắc muốn xóa không");
    if(confirm) {
        todos = todos.filter(todo => todo.id != id)
        renderTodos(todos);
    }
}

const editTodo = (id) => {
    todos.forEach(todo => {
        if(todo.id === id) {
            const prompt = window.prompt("Mời bạn nhập title muốn thay đổi")
            if(prompt === "") {
                alert("Không được để trống")
                return
            } else {
                todo.title = prompt
            }
            renderTodos(todos)
        }
    });
}

const toggleStatus = (id) => {
    // todos.forEach(todo => {
    //     if(todo.id == id) {
    //         if(todo.status == true) {
    //             todo.status = false
    //         } else {
    //             todo.status = true
    //         }
    //     }
    //     renderTodos(todos)
    // });

    const todo = todos.find(todo => todo.id === id)
    todo.status = !todo.status
    renderTodos(todos)
}

renderTodos(todos);