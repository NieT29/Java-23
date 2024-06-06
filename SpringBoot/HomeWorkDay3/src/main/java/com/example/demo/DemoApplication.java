package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        List<Integer> numbers = List.of(10, 5, 3, 12, 6, 7, 5, 3);

        // 1. Duyệt numbers
        numbers.stream().forEach(System.out::println);

        // 2. Tìm các giá trị chẵn trong list
        List<Integer> findEvenValue = numbers.stream()
                .filter(num -> num % 2 == 0)
                .toList();
        System.out.println("Giá trị chẵn trong list: " + findEvenValue);

        // 3. Tìm các giá trị > 5 trong list
        List<Integer> greaterThanFive = numbers.stream()
                .filter(num -> num > 5)
                .toList();
        System.out.println("giá trị lớn hơn 5: " + greaterThanFive);

        // 4. Tìm giá trị max trong list
        int maxValue = numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();
        System.out.println("giá trị lớn nhất: " + maxValue);

        // 5. Tìm giá trị min trong list
        int minValue = numbers.stream()
                .mapToInt(Integer::intValue)
                .min()
                .getAsInt();
        System.out.println("giá trị nhỏ nhất: " + minValue);

        // 6. Tính tổng các phần tử của mảng
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("tổng các phần tử của mảng: " + sum);

        // 7. Lấy danh sách các phần tử không trùng nhau
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .toList();
        System.out.println("danh sách các phần tử không trùng nhau: " + distinctNumbers);

        // 8. Lấy 5 phần tử đầu tiên trong mảng
        List<Integer> firstFiveElements = numbers.stream()
                .limit(5)
                .toList();
        System.out.println("5 phần tử đầu tiên trong mảng: " + firstFiveElements);

        // 9. Lấy phần tử từ thứ 3 -> thứ 5
        List<Integer> elementsFrom3to5 = numbers.stream()
                .skip(2)
                .limit(3)
                .toList();
        System.out.println("phần tử từ 3-5 trong mảng: " + elementsFrom3to5);

        // 10. Lấy phần tử đầu tiên > 5
        int fistGreaterThanFive = numbers.stream()
                .filter(number -> number > 5)
                .findFirst()
                .get();
        System.out.println("phần tử đầu tiên lớn hơn 5: " + fistGreaterThanFive);

        // 11. Kiểm tra xem list có phải là list chẵn hay không
        boolean isEvenList = numbers.stream()
                .allMatch(number -> number % 2 == 0);
        if (isEvenList) {
            System.out.println("danh sách là danh sách chẵn");
        } else {
            System.out.println("danh sách không phải là danh sách chẵn");
        }

        // 12. Kiểm tra xem list có phần tử > 10 hay không
        boolean hasElementGreaterThan10 = numbers.stream()
                .anyMatch(number -> number > 10);

        if (hasElementGreaterThan10) {
            System.out.println("danh sách chứa ít nhất một phần tử lớn hơn 10");
        } else {
            System.out.println("danh sách không chứa phần tử nào lớn hơn 10");
        }

        // 13. Có bao nhiêu phần tử > 5
        long count = numbers.stream()
                .filter(number -> number > 5)
                .count();
        System.out.println("số lượng phần tử lớn hơn 5: " + count);

        // 14. Nhân đôi các phần tủ trong list và trả về list mới
        List<Integer> doubledNumbers = numbers.stream()
                .map(number -> number * 2)
                .toList();
        System.out.println("danh sách phần tử sau khi nhân đôi: " + doubledNumbers);

        // 15. Kiểm tra xem list không chứa giá trị nào = 8 hay không
        boolean containsEight = numbers.stream()
                .anyMatch(number -> number == 8);

        if (containsEight) {
            System.out.println("Danh sách chứa ít nhất một phần tử bằng 8.");
        } else {
            System.out.println("Danh sách không chứa phần tử nào bằng 8.");
        }
    }

}
