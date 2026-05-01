package br.com.takeshi.spring_boot_rest.controllers;

import br.com.takeshi.spring_boot_rest.service.MathService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/math")
public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @RequestMapping("/sum/{number1}/{number2}")
    public Double sum(@PathVariable("number1") String number1, @PathVariable("number2") String number2) throws Exception {
        return mathService.sum(number1,number2);
    }

    @RequestMapping("/subtraction/{number1}/{number2}")
    public Double subtraction(@PathVariable("number1") String number1, @PathVariable("number2") String number2) throws Exception {
        return mathService.subtraction(number1, number2);
    }

    @RequestMapping("/multiplication/{number1}/{number2}")
    public Double multiplication(@PathVariable("number1") String number1, @PathVariable("number2") String number2) throws Exception {
        return mathService.multiplication(number1, number2);
    }

    @RequestMapping("/division/{number1}/{number2}")
    public Double division(@PathVariable("number1") String number1, @PathVariable("number2") String number2) throws Exception {
        return mathService.division(number1, number2);
    }

    @RequestMapping("/mean/{number1}/{number2}")
    public Double mean(@PathVariable("number1") String number1, @PathVariable("number2") String number2) throws Exception {
        return mathService.mean(number1, number2);
    }

    @RequestMapping("/squareroot/{number1}/{number2}")
    public List<Double> squareRoot(@PathVariable("number1") String number1, @PathVariable("number2") String number2) throws Exception {
        return mathService.squareRoot(number1, number2);
    }
}
