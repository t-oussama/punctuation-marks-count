package com.codeonce.ponctcalc.unittest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import com.codeonce.ponctcalc.service.CharacterCountService;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class CharactersCountServiceTest
{
    private final String text = "aaaaa eeee xyz";

    private CharacterCountService characterCountService = new CharacterCountService();

    @Test
    public void testCharactersCounts() {
        final Map<Character, Integer> referenceCharacterCounts = new HashMap<Character, Integer>();
        
        characterCountService.loadText(text);
        referenceCharacterCounts.put('a', 5);
        referenceCharacterCounts.put('e', 4);
        referenceCharacterCounts.put(' ', 2);
        referenceCharacterCounts.put('x', 1);
        referenceCharacterCounts.put('y', 1);
        referenceCharacterCounts.put('z', 1);
        Map<Character, Integer> characterCounts = characterCountService.getCharCounts();

        assertTrue(characterCounts.equals(referenceCharacterCounts));
    }

    @Test
    public void testCharactersTotalCount() {
        final char[] characters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        characterCountService.loadText(text);

        assertEquals(characterCountService.countCharacters(characters), 12);
    }
}
