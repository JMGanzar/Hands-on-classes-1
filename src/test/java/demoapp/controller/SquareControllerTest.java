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
public class SquareControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetForm() throws Exception {
        mockMvc.perform(get("/square"))
                .andExpect(status().isOk())
                .andExpect(view().name("squareForm"));
    }

    @Test
    void testValidSquareSubmission() throws Exception {
        mockMvc.perform(post("/square")
                        .param("base", "5")
                        .param("numberToCheck", "25"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("isSquare", true));
    }

    @Test
    void testInvalidInput() throws Exception {
        mockMvc.perform(post("/square")
                        .param("base", "") // Campo vacío
                        .param("numberToCheck", "25"))
                .andExpect(status().isOk())
                .andExpect(view().name("squareForm"));
    }
}