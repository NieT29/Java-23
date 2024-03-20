// let name = "tiến";
// let age = 24;

// console.log(` mình tên là ${name} năm nay ${age} tuổi `)

// // c1: Function declaration
// function sum(a, b) {
//     return a+b;
// }

// // c2: Function expression
// let sum2 = function(a, b) {
//     return a*b;
// }

// // c3: arrow function - ES6 || Lambda expression - Java

// let sum3 = (a, b) => {
//     return a + b;
// }

// console.log(sum(4, '5'))
// console.log(sum2(4, '5'))
// console.log(sum3(4, typeof 5))

// Bài 1:

function calculateFactorial(number) {
    if (number < 0) {
        return "không thể tính giai thừa số âm";
    } else if (number === 0 || number === 1) {
        return 1;
    } else {
        let result = 1
        for (let i = 2; i <= number; i++) {
            result *= i
        }
        return result;
    }
}

console.log(calculateFactorial(5))

// Bài 2
