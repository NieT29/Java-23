const number = document.querySelector("#counter")
const prevBtn = document.querySelector(".prevBtn")
const nextBtn =document.querySelector(".nextBtn")

let valueNumber = 0;
function update() {
    number.textContent = valueNumber
    if (valueNumber == 0 ) {
        number.style.color = "green"
    } else if (valueNumber > 0) {
        number.style.color = "#333333"
    } else {
        number.style.color = "red"
    }
}
prevBtn.addEventListener("click", () => {
    valueNumber--;
    update();
}) 
nextBtn.addEventListener("click", () => {
    valueNumber++;
    update();
}) 

// let totalBox = 0;

// function updateBox() {
//     const points = document.querySelector(".points")
//     points.innerText = totalBox;
// }

// function renderBox() {
//     for (let i = 0; i < colors.length; i++) {
//         const box = document.createElement("div")
//         totalBox++
//         updateBox(totalBox)
//         box.classList.add("box")
//         box.style.backgroundColor = colors[i]
//         box.addEventListener('click', () => {
//             box.remove();
//             totalBox--;
//             updateBox(totalBox);
//         });
//         document.body.appendChild(box)
//     }
// }

// renderBox();

// const btn = document.querySelector("#btn")
// btn.addEventListener("click", ()=> {
//     renderBox();
// })

