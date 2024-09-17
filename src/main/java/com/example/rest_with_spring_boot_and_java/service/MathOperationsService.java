package com.example.rest_with_spring_boot_and_java.service;

import com.example.rest_with_spring_boot_and_java.exceptions.UnsupportedMathOperatorException;
import org.springframework.stereotype.Service;

import java.util.function.BinaryOperator;

@Service
public class MathOperationsService {

    private ConfigNumbersService configNumbersService;

    public MathOperationsService(ConfigNumbersService configNumbersService) {
        this.configNumbersService = configNumbersService;
    }


    //TODO tirar verificacoes repetidas
    public Double sum(String num1, String num2){
        configNumbersService.verifyNumber(num1, num2);
        return configNumbersService.convertToDouble(num1) + configNumbersService.convertToDouble(num2);
    }

    public Double sub(String num1, String num2) {
        configNumbersService.verifyNumber(num1, num2);
        return configNumbersService.convertToDouble(num1) - configNumbersService.convertToDouble(num2);
    }

    public Double multi(String num1, String num2) {
        configNumbersService.verifyNumber(num1, num2);
        return configNumbersService.convertToDouble(num1) * configNumbersService.convertToDouble(num2);
    }

    public Double div(String num1, String num2) {
        configNumbersService.verifyNumber(num1, num2);
        return configNumbersService.convertToDouble(num1) / configNumbersService.convertToDouble(num2);
    }

    public Double average(String num1, String num2) {
        configNumbersService.verifyNumber(num1, num2);
        return (configNumbersService.convertToDouble(num1) + configNumbersService.convertToDouble(num2)) / 2;
    }

    public Double sqrt(String num) {
        configNumbersService.verifyNumber(num);
        return Math.sqrt(Double.parseDouble(num));
    }
}
