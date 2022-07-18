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
    private double speed = 0.5;
    private double speedY = speed;
    private double speedX = speed;

    private Score score;

    private final PropertyChangeSupport support;
    private final static String LEFT = "LEFT";
    private final static String RIGHT = "RIGHT";

    private String lastPoint = null;

    private final Player leftPlayer;

    private final Player rightPlayer;

    public Ball(double aStartingX, double aStartingY,Score aScore, Player aLeftPlayer, Player aRightPlayer){
        x = aStartingX;
        y = aStartingY;
        startingX = x;
        startingY = y;
        score = aScore;
        support = new PropertyChangeSupport(this);
        leftPlayer = aLeftPlayer;
        rightPlayer = aRightPlayer;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(LEFT,pcl);
        support.addPropertyChangeListener(RIGHT,pcl);
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


    public double getSpeedY() {
        return speedY;
    }

    public double getSpeedX() {
        return speedX;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(double aSpeedY) {
        speedY = aSpeedY;
    }

    public double getRadius() {
        return radius;
    }

    public void bounce(){

    }

    public void movement(){
        setX(getX() + getSpeedX());
        setY(getY() + getSpeedY());
    }

    public void moveBall(){
        if(getY() + radius/2 >= startingY * 2 || getY() + radius/2 <= 0){
            setSpeedY(getSpeedY()*-1);
        }

        if(((getX() > rightPlayer.getX() - rightPlayer.getWidth())
                && getY() >= rightPlayer.getY()
                && getY() <= rightPlayer.getY() + rightPlayer.getHeight())
                ||
                ((getX() < leftPlayer.getX() + leftPlayer.getWidth())
                && getY() >= leftPlayer.getY()
                && getY() <= leftPlayer.getY() + leftPlayer.getHeight())) {
            speedY = speedY + Math.signum(speedY) - .5;
            speedX = speedX + Math.signum(speedX) - .5;
            speedX *= -1;
        }

        if(getX() >= startingX * 2 || getX() <= 0){
            if(getX() >= startingX * 2){
                lastPoint = LEFT;
                score.addLeftPlayerPoint();
            }
            else if (getX()<=0){
                lastPoint = RIGHT;
                score.addRightPlayerPoint();
            }
            resetBallPositionAndSpeed();
        }
    }

    public void resetBallPositionAndSpeed(){
        support.firePropertyChange(lastPoint,null,lastPoint);
        x = startingX;
        y = startingY;
        speedX = new Random().nextInt(2) == 0 ? speed: -speed;
        speedY = new Random().nextInt(2) == 0 ? speed: -speed;


    }
}
