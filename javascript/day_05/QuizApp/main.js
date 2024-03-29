const questions = [
    {
        title: "1 + 1 bằng bao nhiêu?",
        choices: ["1", "2", "3", "4"],
        answer: "2"
    },
    {
        title: "Số nào sau đây là số nguyên tố?",
        choices: ["22", "4", "25", "11"],
        answer: "11"
    },
    {
        title: "Căn bậc hai của 81 là bao nhiêu?",
        choices: ["7", "8", "9", "10"],
        answer: "9"
    },
    {
        title: "15% của 100 bằng bao nhiêu?",
        choices: ["10", "15", "20", "25"],
        answer: "15"
    },
    {
        title: "Số nào sau đây chia hết cho 3?",
        choices: ["14", "22", "27", "32"],
        answer: "27"
    }
];

let currentQuestionIndex = 0;
let score = 0;
let yourAnswers = [];

const titleQuestionEl = document.querySelector("#question p")
const choicesEl = document.querySelector(".choices")

const renderQuestion = () => {
    // lấy thông tin câu hỏi hiện tại
    const currentQuestion = questions[currentQuestionIndex]

    // hiển thị tiêu đề
    titleQuestionEl.innerText = `Câu ${currentQuestionIndex + 1}: ${currentQuestion.title}` 

    // hiển thị các lựa chọn
    let choicesHtml = ""
    currentQuestion.choices.forEach((choice, index) => {
        choicesHtml += `
            <div class="choice-item">
                <input type="radio" name="choice" id="${index}" value="${choice}">
                <label for="${index}">${choice}</label>
            </div>
        `
    })
    choicesEl.innerHTML = choicesHtml;
}

const btnNext = document.getElementById("btn-next")
const btnFinish = document.getElementById("btn-finish")

btnNext.addEventListener("click", () => {
    // kiểm tra xem người dùng đã chọn câu trả lời chưa
    const selectedChoice = document.querySelector("input[name='choice']:checked")
    if(!selectedChoice) {
        alert("Bạn chưa trả lời câu hỏi")
        return
    }
    // Lưu lại đáp án người dùng chọn
        yourAnswers.push(selectedChoice.value);
    // Next câu hỏi
    currentQuestionIndex++;
    // khi đến câu hỏi cuối cùng thì ẩn nút Next, hiển thị nút Finish
    if (currentQuestionIndex === questions.length - 1) {
        btnNext.classList.add("hide");
        btnFinish.classList.remove("hide");
    }
    renderQuestion();
})

btnFinish.addEventListener("click", () => {
    // kiểm tra xem người dùng đã chọn câu trả lời cuối chưa
    const selectedChoice = document.querySelector("input[name='choice']:checked")
    if(!selectedChoice) {
        alert("Bạn chưa trả lời câu hỏi")
        return
    }
    // lưu lại đáp án câu cuối cùng
    yourAnswers.push(selectedChoice.value);
    // tính điểm
    for (let i = 0; i < questions.length; i++) {
        if(yourAnswers[i] === questions[i].answer) {
            score++
        }
    }
    // hiển thị điểm
    alert(`Số điểm của bạn là: ${score}/${questions.length}`)
    location.reload();
})

renderQuestion();