package demoapp.controller;

import demoapp.model.PalindromeForm;
import demoapp.service.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PalindromeController {

    @Autowired
    private PalindromeService palindromeService;

    @GetMapping("/palindrome")
    public String showForm(PalindromeForm palindromeForm) {
        return "palindromeForm";
    }

    @PostMapping("/palindrome")
    public String checkPalindrome(
            @Valid @ModelAttribute PalindromeForm palindromeForm,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "palindromeForm";
        }

        boolean result = palindromeService.isPalindrome(palindromeForm.getWord());
        model.addAttribute("isPalindrome", result);
        model.addAttribute("originalWord", palindromeForm.getWord());

        return "palindromeResult";
    }
}