// câu 1 Tạo 1 thẻ p có id=“text”, có nội dung bất kỳ (có thể tạo bằng HTML hay Javascript - tùy chọn). Yêu cầu
const text = document.getElementById("text");

// Đặt màu văn bản thành #777
text.style.color = "#777";

// Đặt kích thước phông chữ thành 2rem
text.style.fontSize = "2rem";

// Đặt nội dung HTML thành Tôi có thể làm <em> bất cứ điều gì </em> tôi muốn với JavaScript.
text.innerHTML = "Tôi có thể làm <em> bất cứ điều gì </em> tôi muốn với JavaScript."

// câu 2 Sử dụng vòng lặp để đặt màu chữ cho tất cả thẻ li thành màu blue (tạo thẻ ul-li bằng html)
const ul = document.querySelector("ul")
ul.classList.add("ul-2")

const liList2 = document.querySelectorAll(".ul-2 li");

for (let i = 0; i < liList2.length; i++) {
    liList2[i].style.color = "blue"
}

// câu 3
const list = document.getElementById("list")

// 1.Thêm 3 thẻ <li> có nội dung Item 8, Item 9, Item 10 vào cuối danh sách
for (let i = 8; i <= 10; i++) {
    const newItem = document.createElement("li")
    newItem.innerText = "Item" + i;
    list.appendChild(newItem)
}

// 2.Sửa nội dung cho thẻ <li> 1 thành màu đỏ (color)
const li1 = document.querySelector("#list li")
li1.style.color = "red"

// 3.Sửa background cho thẻ <li> 3 thành màu xanh (background-color)
const li3 = document.querySelector("#list li:nth-child(3)")
li3.style.backgroundColor="blue"

// 4.Remove thẻ <li> 4
const li4 = document.querySelector("#list li:nth-child(4)")
list.removeChild(li4)

// 5.Thêm thẻ <li> mới thay thế cho thẻ <li> 4 bị xóa ở bước trước, thẻ <li> mới có nội dung bất kỳ
const liNew = document.createElement("li")
liNew.innerText = "Item New"
li3.insertAdjacentElement("afterend", liNew)


