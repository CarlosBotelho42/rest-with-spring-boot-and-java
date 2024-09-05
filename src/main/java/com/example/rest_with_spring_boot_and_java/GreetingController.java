package com.example.rest_with_spring_boot_and_java;

import com.example.rest_with_spring_boot_and_java.exceptions.UnsupportedMathOperatorException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

// TODO Separar as regras d enegocio do controller
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("/sum/{number1}/{number2}")
    public Double sum(@PathVariable(value = "number1") String number1, @PathVariable("number2") String number2){
        verifyNumber(number1, number2);
        return convertToDouble(number1) + convertToDouble(number2);
    }

    @RequestMapping("/sub/{number1}/{number2}")
    public Double sub(@PathVariable(value = "number1") String number1, @PathVariable("number2") String number2){
        verifyNumber(number1, number2);
        return convertToDouble(number1) - convertToDouble(number2);
    }

    @RequestMapping("/multi/{number1}/{number2}")
    public Double multi(@PathVariable(value = "number1") String number1, @PathVariable("number2") String number2){
        verifyNumber(number1, number2);
        return convertToDouble(number1) * convertToDouble(number2);
    }

    @RequestMapping("/div/{number1}/{number2}")
    public Double div(@PathVariable(value = "number1") String number1, @PathVariable("number2") String number2){
        verifyNumber(number1, number2);
        return convertToDouble(number1) / convertToDouble(number2);
    }

    @RequestMapping("/average/{number1}/{number2}")
    public Double average(@PathVariable(value = "number1") String number1, @PathVariable("number2") String number2){
        verifyNumber(number1, number2);
        return (convertToDouble(number1) + convertToDouble(number2)) / 2;
    }

    @RequestMapping("/sqrt/{number}")
    public Double sqrt(@PathVariable(value = "number") String number){
        verifyNumber(number);
        return Math.sqrt(Double.parseDouble(number));
    }

    private void verifyNumber(String number1, String number2) {
        if (!isNumeric(number1) || !isNumeric(number2)) {
            throw new UnsupportedMathOperatorException("Operacao permida apenas com valores numericos!");
        }
    }

    private void verifyNumber(String number) {
        if (!isNumeric(number)) {
            throw new UnsupportedMathOperatorException("Operacao permida apenas com valores numericos!");
        }
    }

    private Double convertToDouble(String strNumber) {
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
