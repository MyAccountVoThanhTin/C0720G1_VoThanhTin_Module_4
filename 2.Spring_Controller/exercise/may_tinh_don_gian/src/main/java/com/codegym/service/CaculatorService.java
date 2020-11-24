package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class CaculatorService {
    public String caculator(String num1, String num2, String caculator) {
        String result = null;
        int num3 = 0, num4 = 0;
        if (num1.equals("0")) {
            num3 = 0;
            if (num2.equals("0")) {
                num4 = 0;
            }
        } else {
            num3 = Integer.parseInt(num1);
            num4 = Integer.parseInt(num2);
        }

        if (caculator.equals("Addition(+)")) {
            result = "Addition : " + (num3 + num4);
        } else if (caculator.equals("Subtraction(-)")) {
            result = "Subtraction : " + (num3 - num4);
        } else if (caculator.equals("Multiplication(X)")) {
            result = "Multiplication : " + (num3 * num4);
        } else if (caculator.equals("Division(/)")) {
            if (num3 == 0) {
                result = "Not Division When numerator is 0 !";
            } else {
                result = "Division : " + (num3 / num4);
            }
        }
        return result;
    }
}
