package com.example.pong;


public class Player {
    private final double width = 10;
    private final double height = 100;
    private final double x;
    private double y;

    public Player(final int aX){
        x = aX;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getY(){
        return y;
    }

    public void setY(double aY) {
        y = aY;
    }

    public double getX() {
        return x;
    }
}
