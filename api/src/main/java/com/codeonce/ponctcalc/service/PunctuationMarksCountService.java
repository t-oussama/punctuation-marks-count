package com.codeonce.ponctcalc.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PunctuationMarksCountService implements IPunctuationMarksCountService {

    final char[] punctuationChars = {',' , '.', ';', ':' , '!' , '?'};

    @Autowired
    CharacterCountService characterCountService;
    

    public PunctuationMarksCountService() {}

    /*
        Uses the CharactersCountService to get the total count of punctuation marks and returns it to the caller.
        This is used to present only a specific functionnality from the wider scope of functionnalities offered by the more generic service CharactersCountService, in order to make it's use simpler.
    */
    public int countFromText(String text) {
        characterCountService.loadText(text);
        return characterCountService.countCharacters(punctuationChars);
    }
}
