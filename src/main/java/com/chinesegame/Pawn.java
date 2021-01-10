package com.chinesegame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pawn {

    private Image yellowPawn = new Image("file:src/main/resources/yellowPawn.png");
    private final Image redPawn = new Image("file:src/main/resources/redPawn.png");
    private final Image greenPawn = new Image("file:src/main/resources/greenPawn.png");
    private final Image bluePawn = new Image("file:src/main/resources/bluePawn.png");

    private final ImageView pawnYellow = new ImageView(yellowPawn);
    private final ImageView pawnRed = new ImageView(redPawn);
    private final ImageView pawnGreen = new ImageView(greenPawn);
    private final ImageView pawnBlue = new ImageView(bluePawn);

    public ImageView getPawnYellow() {
        return pawnYellow;
    }

    public ImageView getPawnRed() {
        return pawnRed;
    }

    public ImageView getPawnGreen() {
        return pawnGreen;
    }

    public ImageView getPawnBlue() {
        return pawnBlue;
    }
}
