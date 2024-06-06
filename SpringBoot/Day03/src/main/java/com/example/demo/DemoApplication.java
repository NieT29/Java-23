package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        Greeting vietnam = new VietNam();
        vietnam.greet("Nguyễn Văn A");

        // sử dụng anonymous class
        Greeting china = new Greeting() {
            @Override
            public void greet(String name) {
                System.out.println("你好" + name);
            }
        };
        china.greet("阮文爱");

        // sử dụng lamda expression
        Greeting japan = (name) -> System.out.println("こんにちは " + name);
        japan.greet("グエン・ヴァン・A");

        Greeting english = (name) -> System.out.println("hello " + name);
        english.greet("Jonh Doe");

        // sử dụng lamda expression calculator
        Calculator add = (a, b) -> a + b;
        System.out.println("5 + 3 = " + add.cal(5, 3));
    }


}
