package com.codegym.entity;

public class Mycounter {
    private int count;

    public Mycounter() {
    }

    public Mycounter(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int increment() {
        return count++;
    }
}
