package demoapp.service;

import org.springframework.stereotype.Service;

@Service
public class PalindromeService {

    public boolean isPalindrome(String word) {
        String cleanWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String reversed = new StringBuilder(cleanWord).reverse().toString();
        return cleanWord.equals(reversed);
    }
}