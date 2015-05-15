package org.zhu.netsec.e01;

/**
 * A class used to store a character and its frequency.
 * 
 * @author Chenfeng ZHU
 *
 */
public class CharFrequency implements Comparable<CharFrequency> {

    private char c;
    private double frequency;

    public CharFrequency() {
    }

    public CharFrequency(char c, double frequency) {
        this.c = c;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(CharFrequency o) {
        if (this.frequency > o.frequency) {
            return 1;
        } else if (this.frequency < o.frequency) {
            return -1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return "{" + c + ": " + frequency + "}";
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

}
