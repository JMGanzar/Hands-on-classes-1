package demoapp.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetForm() throws Exception {
        mockMvc.perform(get("/calculator"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculatorForm"));
    }

    @Test
    void testValidCalculation() throws Exception {
        mockMvc.perform(post("/calculator")
                        .param("number1", "6")
                        .param("number2", "2")
                        .param("operation", "divide"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("result"));
    }

    @Test
    void testInvalidInput() throws Exception {
        mockMvc.perform(post("/calculator")
                        .param("number1", "")
                        .param("number2", "2")
                        .param("operation", "add"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculatorForm"));
    }
}