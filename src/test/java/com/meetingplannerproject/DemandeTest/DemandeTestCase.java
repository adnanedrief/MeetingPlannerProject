package com.meetingplannerproject.DemandeTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DemandeTestCase {
    @Autowired
    private MockMvc mockMvc;
    @Order(1)
    @Test
    public void getAllDemandesTest() throws Exception {
        this.mockMvc.perform(get("/allDemandes"))
                .andDo(print())
                .andExpect(status().isOk());
                //.andExpect(content().string("[]"));
    }
    /*
    @Order(2)
    @Test
    public void AjoutDemandeTest() throws Exception {
        //add
        Map<String,Object> body = new HashMap<>();
        body.put("date","2022-01-03T9:00:00");
        body.put("reunionid","15");
        body.put("debut",2022-01-03T9:00:00");
        body.put("find","2022-01-03T10:00:00);
        body.put("nbrrequis","7");
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(MockMvcRequestBuilders.post("/ajouterdemande")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(body))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
     */
}
