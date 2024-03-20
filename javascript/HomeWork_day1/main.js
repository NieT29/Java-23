// Bài 1

function calculateFactorial(number) {
    if (number < 0) {
        return "không thể tính giai thừa số âm";
    } else if (number === 0 || number === 1) {
        return 1;
    } else {
        let result = 1;
        for (let i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}

console.log(calculateFactorial(5));

// Bài 2

function reverseString(str) {
    let newString = '';
    for (let i = str.length -1; i >= 0 ; i--) {
        newString += str[i];
    }
    return newString;
}

console.log(reverseString('hello'));

// Bài 3

function translate(country) {
    let message = '';
    switch (country) {
        case 'VN': {
            message = 'Xin chào';
            break;
        }
        case 'EN': {
            message = 'Hello';
            break;
        }
        case 'FR': {
            message = 'Bonjour';
            break;
        }
        case 'CN': {
            message = '你好';
            break;
        }
        case 'JP': {
            message = 'こんにちは';
            break;
        }
        default: {
            message = 'Không có mã quốc gia phù hợp';
            break;
        }
    }
    return message;
}

console.log(translate('FR'));

// Bài 4

function subString(str) {
    if (str.length <= 15) {
        return 'nhập vào chuỗi dài hơn 15 ký tự';
    } else {
        let newString = '';
        for (let i = 0; i < 10; i++) {
            newString += str[i]
        }
        return newString + '...';
    }
}

console.log(subString('xinchaocacbandenvoiTechmaster'));