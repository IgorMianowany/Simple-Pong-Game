package com.example.pong;

public class Score {

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
        return getLeftPlayerScore() + " \t " + getRightPlayerScore();
    }

}
