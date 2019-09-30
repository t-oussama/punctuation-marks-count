package com.codeonce.ponctcalc.service;

import java.util.HashMap;
import java.util.Map; 
import org.springframework.stereotype.Service;


@Service
public class CharacterCountService implements ICharacterCountService {

    private String text;

    // A map that saves all chars in a text and the occurences of each one.
    private Map<Character, Integer> charCounts;


    public CharacterCountService() {
        charCounts = new HashMap<Character, Integer>();
        text = "";
    }

    /* 
        Saves the text to be used and counts character occurences.
        Later on, these occurences can be used directly, so if we need to calculate the occurences of two different sets of characters,
        we wouldn't have to do all of the calculations twice, once for each set, but instead only the "countCharacters" part will be called more then once.
        Fore more details on why this approach was chosen over calculating the occurences of the characters we need only, please refer to the documentation.
    */
    public void loadText(String newText) {
        text = newText;
        charCounts.clear();
        for(int i = 0; i < text.length(); i++)
        {
            Character c = text.charAt(i);
            Integer count = charCounts.get(c);
            if(count == null)
            {
                charCounts.put(c, new Integer(1));
            }
            else
            {
                charCounts.put(c, count + 1);
            }
        }
    }

    /*
        Using the previousely calculated characters occurences, calculates the total occurences of a given set of characters
        For e.g: punctuation marks, lower case alphabet, numbers, white spaces, etc...
    */
    public int countCharacters(char[] characters) {
        int count = 0;
        for(int i = 0; i < characters.length; i ++)
        {
            Integer CharCount = charCounts.get(characters[i]);
            if (CharCount != null)
            {
                count += CharCount;
            }
        }
        return count;
    }

    
    public Map<Character, Integer> getCharCounts() {
        return charCounts;
    }
}
