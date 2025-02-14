package demoapp.model;

import javax.validation.constraints.NotBlank;

public class PalindromeForm {

    @NotBlank(message = "Word cannot be empty")
    private String word;

    // Getters y Setters
    public String getWord() { return word; }
    public void setWord(String word) { this.word = word; }
}