// document.addEventListener('click', function() {
//     console.log('click');
//    })

//    document.addEventListener('mousedown', function() {
//     console.log('mousedown');
//    })

//    document.addEventListener('mousemove', function() {
//     console.log('mousemove');
//    })

//    document.addEventListener('mouseup', function() {
//     console.log('mouseup');
//    })


// document.addEventListener('click', function(event) {
//     // xóa hình tròn (nếu có)
//     const currentCircEl = document.querySelector(".circle")
//     if (currentCircEl) {
//         document.body.removeChild(currentCircEl)
//     }

//     // tạo hình tròn
//     const circleEl = document.createElement("div")
//     circleEl.classList.add("circle")
//     // gán vị trí cho hình tròn
//     circleEl.style.top = `${event.offsetY - 50}px`;
//     circleEl.style.left = `${event.offsetX - 50}px`
//     document.body.appendChild(circleEl)
// })  

// sự kiện bàn phím

// Lắng nghe sự kiện keydown
let products = [
    {
        name: "Iphone 13 Pro Max", // Tên sản phẩm
        price: 3000000, // Giá mỗi sản phẩm
        brand: "Apple", // Thương hiệu
        count: 2, // Số lượng sản phẩm trong giỏ hàng
    },
    {
        name: "Samsung Galaxy Z Fold3",
        price: 41000000,
        brand: "Samsung",
        count: 1,
    },
    {
        name: "IPhone 11",
        price: 15500000,
        brand: "Apple",
        count: 1,
    },
    {
        name: "OPPO Find X3 Pro",
        price: 19500000,
        brand: "OPPO",
        count: 3,
    },
]

const input = document.querySelector("input")
const ul = document.querySelector("ul")
document.addEventListener("keydown", (event) => {
    if (event.key === "Enter") {
        // lấy giá trị trong ô input
        let value = input.value;

        // kiểm tra xem giá trị trong ô input có tồn tại trong mảng products không
        let data = products.filter(product => product.name.toLowerCase().includes(value.toLowerCase()))

        // hiển thị kết quả
        if (data.length === 0) {
            ul.innerHTML = `<li>Không tìm thấy sản phẩm nào</li>`;
        } else {
            ul.innerHTML = data.map(product => `<li>${product.name}</li>`).join('');
        }

        // clear giá trị trong ô input
        input.value = ""
    }
});

// Lắng nghe sự kiện keyup
// document.addEventListener("keyup", function () {
//     console.log("keyup");
// });

// // Lắng nghe sự kiện keypress
// document.addEventListener("keypress", function () {
//     console.log("keypress");
// });
