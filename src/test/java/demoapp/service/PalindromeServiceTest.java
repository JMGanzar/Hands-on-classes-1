package demoapp.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PalindromeServiceTest {

    @Autowired
    private PalindromeService palindromeService;

    @Test
    public void testValidPalindrome() {
        assertTrue(palindromeService.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void testInvalidPalindrome() {
        assertFalse(palindromeService.isPalindrome("HelloWorld"));
    }

    @Test
    public void testEmptyString() {
        assertTrue(palindromeService.isPalindrome("")); // Considerar caso límite
    }
}