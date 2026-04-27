package br.com.takeshi.spring_boot_rest.controllers;

import br.com.takeshi.spring_boot_rest.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{number1}/{number2}")
    public Double sum(@PathVariable("number1") String number1, @PathVariable("number2") String number2) throws Exception {
        if(!isNumeric(number1) || !isNumeric(number2)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(number1) + convertToDouble(number2);
    }

    public Boolean isNumeric(String strNumber){
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",","."); // R$ 5,00
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public Double convertToDouble(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replace(",","."); // R$ 5,00
        return Double.parseDouble(number);
    }
}
