package com.codeonce.ponctcalc.service;

import java.util.Map;

public interface ICharacterCountService
{
    public abstract void loadText(String text);
    public abstract int countCharacters(char[] characters);

    public Map<Character, Integer> getCharCounts();
}

