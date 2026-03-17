package org.example;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    private int value;
    private boolean locked;

    public Dice (){
        this.locked = false;
        this.roll();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void roll(){
        if (this.locked){
            return;
        }
        int nOSides = 6;
        this.value = ThreadLocalRandom.current().nextInt(1,nOSides+1);


    }


}
