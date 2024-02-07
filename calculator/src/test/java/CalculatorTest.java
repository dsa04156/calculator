import static org.assertj.core.api.Assertions.assertThat;

import com.conduit.test.controller.CalculatorController;
import com.conduit.test.model.CalculatorDTO;
import com.conduit.test.util.OperatorsValidation;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    void 유효하지_않은_연산자가_포함된_입력_테스트() {
        String input = "123+ 123";
        boolean result = OperatorsValidation.checkOperatorsValidation(input.split(" "));
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 유효하지_않은_연산자가_포함된_입력_테스트2() {
        String input = "123 a 123";
        boolean result = OperatorsValidation.checkOperatorsValidation(input.split(" "));
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 숫자가_아닌_문자가_포함된_입력_테스트() {
        String input = "abc + def";
        boolean result = OperatorsValidation.checkOperatorsValidation(input.split(" "));
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 형식이_올바르지_않은_입력_테스트() {
        String input = "123 + 456 +";
        boolean result = OperatorsValidation.checkOperatorsValidation(input.split(" "));
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 유효한_연산자가_포함된_입력_테스트() {
        String input = "123 + 456";
        boolean result = OperatorsValidation.checkOperatorsValidation(input.split(" "));
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 덧셈_테스트() {
        BigDecimal operand1 = new BigDecimal("5.4");
        BigDecimal operand2 = new BigDecimal("3.5");
        BigDecimal expectedSum = new BigDecimal("8.9");

        CalculatorController calculatorController = new CalculatorController();
        BigDecimal sum = calculatorController.calculatorOperators(new CalculatorDTO(operand1, "+", operand2));

        assertThat(sum).isEqualByComparingTo(expectedSum);
    }

    @Test
    void 뺄셈_테스트() {
        BigDecimal operand1 = new BigDecimal("5");
        BigDecimal operand2 = new BigDecimal("3");
        BigDecimal expectedDifference = new BigDecimal("2");

        CalculatorController calculatorController = new CalculatorController();
        BigDecimal diff = calculatorController.calculatorOperators(new CalculatorDTO(operand1, "-", operand2));

        assertThat(diff).isEqualByComparingTo(expectedDifference);
    }

    @Test
    void 곱셈_테스트() {
        BigDecimal operand1 = new BigDecimal("5.5");
        BigDecimal operand2 = new BigDecimal("3.5");
        BigDecimal expectedProduct = new BigDecimal("19.25");

        CalculatorController calculatorController = new CalculatorController();
        BigDecimal product = calculatorController.calculatorOperators(new CalculatorDTO(operand1, "*", operand2));

        assertThat(product).isEqualByComparingTo(expectedProduct);
    }

    @Test
    void 나눗셈_테스트() {
        BigDecimal operand1 = new BigDecimal("5");
        BigDecimal operand2 = new BigDecimal("3");
        BigDecimal expectedQuotient = new BigDecimal("1.6666666666");

        CalculatorController calculatorController = new CalculatorController();
        try {
            BigDecimal quotient = calculatorController.calculatorOperators(new CalculatorDTO(operand1, "/", operand2));
            assertThat(quotient).isEqualByComparingTo(expectedQuotient);
        } catch (ArithmeticException e) {
            // 예외 처리
            System.out.println("나눗셈 결과가 정확하게 표현할 수 없습니다.");
        }
    }
}
