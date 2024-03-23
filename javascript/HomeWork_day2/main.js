let products = [
    {
        name: "Iphone 13 Pro Max",
        price: 30000000,
        brand: "Apple",
        count: 2,
    },
    {
        name: "Samsung Galaxy Z Fold3",
        price: 41000000,
        brand: "Samsung",
        count: 1,
    },
    {
        name: "IPhone 11",
        price: 15500000,
        brand: "Apple",
        count: 1,
    },
    {
        name: "OPPO Find X3 Pro",
        price: 19500000,
        brand: "OPPO",
        count: 3,
    },
];

// 1. In ra thông tin các sản phẩm trong giỏ hàng
    console.log("1. Thông tin các sản phẩm trong giỏ hàng:");
    products.forEach(product => {
        console.log(`${product.name} - ${product.price} - ${product.brand} - ${product.count}`);
    });

// 2. Tính tổng tiền tất cả sản phẩm trong giỏ hàng
    let total = products.reduce((acc, product) => acc + (product.price * product.count), 0);
    console.log("\n2. Tổng tiền tất cả sản phẩm trong giỏ hàng:", total);

// 3. Tìm các sản phẩm của thương hiệu "Apple"
    let appleProducts = products.filter(product => product.brand.toLowerCase() === "apple");
    console.log("\n3. Các sản phẩm của thương hiệu 'Apple':", appleProducts);

// 4. Tìm các sản phẩm có giá > 20000000
    let expensiveProducts = products.filter(product => product.price > 20000000);
    console.log("\n4. Các sản phẩm có giá > 20000000:", expensiveProducts);

// 5. Tìm các sản phẩm có chữ "pro" trong tên (Không phân biệt hoa thường)
    let proProducts = products.filter(product => product.name.toLowerCase().includes("pro"));
    console.log("\n5. Các sản phẩm có chữ 'pro' trong tên:", proProducts);

// 6. Thêm 1 sản phẩm bất kỳ vào trong mảng product
    let newProduct = {
        name: "Xiaomi Redmi Note 11",
        price: 7000000,
        brand: "Xiaomi",
        count: 2,
    };
    products.push(newProduct);
    console.log("\n6. Thêm sản phẩm mới:", newProduct);

// 7. Xóa tất cả sản phẩm của thương hiệu "Samsung" trong giỏ hàng
    products = products.filter(product => product.brand.toLowerCase() !== "samsung");
    console.log("\n7. Xóa tất cả sản phẩm của thương hiệu 'Samsung'");

// 8. Sắp xếp giỏ hàng theo price tăng dần
    products.sort((a, b) => a.price - b.price);
    console.log("\n8. Sắp xếp giỏ hàng theo price tăng dần:", products);

// 9. Sắp xếp giỏ hàng theo count giảm dần
    products.sort((a, b) => b.count - a.count);
    console.log("\n9. Sắp xếp giỏ hàng theo count giảm dần:", products);

// 10. Lấy ra 2 sản phẩm bất kỳ trong giỏ hàng
    let randomProducts = products.slice(0, 2);
    console.log("\n10. Lấy ra 2 sản phẩm bất kỳ trong giỏ hàng:", randomProducts);
