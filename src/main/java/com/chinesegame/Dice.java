package com.chinesegame;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.Random;

public class Dice {

    Random generated = new Random();

    public int generatedAndDisplayResultForEachPlayer(Label lable, GridPane grid) {
        int diceResult = generated.nextInt(6) + 1;
        String text = String.valueOf(diceResult);
        grid.getChildren().remove(lable);
        lable.setText("Dice result: " + text);
        grid.getChildren().add(lable);
        return diceResult;
    }
}
