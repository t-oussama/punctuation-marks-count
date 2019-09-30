package com.codeonce.ponctcalc.unittest.service;

import com.codeonce.ponctcalc.service.CharacterCountService;
import com.codeonce.ponctcalc.service.PunctuationMarksCountService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PunctuationMarksCountServiceTest {
  
    @MockBean
    private CharacterCountService characterCountService;

    @Autowired
    private PunctuationMarksCountService punctuationMarksCountService;

    @BeforeEach
    private void setup() {
        Mockito.when(characterCountService.countCharacters(Mockito.any(char[].class))).thenReturn(6);
    }

    @Test
    public void testPunctuationMarksTotalCount() {
        assertEquals(punctuationMarksCountService.countFromText(""), 6);
    }
}
