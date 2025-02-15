package demoapp.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EvenNumberServiceTest {

    @Autowired
    private EvenNumberService evenNumberService;

    @Test
    void testEvenNumber() {
        assertTrue(evenNumberService.isEven(4));
    }

    @Test
    void testOddNumber() {
        assertFalse(evenNumberService.isEven(7));
    }

    @Test
    void testZero() {
        assertTrue(evenNumberService.isEven(0)); // Caso límite
    }
}