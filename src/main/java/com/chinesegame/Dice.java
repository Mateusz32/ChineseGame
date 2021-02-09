package com.chinesegame;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.Random;

public class Dice {

    Random generated = new Random();

    public int generatedAndDisplayResultForHumanPlayer(int actualPositionOfPosition,String level, Label lable, GridPane grid) {
        int diceResult;
        if (level.equals("Beginer") && actualPositionOfPosition==0) {
            diceResult = 6;
            String text = String.valueOf(diceResult);
            grid.getChildren().remove(lable);
            lable.setText("Dice result: " + text);
            grid.getChildren().add(lable);
        } else {
            diceResult = generated.nextInt(6) + 1;
            String text = String.valueOf(diceResult);
            grid.getChildren().remove(lable);
            lable.setText("Dice result: " + text);
            grid.getChildren().add(lable);
        }
        return diceResult;
    }

    public int generatedAndDisplayResultForComputerPlayer(int actualPositionOfPosition,String level, Label lable, GridPane grid) {
        int diceResult;
        if (level.equals("Hard")&& actualPositionOfPosition==0) {
            diceResult = 6;
            String text = String.valueOf(diceResult);
            grid.getChildren().remove(lable);
            lable.setText("Dice result: " + text);
            grid.getChildren().add(lable);
        } else {
            diceResult = generated.nextInt(6) + 1;
            String text = String.valueOf(diceResult);
            grid.getChildren().remove(lable);
            lable.setText("Dice result: " + text);
            grid.getChildren().add(lable);
        }
        return diceResult;
    }

}
