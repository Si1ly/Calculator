package com.example.calculator;

public class Number {
    String s;
    boolean isNumber;

    public Number(String s, boolean isNumber) {
        this.s = s;
        this.isNumber = isNumber;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public boolean isNumber() {
        return isNumber;
    }

    public void setNumber(boolean number) {
        isNumber = number;
    }
}
