package com.example.rest_with_spring_boot_and_java.service;

import com.example.rest_with_spring_boot_and_java.exceptions.UnsupportedMathOperatorException;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
public class ConfigNumbersService {

    public void verifyNumber(String number) {
        if (!isNumeric(number)) {
            throw new UnsupportedMathOperatorException("Operacao permida apenas com valores numericos!");
        }
    }

    public void verifyNumber(String number1, String number2) {
        if (!isNumeric(number1) || !isNumeric(number2)) {
            throw new UnsupportedMathOperatorException("Operacao permida apenas com valores numericos!");
        }
    }

    public Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replace(",", ".");
        if (isNumeric(number)) {
            return Double.valueOf(number);
        }
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replace(",", ".");
        return number.matches("^-?\\d+(\\.\\d+)?$");
    }

}
