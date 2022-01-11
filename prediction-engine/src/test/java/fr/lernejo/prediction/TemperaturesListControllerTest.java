package fr.lernejo.prediction;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class TemperaturesListControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void PaysInconnus() throws Exception  {

        mvc.perform(MockMvcRequestBuilders.get("/api/temperature?country=ESIEALand")).andExpect(MockMvcResultMatchers.status().isExpectationFailed());
    }

    @Test
    public void PaysConnus() throws Exception  {

        mvc.perform(MockMvcRequestBuilders.get("/api/temperature?country=France")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
