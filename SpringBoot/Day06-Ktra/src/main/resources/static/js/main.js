function searchProducts() {
    const keyword = document.getElementById('searchInput').value.trim();
    if (keyword !== '') {
        window.location.href = '/search/' + keyword;
    } else {
        alert("Bạn cần điền tên sản phẩm")
        return;
    }
}

function goToHomePage() {
    window.location.href = '/';
}

