package com.conduit.test.controller;

import com.conduit.test.model.CalculatorDTO;
import com.conduit.test.util.OperatorsValidation;
import com.conduit.test.view.InputView;
import com.conduit.test.view.OutputView;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculatorController {

    private static InputView inputView;
    private static OutputView outputView;
    private static CalculatorDTO calculatorDTO;

    public CalculatorController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() throws IOException {
        outputView.calStart();
        if (!setOperators(inputView.intputNumber().split(" "))) {
            return;
        }
        BigDecimal answer = calculatorOperators(calculatorDTO);
        outputView.printAnswer(answer);
    }

    public BigDecimal calculatorOperators(CalculatorDTO calculatorDTO) {
        switch (calculatorDTO.getOperation()) {
            case "+":
                return calculatorDTO.getNum1().add(calculatorDTO.getNum2());
            case "-":
                return calculatorDTO.getNum1().subtract(calculatorDTO.getNum2());
            case "*":
                return calculatorDTO.getNum1().multiply(calculatorDTO.getNum2());
            default:
                return calculatorDTO.getNum1().divide(calculatorDTO.getNum2(), 10, RoundingMode.DOWN);
        }
    }

    private boolean setOperators(String[] s) {
        if (OperatorsValidation.checkOperatorsValidation(s)) {
            calculatorDTO = new CalculatorDTO(new BigDecimal(s[0]), s[1], new BigDecimal(s[2]));
            return true;
        } else {
            return false;
        }
    }
}
