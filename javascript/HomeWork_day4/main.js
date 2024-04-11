let colors = [
    '#3498db',
    '#9b59b6',
    '#e74c3c',
    '#2c3e50',
    '#d35400',
]

const btn = document.querySelector("#btn");
const points = document.querySelector(".points");
const boxes = document.querySelector(".boxes");

let totalBox = 0;

function updateNumber() {
    points.textContent = totalBox;
}

function renderBox() {
    for (let i = 0; i < colors.length; i++) {
        const box = document.createElement("div");
        box.classList.add("box");
        box.style.backgroundColor = colors[i];
        boxes.appendChild(box);
        totalBox++;
        updateNumber();

        box.addEventListener("click", () => {
            box.remove();
            totalBox--;
            updateNumber();
        })
    }
}

renderBox();

btn.addEventListener("click", () => {
    renderBox();
})

