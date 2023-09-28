package org.example;
import java.util.List;

public class Lion {
    private boolean hasMane;
    private Feline feline;

    public Lion(String gender, Feline feline) throws Exception {
        this.feline = feline;
        if ("Самец".equals(gender)) {
            hasMane = true;
        } else if ("Самка".equals(gender)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}