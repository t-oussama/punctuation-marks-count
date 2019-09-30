package com.codeonce.ponctcalc.controller;

import com.codeonce.ponctcalc.dto.CountDTO;
import com.codeonce.ponctcalc.service.PunctuationMarksCountService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

/*
    Handles requests related to counting punctuation marks.
*/
@RestController(value="/")
public class PunctuationMarksCountController
{
    @Autowired
    private PunctuationMarksCountService PunctuationMarksCountServiceService;

    public PunctuationMarksCountController() { }

    /*
        Counts Punctuation Marks in a given text
        * Returns a CountDTO object as json
    */
    @PostMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountDTO> CountInText(@RequestBody String text)
    {
        int count = PunctuationMarksCountServiceService.countFromText(text);
        return new ResponseEntity<CountDTO>(new CountDTO(count), HttpStatus.OK);
    }
}
