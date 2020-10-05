package com.java.jungle.model;

import java.util.ArrayList;

public class random {

    private int randomNum;
    private String randomString;
    private boolean isRandom;

    ArrayList<String> arrayString = new ArrayList<>();


    random() {

    }

    public random(int randomNum, String randomString, boolean isRandom) {
        this.randomNum = randomNum;
        this.randomString = randomString;
        this.isRandom = isRandom;
    }

    public int getRandomNum() {
        return randomNum;
    }

    public void setRandomNum(int randomNum) {
        this.randomNum = randomNum;
    }

    public String getRandomString() {
        return randomString;
    }

    public void setRandomString(String randomString) {
        this.randomString = randomString;
    }

    public boolean isRandom() {
        return isRandom;
    }

    public void setRandom(boolean random) {
        isRandom = random;
    }
}
