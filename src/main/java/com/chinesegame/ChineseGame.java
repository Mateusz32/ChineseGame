package com.chinesegame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChineseGame extends Application {

    BackGraound backGraound = new BackGraound();
    Pages pages = new Pages();
    StackPane stackPanePageIntroduce = new StackPane();
    int width = 960;
    int height = 660;
    Stage window;
    Scene pageIntroduce,pageGame1,pageGame2, pageGame3,pageGame4, pageRules, pageOptions;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        // Page Introduce - Main Page
        stackPanePageIntroduce.setBackground(backGraound.getMenuBackGround());
        Text text = new Text("Welcome to the Chiness Game");
        stackPanePageIntroduce.setAlignment(text, Pos.TOP_CENTER);
        stackPanePageIntroduce.setMargin(text, new Insets(20));

        Button Start = new Button("Start");
        Button Rules = new Button("Rules");
        Button EndGame = new Button("End Game");

        Start.setPrefSize(100, 50);
        Rules.setPrefSize(100, 50);
        EndGame.setPrefSize(100,50);

        stackPanePageIntroduce.setAlignment(Start, Pos.TOP_CENTER);
        stackPanePageIntroduce.setMargin(Start, new Insets(200,0,0,0));
        stackPanePageIntroduce.setAlignment(Rules,Pos.TOP_CENTER);
        stackPanePageIntroduce.setMargin(Rules, new Insets(300,0,0,0));
        stackPanePageIntroduce.setAlignment(EndGame,Pos.TOP_CENTER);
        stackPanePageIntroduce.setMargin(EndGame, new Insets(400,0,0,0));

        //Start.setOnAction(e -> window.setScene(pageGame));

        Start.setOnAction(e -> window.setScene(pageOptions));

        Rules.setOnAction(e -> window.setScene(pageRules));
        EndGame.setOnAction(e->window.close());
        stackPanePageIntroduce.getChildren().addAll(text, Start, Rules,EndGame);
        pageIntroduce = new Scene(stackPanePageIntroduce, width, height, Color.WHITESMOKE);

        pageRules = pages.getPageRule(window, pageIntroduce);
        pageGame1 = pages.getPageGame1(window, pageIntroduce);
        pageGame2 = pages.getPageGame2(window, pageIntroduce);
        pageGame3 = pages.getPageGame3(window, pageIntroduce);
        pageGame4 = pages.getPageGame4(window,pageIntroduce);
        pageOptions = pages.getPageOptions(window,pageIntroduce);


        primaryStage.setTitle("Menu Chinese Game");
        primaryStage.setScene(pageIntroduce);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

