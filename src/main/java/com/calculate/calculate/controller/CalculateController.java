package com.calculate.calculate.controller;

import com.calculate.calculate.service.CalculateService;
import com.calculate.calculate.service.CalculateServiceImpl;
import org.springframework.web.bind.annotation.*;


@RestController
public class CalculateController {
    private final CalculateService service;

    public CalculateController(){
        service = new CalculateServiceImpl();
    }

    @GetMapping
    public String majorPage(){
        return service.major();
    }

    @GetMapping("/plus")
    public String plusPage(@RequestParam(value = "num1", required = false) String num1,
                           @RequestParam(value = "num2", required = false) String num2){
       return service.plus(num1, num2);
    }

    @GetMapping("/minus")
    public String minusPage(@RequestParam(value = "num1", required = false) String num1,
                            @RequestParam(value = "num2", required = false) String num2){
        return service.minus(num1, num2);
    }

    @GetMapping("/multiply")
    public String multiplyPage(@RequestParam(value = "num1", required = false) String num1,
                               @RequestParam(value = "num2", required = false) String num2){
        return service.multiply(num1, num2);
    }

    @GetMapping("/divide")
    public String dividePage(@RequestParam(value = "num1", required = false) String num1,
                             @RequestParam(value = "num2", required = false) String num2){
        return service.divide(num1, num2);
    }




}
