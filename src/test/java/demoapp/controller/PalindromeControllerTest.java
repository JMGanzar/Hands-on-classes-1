package demoapp.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PalindromeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetForm() throws Exception {
        mockMvc.perform(get("/palindrome"))
                .andExpect(status().isOk())
                .andExpect(view().name("palindromeForm"));
    }

    @Test
    public void testValidPalindromeSubmission() throws Exception {
        mockMvc.perform(post("/palindrome")
                        .param("word", "Racecar"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("isPalindrome", true));
    }

    @Test
    public void testInvalidSubmission() throws Exception {
        mockMvc.perform(post("/palindrome")
                        .param("word", "")) // Campo vacío
                .andExpect(status().isOk())
                .andExpect(view().name("palindromeForm"));
    }
}