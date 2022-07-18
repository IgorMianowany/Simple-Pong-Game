package com.example.pong;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Score implements PropertyChangeListener {

    private int leftPlayerScore = 0;
    private int rightPlayerScore = 0;

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
        return leftPlayerScore + " : " + rightPlayerScore;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String value = (String) evt.getNewValue();
        if(value.equals("RIGHT")){
            addRightPlayerPoint();
        }
        else if(value.equals("LEFT")){
            addLeftPlayerPoint();
        }
    }
}
