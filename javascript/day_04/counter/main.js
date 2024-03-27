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



