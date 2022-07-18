package com.example.pong;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class Ball {
    private final double radius = 15;
    private double x;
    private double y;
    private final double startingX;
    private final double startingY;
    private int speedY = 3;
    private int speedX = 3;

    private final PropertyChangeSupport support;
    private final static String LEFT = "LEFT";
    private final static String RIGHT = "RIGHT";

    public Ball(double aStartingX, double aStartingY){
        x = aStartingX;
        y = aStartingY;
        startingX = x;
        startingY = y;
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public double getX() {
        return x;
    }

    public void setX(double aX) {
        x = aX;
    }

    public double getY() {
        return y;
    }

    public void setY(double aY) {
        y = aY;
    }


    public int getSpeedY() {
        return speedY;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(int aSpeedY) {
        speedY = aSpeedY;
    }

    public double getRadius() {
        return radius;
    }

    public void moveBall(){
        setX(getX() + getSpeedX());
        setY(getY() + getSpeedY());
        if(getY() >= startingY * 2 || getY() <= 0){
            setSpeedY(getSpeedY()*-1);
        }
        if(getX() >= startingX * 2 || getX() <= 0){
            if(getX() >= startingX * 2){
                support.firePropertyChange("LEFT",null,"LEFT");
            }
            else if (getX()<=0){
                support.firePropertyChange("RIGHT",null,"RIGHT");
            }
            resetBallPositionAndSpeed();
        }
    }

    public void resetBallPositionAndSpeed(){
        x = startingX;
        y = startingY;
//        speedX = new Random().nextInt(2) == 0 ? 1: -1;
//        speedY = new Random().nextInt(2) == 0 ? 1: -1;
        speedX = speedX * -1;


    }
}
