package com.conduit.test.model;

import java.math.BigDecimal;

public class CalculatorDTO {
    private BigDecimal num1;
    private String operation;
    private BigDecimal num2;

    public CalculatorDTO(BigDecimal num1, String operation, BigDecimal num2) {
        this.num1 = num1;
        this.operation = operation;
        this.num2 = num2;
    }

    public CalculatorDTO() {

    }

    public BigDecimal getNum1() {
        return num1;
    }

    public void setNum1(BigDecimal num1) {
        this.num1 = num1;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public BigDecimal getNum2() {
        return num2;
    }

    public void setNum2(BigDecimal num2) {
        this.num2 = num2;
    }

    @Override
    public String toString() {
        return "CalculatorDTO{" +
                "num1=" + num1 +
                ", operation='" + operation + '\'' +
                ", num2=" + num2 +
                '}';
    }
}
