package com.chinesegame;

import javafx.application.Application;
import javafx.stage.Stage;

public class ChineseGame extends Application {
    Pages pages = new Pages();

    @Override
    public void start(Stage primaryStage) throws Exception {

        pages.getPageIntroduce();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

