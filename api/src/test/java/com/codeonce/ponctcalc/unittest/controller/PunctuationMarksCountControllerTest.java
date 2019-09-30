package com.codeonce.ponctcalc.unittest.controller;

import com.codeonce.ponctcalc.controller.PunctuationMarksCountController;
import com.codeonce.ponctcalc.service.PunctuationMarksCountService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@WebMvcTest(PunctuationMarksCountController.class)
public class PunctuationMarksCountControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PunctuationMarksCountService punctuationMarksCountService;

    @Test
    public void testPunctuationMarksCountOutput() throws Exception {
        Mockito.when(punctuationMarksCountService.countFromText(Mockito.anyString())).thenReturn(5);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/").content("some testing text.").accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.countValue").exists())
        .andExpect(MockMvcResultMatchers.jsonPath("$.countValue").value(5));
    }
}
