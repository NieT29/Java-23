/*
API là gì? Aplication Programming Interface
API là một tập hợp các quy tắc và cơ chế mà theo đó, một ứng dụng hay một thành phần sẽ tương tác với một ứng dụng hay thành phần khác

HTTP Method là gì? GET, POST, PUT, DELETE (CRUD) -> các hành động tác động lên tài nguyên (Resoure)

API Endpoint là gì? Đường dẫn URL mà chúng ta sẽ gửi request đến để lấy dữ liệu
- GET /api/users: Lấy ds tất cả user
- POST /api/users: Tạo mới user
- PUT /api/users/: Cập nhật user
- DELETE /api/users/:id :xóa user


HTTP status code là gì? mã trạng thái của HTTP
*/
const btn = document.getElementById("btn");
const image = document.getElementById("image");

// lắng nghe sự kiện khi bấm vào nút "random"
// btn.addEventListener("click", () => {
//     fetch("https://dog.ceo/api/breeds/image/random")
//     .then(response => response.json())
//     .then(data => {
//         console.log(data)
//         image.src = data.message
//     })
//     .catch(error => console.log(error))
// })


// btn.addEventListener("click", async () => {
//     try {
//         const response = await fetch("https://dog.ceo/api/breeds/image/random")
//         const data = await response.json()
//         image.src = data.message
//     } catch (error) {
//         console.log(error)
//     }
// })

// axios + promise
// btn.addEventListener("click", () => {
//     axios.get("https://dog.ceo/api/breeds/image/random")
//         .then(response => {
//             console.log(response)
//             image.src = response.data.message
//         })
//         .catch(error => console.error(error))
// })

// axios + Async/Await
btn.addEventListener("click", async () => {
    try {
        const response = await axios.get("https://dog.ceo/api/breeds/image/random")
        image.src = response.data.message
    } catch (error) {
        console.log(error)
    }
})
