package com.calculate.calculate.service;


import com.calculate.calculate.exeptions.ZeroDivideArgument;
import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements CalculateService {

    public String major() {
        return "Добро пожаловать в калькулятор";
    }

    @Override
    public String plus(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "введите все аргументы пример /plus?num1=2&num2=2";
        }
        return num1 + " + " + num2 + " = " + (Integer.parseInt(num1) + Integer.parseInt(num2));
    }

    @Override
    public String minus(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "введите все аргументы пример /minus?num1=5&num2=5";
        }
        return num1 + " - " + num2 + " = " + (Integer.parseInt(num1) - Integer.parseInt(num2));
    }

    @Override
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "введите все аргументы пример /multiply?num1=5&num2=5";
        }
        return num1 + " * " + num2 + " = " + (Integer.parseInt(num1) * Integer.parseInt(num2));

    }

    @Override
    public String divide(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "введите все аргументы пример /divide?num1=5&num2=5";
        }

        if (num2.equals("0")) {
            throw new ZeroDivideArgument("деление на 0");
        }
        return num1 + " / " + num2 + " = " + (Integer.parseInt(num1) / Integer.parseInt(num2));
    }

}
