package com.siddhartha.com.sqlite.bean;

/**
 * Created by BLUEHORSE DEVLOPER on 6/30/2015.
 */
public class items {

    private String Names,numbers;
    private int index;

    public items() {

    }

    public items(String names, String numbers) {
        Names = names;
        this.numbers = numbers;
    }

    public items(String names, String numbers, int index) {
        Names = names;
        this.numbers = numbers;
        this.index = index;
    }

    public String getNames() {
        return Names;
    }

    public void setNames(String names) {
        Names = names;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
