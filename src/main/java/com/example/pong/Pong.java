package com.example.pong;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Pong extends Application {

    private final double width = 700;
    private final double height = 500;
    private final Player player = new Player();
    private final Player opponent = new Player();
    private final Score score = new Score();
    private final Ball ball = new Ball(width/2, height/2, score);

    private boolean gameStarted;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Pong");
        Canvas canvas = new Canvas(width,height);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10),e -> run(graphicsContext) ));
        timeline.setCycleCount(Animation.INDEFINITE);

        canvas.setOnMouseMoved(e -> player.setY(e.getY()));
        canvas.setOnMouseClicked(e -> gameStarted = true );

        Scene scene = new Scene(new StackPane(canvas));
        stage.setScene(scene);
        stage.show();
        timeline.play();
    }

    private void run(GraphicsContext graphicsContext) {
        ball.addPropertyChangeListener(score);
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0,0,width,height);

        graphicsContext.setFill(Color.WHITE);
        graphicsContext.setFont(Font.font(25));

        if(gameStarted){
            ball.moveBall();

            //Opponent
            opponent.setY(ball.getY());

            graphicsContext.fillOval(ball.getX(), ball.getY(), ball.getRadius(), ball.getRadius() );
        }
        else{
            graphicsContext.setStroke(Color.WHITE);
            graphicsContext.setTextAlign(TextAlignment.CENTER);
            graphicsContext.strokeText("Start", width/2,height/2);

            ball.resetBallPositionAndSpeed();
        }

        graphicsContext.setStroke(Color.WHITE);
        graphicsContext.setTextAlign(TextAlignment.CENTER);
        graphicsContext.strokeText(score.getScore(), width/2,30);

    }

    public static void main(String[] args) {
        launch();

    }
}