package com.example.rest_with_spring_boot_and_java.controller;

import com.example.rest_with_spring_boot_and_java.service.MathOperationsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathOperationsController {

    private MathOperationsService mathOperationsService;

    public MathOperationsController(MathOperationsService mathOperationsService) {
        this.mathOperationsService = mathOperationsService;
    }

    @RequestMapping("/sum/{number1}/{number2}")
    public Double sum(@PathVariable(value = "number1") String number1, @PathVariable("number2") String number2){
        return mathOperationsService.sum(number1, number2);
    }

    @RequestMapping("/sub/{number1}/{number2}")
    public Double sub(@PathVariable(value = "number1") String number1, @PathVariable("number2") String number2){
        return mathOperationsService.sub(number1, number2);

    }

    @RequestMapping("/multi/{number1}/{number2}")
    public Double multi(@PathVariable(value = "number1") String number1, @PathVariable("number2") String number2){
        return mathOperationsService.multi(number1, number2);
    }

    @RequestMapping("/div/{number1}/{number2}")
    public Double div(@PathVariable(value = "number1") String number1, @PathVariable("number2") String number2){
        return mathOperationsService.div(number1, number2);
    }

    @RequestMapping("/average/{number1}/{number2}")
    public Double average(@PathVariable(value = "number1") String number1, @PathVariable("number2") String number2){
        return mathOperationsService.average(number1, number2);
    }

    @RequestMapping("/sqrt/{number}")
    public Double sqrt(@PathVariable(value = "number") String number){
        return mathOperationsService.sqrt(number);

    }
}
