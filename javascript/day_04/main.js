// sử dụng HTML-attribute
function sayHello() {
    alert("xin chao cac ban 1")
}

// sử dụng DOM property
const btn2 = document.querySelector("#btn2")
btn2.onclick = () => {
    alert("xin chao cac ban 2")
}

// sử dụng addEventListener
const btn3 = document.querySelector("#btn3")
btn3.addEventListener("click", () => {
    alert("xin chao cac ban 3")
})

const text = document.querySelector("#text")

const arrText = ["xin chao cac ban 1", "xin chao cac ban 2", "xin chao cac ban 3"]

function get_random(arrText) {
    return arrText[Math.floor((Math.random() * arrText.length))];
}

function changeContent() {
    text.textContent = get_random(arrText)
}

const btn_2 = document.querySelector("#btn-2")

const randomHexColorCode = () => {
    let n = (Math.random() * 0xfffff * 1000000).toString(16);
    return '#' + n.slice(0, 6);
}

btn_2.onclick = () => {
    text.style.color = randomHexColorCode();
}

const btn_3 = document.querySelector("#btn-3")

function randomColor() {
    var r = Math.floor(Math.random() * 256);
    var g = Math.floor(Math.random() * 256);
    var b = Math.floor(Math.random() * 256);
    return "rgb(" + r + ", " + g + ", " + b + ")";
}

btn_3.addEventListener("click", () => {
    text.style.backgroundColor = randomColor();
})

