package br.com.takeshi.spring_boot_rest.service;

import br.com.takeshi.spring_boot_rest.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MathService {

    public Double sum(String number1, String number2){
        if(!isNumeric(number1) || !isNumeric(number2)) throw new ResourceNotFoundException("Please set a numeric value!");
        return convertToDouble(number1) + convertToDouble(number2);
    }

    public  Double subtraction(String number1, String number2){
        if(!isNumeric(number1) || !isNumeric(number2)) throw new ResourceNotFoundException("Please set a numeric value!");
        return convertToDouble(number1) - convertToDouble(number2);
    }

    public Double multiplication(String number1, String number2){
        if(!isNumeric(number1) || !isNumeric(number2)) throw new ResourceNotFoundException("Please  set a number value");
        return convertToDouble(number1) * convertToDouble(number2);
    }

    public Double division(String number1, String number2){
        if(!isNumeric(number1) || !isNumeric(number2)) throw new ResourceNotFoundException("Please  set a number value");
        return convertToDouble(number1) / convertToDouble(number2);    }

    public Double mean(String number1, String number2){
        if(!isNumeric(number1) || !isNumeric(number2)) throw new ResourceNotFoundException("Please  set a number value");
        return convertToDouble(number1) * convertToDouble(number2) / 2;    }

    public List<Double> squareRoot(String number1, String number2){
        if(!isNumeric(number1) || !isNumeric(number2)) throw new ResourceNotFoundException("Please  set a number value");
        double n1 = convertToDouble(number1);
        double n2 = convertToDouble(number2);

        double min = Math.min(n1,n2);
        double max = Math.max(n1,n2);

        List<Double> squares = new ArrayList<>();

        int start = (int) Math.ceil(Math.sqrt(min));
        int end = (int) Math.floor(Math.sqrt(max));

        for (int i = start; i <= end ; i++) {
            squares.add((double) i * i);
        }

        return squares;
    }

    public static Boolean isNumeric(String strNumber){
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",","."); // R$ 5,00
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public static Double convertToDouble(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) throw new ResourceNotFoundException("Please set a numeric value!");
        String number = strNumber.replace(",","."); // R$ 5,00
        return Double.parseDouble(number);
    }
}
