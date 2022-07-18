package com.example.pong;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Score implements PropertyChangeListener {

    private int leftPlayerScore = 0;
    private int rightPlayerScore = 0;
    private String lastPoint = null;

    public int getLeftPlayerScore() {
        return leftPlayerScore;
    }

    public int getRightPlayerScore() {
        return rightPlayerScore;
    }

    public void addLeftPlayerPoint(){
        leftPlayerScore += 1;

    }

    public void addRightPlayerPoint(){
        rightPlayerScore += 1;
    }

    public String getScore(){
        return getLeftPlayerScore() + " : " + getRightPlayerScore();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("RIGHT")){
            lastPoint = "RIGHT";
        }
        else if(evt.getPropertyName().equals("LEFT")){
            lastPoint = "LEFT";
        }
    }
}
