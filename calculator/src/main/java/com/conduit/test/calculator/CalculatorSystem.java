package com.conduit.test.calculator;


import com.conduit.test.controller.CalculatorController;
import java.io.IOException;

public class CalculatorSystem {

    public static void main(String[] args) throws IOException {
        CalculatorController calculatorController = new CalculatorController();
        calculatorController.start();
    }
}