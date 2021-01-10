package com.chinesegame;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BackGraound {
    private final Image board = new Image("file:src/main/resources/board.png");
    private final Image menu = new Image("file:src/main/resources/Chiny.jpg");

    BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
    BackgroundImage backgroundGameImage = new BackgroundImage(board, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
    BackgroundImage backgroundMenuImage = new BackgroundImage(menu, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
    Background gameBackground = new Background(backgroundGameImage);
    Background menuBackGround = new Background(backgroundMenuImage);

    public Background getGameBackground() {
        return gameBackground;
    }
    public Background getMenuBackGround() {
        return menuBackGround;
    }
}

