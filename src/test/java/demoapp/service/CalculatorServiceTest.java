package demoapp.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorServiceTest {

    @Autowired
    private CalculatorService calculatorService;

    @Test
    void testAddition() {
        assertEquals(5, calculatorService.calculate(2, 3, "add"));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () ->
                calculatorService.calculate(5, 0, "divide")
        );
    }

    @Test
    void testInvalidOperation() {
        assertThrows(IllegalArgumentException.class, () ->
                calculatorService.calculate(2, 3, "invalid")
        );
    }
}