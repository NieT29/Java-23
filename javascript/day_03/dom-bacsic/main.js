const heading = document.getElementById("heading");
console.log(heading);
const headingCss = document.querySelector("#heading");
console.log(headingCss);

// thay đổi css -> inline style
heading.style.color = "red";
heading.style.backgroundColor = "black";

// thay đổi text
heading.innerHTML = "<span>Xin chào</span>"
heading.textContent = "Xin chào"
heading.innerText = "Xin chào các bạn"

const paraList = document.querySelectorAll("p");
console.log(paraList)

// for (let i = 0; i< paraList.length; i++) {
//   paraList[i].style.color = "blue"
// }

// tạo thẻ p có nội dung là "para 4" vào sau thẻ para 3
const p4 = document.createElement("p");

p4.innerText = "Para 4";
// document.body.appendChild(p4);

const para2 = document.querySelector(".para");

document.body.insertBefore(p4, para2);

const menu = [
    {
        label: "Facebook",
        url: "https://facebook.com"
    },
    {
        label: "Google",
        url: "https://google.com"
    },
    {
        label: "Youtube",
        url: "https://youtube.com"
    }
]


// menu.forEach(item => {
//     const link = document.createElement("a");
//     link.innerText = item.label;
//     link.href = item.url
//     document.body.appendChild(link);
// })

for (let i = 0; i < menu.length; i++) {
    const link = document.createElement("a");
    link.innerText = menu[i].label;
    link.href = menu[i].url;
    document.body.appendChild(link);
}

