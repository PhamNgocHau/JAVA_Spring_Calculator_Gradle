package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @GetMapping("/home")
    public String getHome(){
        return "calculator";
    }

    @PostMapping("/calculator")
    public ModelAndView result(@RequestParam("firstNumber") String num1,
                               @RequestParam("secondNumber") String num2,
                               @RequestParam("opera") String opera){
        int result = 0;
        int firstNumber = Integer.parseInt(num1);
        int secondNumber = Integer.parseInt(num2);
        switch (opera){
            case "addition":
                result = firstNumber + secondNumber;
                break;
            case "subtraction":
                result = firstNumber - secondNumber;
                break;
            case "multiplication":
                result = firstNumber * secondNumber;
                break;
            case "division":
                result = firstNumber / secondNumber;
                break;
        }

        ModelAndView modelAndView = new ModelAndView("calculator");
        modelAndView.addObject("result",result);
        return modelAndView;
    }
}
