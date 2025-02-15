package demoapp.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SquareServiceTest {

    @Autowired
    private SquareService squareService;

    @Test
    void testValidSquare() {
        assertTrue(squareService.isSquare(3, 9));
    }

    @Test
    void testInvalidSquare() {
        assertFalse(squareService.isSquare(3, 10));
    }

    @Test
    void testNegativeBase() {
        assertTrue(squareService.isSquare(-4, 16)); // (-4)^2 = 16
    }
}