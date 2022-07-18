package com.example.pong;


public class Player {
    private final int width = 20;
    private final int height = 100;
    private double y;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public double getY(){
        return y;
    }

    public void setY(double aY) {
        y = aY;
    }
}
