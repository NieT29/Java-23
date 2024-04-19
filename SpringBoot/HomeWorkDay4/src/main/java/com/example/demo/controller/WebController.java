package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebController {
    List<Integer> numbers = List.of(10, 5, 3, 12, 6, 7, 5, 3);

    @GetMapping("/")
    public String getHome() {
        return "index";
    }

    @GetMapping("/question2")
    public String question2(Model model) {
        List<Integer> findEvenValue = numbers.stream()
                .filter(num -> num % 2 == 0)
                .toList();
        model.addAttribute("result", findEvenValue);
        return "answer";
    }

    @GetMapping("/question3")
    public String question3(Model model) {
        List<Integer> greaterThanFive = numbers.stream()
                .filter(num -> num > 5)
                .toList();
        model.addAttribute("result", greaterThanFive);
        return "answer";
    }

    @GetMapping("/question4")
    public String question4(Model model) {
        int maxValue = numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();
        model.addAttribute("result", maxValue);
        return "answer";
    }

    @GetMapping("/question5")
    public String question5(Model model) {
        int minValue = numbers.stream()
                .mapToInt(Integer::intValue)
                .min()
                .getAsInt();
        model.addAttribute("result", minValue);
        return "answer";
    }

    @GetMapping("/question6")
    public String question6(Model model) {
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        model.addAttribute("result", sum);
        return "answer";
    }

    @GetMapping("/question7")
    public String question7(Model model) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .toList();
        model.addAttribute("result", distinctNumbers);
        return "answer";
    }

    @GetMapping("/question8")
    public String question8(Model model) {
        List<Integer> firstFiveElements = numbers.stream()
                .limit(5)
                .toList();
        model.addAttribute("result", firstFiveElements);
        return "answer";
    }

    @GetMapping("/question9")
    public String question9(Model model) {
        List<Integer> elementsFrom3to5 = numbers.stream()
                .skip(2)
                .limit(3)
                .toList();
        model.addAttribute("result", elementsFrom3to5);
        return "answer";
    }

    @GetMapping("/question10")
    public String question10(Model model) {
        int fistGreaterThanFive = numbers.stream()
                .filter(number -> number > 5)
                .findFirst()
                .get();
        model.addAttribute("result", fistGreaterThanFive);
        return "answer";
    }


}
