// bài 1
// Viết function truyền vào mảng các chuỗi có độ dài bất kỳ. Kết quả trả về là 1 mảng các chuỗi có độ dài lớn nhất
function getStringHasMaxLength(strings) {
    let maxLength = 0;
    for (let i = 0; i < strings.length; i++) {
        if (strings[i].length > maxLength) {
            maxLength = strings[i].length;
        }
    }

    const longestStrings = strings.filter(str => str.length === maxLength);
    return longestStrings;
}

console.log(getStringHasMaxLength(['aba', 'aa', 'ad', 'c', 'vcd']))

// bài 2
// cho mảng users
users = [
    {
        name: "Bùi Công Sơn",
        age: 30,
        isStatus: true
    },
    {
        name: "Nguyễn Thu Hằng",
        age: 27,
        isStatus: false
    },
    {
        name: "Phạm Văn Dũng",
        age: 20,
        isStatus: false
    }
]

// Viết function truyền vào 1 mảng các object user. Trả về mảng các user có age > 25 và isStatus = true
function filterUsersByAgeAndStatus(users) {
    return users.filter(user => user.age > 25 && user.isStatus);
}

console.log(filterUsersByAgeAndStatus(users));

// Viết function truyền vào 1 mảng các object user. Trả về mảng các user có age tăng dần
function sortByAge(users) {
    return users.sort((a, b) => a.age - b.age);
}

console.log(sortByAge(users));

// bài 3
// Viết function truyền vào 1 mảng các chuỗi. Trả về Object hiển thị xem mỗi phần tử trong mảng xuất hiện bao nhiêu lần
function getCountElement(arr) {
    let countObj = {};

    arr.forEach(element => {
        if (countObj[element]) {
            countObj[element]++;
        } else {
            countObj[element] = 1;
        }
    });

    return countObj;
}

console.log(getCountElement(["one", "two", "three", "one", "one", "three"]))