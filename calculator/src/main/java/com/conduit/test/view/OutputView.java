package com.conduit.test.view;

import java.math.BigDecimal;

public class OutputView {
    public void calStart() {
        System.out.println("계산할 숫자와 연산자를 입력해주세요");
    }

    public void printAnswer(BigDecimal answer) {
        System.out.println(answer);
    }
}
