package com.codeonce.ponctcalc.dto;

/*
    Data Transfer Object for Character count results.
*/
public class CountDTO {
    private int countValue;
    
    public CountDTO(int count) {
        countValue = count;
    }

    public int getCountValue() {
        return countValue;
    }

    public void setCountValue(int count) {
        countValue = count;
    }
}