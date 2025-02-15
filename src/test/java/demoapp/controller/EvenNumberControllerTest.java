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
public class EvenNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetForm() throws Exception {
        mockMvc.perform(get("/even"))
                .andExpect(status().isOk())
                .andExpect(view().name("evenForm"));
    }

    @Test
    void testValidSubmission() throws Exception {
        mockMvc.perform(post("/even")
                        .param("number", "8"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("isEven", true));
    }

    @Test
    void testInvalidInput() throws Exception {
        mockMvc.perform(post("/even")
                        .param("number", "")) // Campo vacío
                .andExpect(status().isOk())
                .andExpect(view().name("evenForm"));
    }
}