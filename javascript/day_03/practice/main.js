// 1.Truy cập vào thẻ h1 có id=“heading” thay đổi màu chữ thành ‘red’, và in hoa nội dung của thẻ đó
// 2.Thay đổi màu chữ của tất cả thẻ có class “para” thành màu “blue” và có font-size = “20px”
// 3.Thêm thẻ a link đến trang ‘facebook’ ở đằng sau thẻ có class “para-3”
// 4.Thay đổi nội dung của thẻ có id=“title” thành “Đây là thẻ tiêu đề”
// 5.Thêm class “text-bold” vào thẻ có class=“description” (định nghĩa class “text-bold” có tác dụng in đậm chữ)
// 6.Thay thế thẻ có class=“para-3” thành thẻ button có nội dung là “Click me”
// 7.Copy thẻ có class=“para-2” và hiển thị ngay đằng sau thẻ đó
// 8.Xóa thẻ có class=“para-1”

//1
const heading = document.getElementById("heading");
heading.style.color = "red";
heading.style.textTransform = "uppercase"

//2
const paraList = document.querySelectorAll(".para");

for (let i = 0; i< paraList.length; i++) {
  paraList[i].style.color = "blue"
  paraList[i].style.fontSize = "20px"
}

//3
const content = document.querySelector(".content")
const tagA = document.createElement("a");
tagA.innerText = "Facebook"
tagA.href = "https://facebook.com"
document.body.insertBefore(tagA, content);

//4
const title = document.getElementById("title")
title.innerText = "Đây là thẻ tiêu đề"

//5
const des = document.querySelector(".description")
des.classList.add("text-bold")

//6
const para3 = document.querySelector(".para-3")
const button = document.createElement("button")
button.innerText = "Click me"
document.body.replaceChild(button, para3)

//7
const para2 = document.querySelector(".para-2")
const paraCopy = para2.cloneNode(false)
paraCopy.innerText = "Thẻ para copy";
para2.insertAdjacentElement("afterend", paraCopy)

//8
const para1 = document.querySelector(".para-1")
document.body.removeChild(para1)