package com.chinesegame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pages {

    int width = 840;
    int height = 660;
    Stage window = new Stage();

    public Scene getPageIntroduce() {

        BackGraound backGraound = new BackGraound();
        StackPane stackPanePageIntroduce = new StackPane();

        stackPanePageIntroduce.setBackground(backGraound.getMenuBackGround());
        Text text = new Text("Welcome to the Chiness Game");
        stackPanePageIntroduce.setAlignment(text, Pos.TOP_CENTER);
        stackPanePageIntroduce.setMargin(text, new Insets(20));

        Button Start = new Button("Start");
        Button Rules = new Button("Rules");
        Button EndGame = new Button("End Game");

        Start.setPrefSize(100, 50);
        Rules.setPrefSize(100, 50);
        EndGame.setPrefSize(100, 50);

        stackPanePageIntroduce.setAlignment(Start, Pos.TOP_CENTER);
        stackPanePageIntroduce.setMargin(Start, new Insets(200, 0, 0, 0));
        stackPanePageIntroduce.setAlignment(Rules, Pos.TOP_CENTER);
        stackPanePageIntroduce.setMargin(Rules, new Insets(300, 0, 0, 0));
        stackPanePageIntroduce.setAlignment(EndGame, Pos.TOP_CENTER);
        stackPanePageIntroduce.setMargin(EndGame, new Insets(400, 0, 0, 0));
        stackPanePageIntroduce.getChildren().addAll(text, Start, Rules, EndGame);

        Scene pageIntroduce = new Scene(stackPanePageIntroduce, width, height, Color.WHITESMOKE);

        Start.setOnAction(e -> {
            Scene pageOptions = getPageOptions();
            window.setScene(pageOptions);
        });
        Rules.setOnAction(e -> {
            Scene pageRules = getPageRule();
            window.setScene(pageRules);
        });
        EndGame.setOnAction(e -> window.close());
        window.setTitle("Menu Chinese Game");
        window.setScene(pageIntroduce);
        window.show();
        return pageIntroduce;
    }

    public Scene getPageRule() {
        StackPane stackPanePageRules = new StackPane();
        Text rules = new Text("The ruls of game:" + "\n"
                + "- The game need two, three or four players." + "\n"
                + "- Each player has 4 pawns. Each 4 pawns of players are the same color (yellow, greeen, red, blue." + "\n"
                + "- At the begining all 4 pawns occupied in home." + "\n"
                + "- Every Player roll the dice ones" + "\n"
                + "- If result of dice is 6, Player can move one pawn to the first positions." + "\n"
                + "- Then the player moves the pawn as many positions as the dice rolled" + "\n"
                + "- If the pawn achived the last posioton (home position), in the next turn has to rolled 6 to mve the next new pawn to the first position" + "\n"
                + "- If pawn of one Player has the same postion of second Player, the pawn of second player back to the home" + "\n"
                + "- Winner is Player who first fill home posiotion"
        );
        Button back = new Button("Back");
        back.setPrefSize(80, 40);
        stackPanePageRules.setAlignment(back, Pos.BOTTOM_LEFT);
        stackPanePageRules.setMargin(back, new Insets(0, 0, 10, 10));
        stackPanePageRules.setMargin(rules, new Insets(30, 30, 30, 30));

        back.setOnAction(e -> {
            Scene pageIntroduce = getPageIntroduce();
            window.setScene(pageIntroduce);
        });

        stackPanePageRules.getChildren().addAll(back, rules);
        Scene pageRules = new Scene(stackPanePageRules, width, height, Color.BLACK);
        window.setScene(pageRules);
        window.show();
        return pageRules;
    }

    String textDice = " ";
    Dice dice = new Dice();
    Moves moves = new Moves();
    RowConstraints row = new RowConstraints();
    ColumnConstraints column = new ColumnConstraints();
    BackGraound game = new BackGraound();
    int actualPositionOfYellow = 0;
    int actualPositionOfGreen = 0;
    int actualPositionOfRed = 0;
    int actualPositionOfBlue = 0;

    public Scene getPageOptions() {
        StackPane stackPanePageOptions = new StackPane();
        TextField namePalyer1 = new TextField();
        TextField namePalyer2 = new TextField();
        TextField namePalyer3 = new TextField();
        TextField namePalyer4 = new TextField();
        Label label = new Label("How many player will be play?");
        stackPanePageOptions.setAlignment(label, Pos.TOP_CENTER);
        stackPanePageOptions.setMargin(label, new Insets(70, 0, 0, 0));

        Button next = new Button("Next");
        stackPanePageOptions.setAlignment(next, Pos.BOTTOM_RIGHT);
        stackPanePageOptions.setMargin(next, new Insets(0, 10, 10, 0));
        stackPanePageOptions.getChildren().removeAll(namePalyer1, namePalyer2, namePalyer3, namePalyer4, next);

        MenuItem item1 = new MenuItem("1");
        MenuItem item2 = new MenuItem("2");
        MenuItem item3 = new MenuItem("3");
        MenuItem item4 = new MenuItem("4");
        MenuItem item5 = new MenuItem("Beginer");
        MenuItem item6 = new MenuItem("Medium");
        MenuItem item7 = new MenuItem("Hard");

        MenuButton menuButton = new MenuButton(item1.getText(), null, item1, item2, item3, item4);
        stackPanePageOptions.setAlignment(menuButton, Pos.TOP_CENTER);
        stackPanePageOptions.setMargin(menuButton, new Insets(200));
        MenuButton menuButton2 = new MenuButton(item6.getText(), null, item5, item6, item7);
        stackPanePageOptions.setAlignment(menuButton2, Pos.TOP_CENTER);
        stackPanePageOptions.setMargin(menuButton2, new Insets(400, 300, 0, 300));
        Label comment = new Label("Set names of players");
        Scene pageIntroduce = getPageIntroduce();

        item1.setOnAction(e -> {
            menuButton.setText(item1.getText());
            stackPanePageOptions.setAlignment(namePalyer1, Pos.TOP_CENTER);
            stackPanePageOptions.setMargin(namePalyer1, new Insets(200, 200, 0, 500));
            stackPanePageOptions.getChildren().removeAll(namePalyer1, namePalyer2, namePalyer3, namePalyer4, next,comment);
            stackPanePageOptions.getChildren().addAll(namePalyer1, next);
            next.setOnAction(event -> {
                if (namePalyer1.getText().isEmpty()) {
                    stackPanePageOptions.setMargin(comment, new Insets(500, 200, 0, 200));
                    stackPanePageOptions.getChildren().removeAll(comment);
                    stackPanePageOptions.getChildren().addAll(comment);
                } else {
                    Scene pageGame1 = getPageGame1(namePalyer1.getText(), menuButton2.getText());
                    next.setOnAction(f -> window.setScene(pageGame1));
                    next.fire();
                }
            });
        });
        item2.setOnAction(e -> {
            menuButton.setText(item2.getText());
            stackPanePageOptions.setAlignment(namePalyer1, Pos.TOP_CENTER);
            stackPanePageOptions.setMargin(namePalyer1, new Insets(200, 200, 0, 500));
            stackPanePageOptions.setAlignment(namePalyer2, Pos.TOP_CENTER);
            stackPanePageOptions.setMargin(namePalyer2, new Insets(250, 200, 0, 500));
            stackPanePageOptions.getChildren().removeAll(namePalyer1, namePalyer2, namePalyer3, namePalyer4, next,comment);
            stackPanePageOptions.getChildren().addAll(namePalyer1, namePalyer2, next);
            next.setOnAction(event -> {
                if (namePalyer1.getText().isEmpty() || namePalyer2.getText().isEmpty()) {
                    stackPanePageOptions.setMargin(comment, new Insets(500, 200, 0, 200));
                    stackPanePageOptions.getChildren().removeAll(comment);
                    stackPanePageOptions.getChildren().addAll(comment);
                } else {
                    Scene pageGame2 = getPageGame2(namePalyer1.getText(), namePalyer2.getText(), menuButton2.getText());
                    next.setOnAction(f -> window.setScene(pageGame2));
                    next.fire();
                }
            });
        });
        item3.setOnAction(e -> {
            menuButton.setText(item3.getText());
            stackPanePageOptions.setAlignment(namePalyer1, Pos.TOP_CENTER);
            stackPanePageOptions.setMargin(namePalyer1, new Insets(200, 200, 0, 500));
            stackPanePageOptions.setAlignment(namePalyer2, Pos.TOP_CENTER);
            stackPanePageOptions.setMargin(namePalyer2, new Insets(250, 200, 0, 500));
            stackPanePageOptions.setAlignment(namePalyer3, Pos.TOP_CENTER);
            stackPanePageOptions.setMargin(namePalyer3, new Insets(300, 200, 0, 500));
            stackPanePageOptions.getChildren().removeAll(namePalyer1, namePalyer2, namePalyer3, namePalyer4, next,comment);
            stackPanePageOptions.getChildren().addAll(namePalyer1, namePalyer2, namePalyer3, next);
            next.setOnAction(event -> {
                if (namePalyer1.getText().isEmpty() || namePalyer2.getText().isEmpty() || namePalyer3.getText().isEmpty()) {
                    stackPanePageOptions.setMargin(comment, new Insets(500, 200, 0, 200));
                    stackPanePageOptions.getChildren().removeAll(comment);
                    stackPanePageOptions.getChildren().addAll(comment);
                } else {
                    Scene pageGame3 = getPageGame3(namePalyer1.getText(), namePalyer2.getText(), namePalyer3.getText(), menuButton2.getText());
                    next.setOnAction(f -> window.setScene(pageGame3));
                    next.fire();
                }
            });
        });
        item4.setOnAction(e -> {
            menuButton.setText(item4.getText());
            stackPanePageOptions.setAlignment(namePalyer1, Pos.TOP_CENTER);
            stackPanePageOptions.setMargin(namePalyer1, new Insets(200, 200, 0, 500));
            stackPanePageOptions.setAlignment(namePalyer2, Pos.TOP_CENTER);
            stackPanePageOptions.setMargin(namePalyer2, new Insets(250, 200, 0, 500));
            stackPanePageOptions.setAlignment(namePalyer3, Pos.TOP_CENTER);
            stackPanePageOptions.setMargin(namePalyer3, new Insets(300, 200, 0, 500));
            stackPanePageOptions.setAlignment(namePalyer4, Pos.TOP_CENTER);
            stackPanePageOptions.setMargin(namePalyer4, new Insets(350, 200, 0, 500));
            stackPanePageOptions.getChildren().removeAll(namePalyer1, namePalyer2, namePalyer3, namePalyer4, next,comment);
            stackPanePageOptions.getChildren().addAll(namePalyer1, namePalyer2, namePalyer3, namePalyer4, next);
            next.setOnAction(event -> {
                if (namePalyer1.getText().isEmpty() || namePalyer2.getText().isEmpty() || namePalyer3.getText().isEmpty() || namePalyer4.getText().isEmpty()) {
                    stackPanePageOptions.setMargin(comment, new Insets(500, 200, 0, 200));
                    stackPanePageOptions.getChildren().removeAll(comment);
                    stackPanePageOptions.getChildren().addAll(comment);
                } else {
                    Scene pageGame4 = getPageGame4(namePalyer1.getText(), namePalyer2.getText(), namePalyer3.getText(), namePalyer4.getText(), menuButton2.getText());
                    next.setOnAction(f -> window.setScene(pageGame4));
                    next.fire();
                }
            });
        });
        item5.setOnAction(e -> {
            menuButton2.setText(item5.getText());
        });
        item6.setOnAction(e -> {
            menuButton2.setText(item6.getText());
        });
        item7.setOnAction(e -> {
            menuButton2.setText(item7.getText());
        });

        stackPanePageOptions.getChildren().addAll(menuButton, menuButton2);

        Button back = new Button("Back");
        stackPanePageOptions.setAlignment(back, Pos.BOTTOM_LEFT);
        stackPanePageOptions.setMargin(back, new Insets(0, 0, 10, 10));

        back.setOnAction(e -> {
            window.setScene(pageIntroduce);
        });

        stackPanePageOptions.getChildren().addAll(label, back);
        Scene pageOptions = new Scene(stackPanePageOptions, width, height, Color.WHITESMOKE);

        return pageOptions;
    }

    public Scene getPageGame1(String namePlayer1, String level) {
        GridPane gridPageGame1 = new GridPane();
        int numbersOfPlayers = 1;

        List<Pawn> homeYellowPawns = new ArrayList<>();
        Pawn yellow1 = new Pawn();
        Pawn yellow2 = new Pawn();
        Pawn yellow3 = new Pawn();
        Pawn yellow4 = new Pawn();

        homeYellowPawns.add(yellow1);
        homeYellowPawns.add(yellow2);
        homeYellowPawns.add(yellow3);
        homeYellowPawns.add(yellow4);

        //List of red pawns in home
        List<Pawn> homeRedPawns = new ArrayList<>();
        Pawn red1 = new Pawn();
        Pawn red2 = new Pawn();
        Pawn red3 = new Pawn();
        Pawn red4 = new Pawn();

        homeRedPawns.add(red1);
        homeRedPawns.add(red2);
        homeRedPawns.add(red3);
        homeRedPawns.add(red4);

        //List of green pawns in home
        List<Pawn> homeGreenPawns = new ArrayList<>();
        Pawn green1 = new Pawn();
        Pawn green2 = new Pawn();
        Pawn green3 = new Pawn();
        Pawn green4 = new Pawn();

        homeGreenPawns.add(green1);
        homeGreenPawns.add(green2);
        homeGreenPawns.add(green3);
        homeGreenPawns.add(green4);

        //List of blue pawns in home
        List<Pawn> homeBluePawns = new ArrayList<>();
        Pawn blue1 = new Pawn();
        Pawn blue2 = new Pawn();
        Pawn blue3 = new Pawn();
        Pawn blue4 = new Pawn();

        homeBluePawns.add(blue1);
        homeBluePawns.add(blue2);
        homeBluePawns.add(blue3);
        homeBluePawns.add(blue4);
//
        List<Pawn> baseOfYellowPawns = new ArrayList<>();
        List<Pawn> baseOfRedPawns = new ArrayList<>();
        List<Pawn> baseOfGreenPawns = new ArrayList<>();
        List<Pawn> baseOfBluePawns = new ArrayList<>();

        Map<Integer, Point> homeYellow = new HashMap<>();
        homeYellow.put(1, new Point(0, 0));
        homeYellow.put(2, new Point(0, 1));
        homeYellow.put(3, new Point(1, 0));
        homeYellow.put(4, new Point(1, 1));

        Map<Integer, Point> homeRed = new HashMap<>();
        homeRed.put(1, new Point(9, 9));
        homeRed.put(2, new Point(9, 10));
        homeRed.put(3, new Point(10, 9));
        homeRed.put(4, new Point(10, 10));

        Map<Integer, Point> homeGreen = new HashMap<>();
        homeGreen.put(1, new Point(9, 0));
        homeGreen.put(2, new Point(9, 1));
        homeGreen.put(3, new Point(10, 0));
        homeGreen.put(4, new Point(10, 1));

        Map<Integer, Point> homeBlue = new HashMap<>();
        homeBlue.put(1, new Point(0, 9));
        homeBlue.put(2, new Point(0, 10));
        homeBlue.put(3, new Point(1, 9));
        homeBlue.put(4, new Point(1, 10));

        List<List> ranking = new ArrayList<>();
//
        ListOfPositions yellowList = new ListOfPositions();
        Map<Integer, Point> roadOfYellowPawns = yellowList.positionForYellowPawns();
        ListOfPositions greeenList = new ListOfPositions();
        Map<Integer, Point> roadOfGreenPawns = greeenList.positionForGreenPawns();
        ListOfPositions redList = new ListOfPositions();
        Map<Integer, Point> roadOfRedPawns = redList.positionForRedPawns();
        ListOfPositions blueList = new ListOfPositions();
        Map<Integer, Point> roadOfBluePawns = blueList.positionForBluePawns();

        //********************************************************************

        //Ustawienie tła (planszy)
        gridPageGame1.setAlignment(Pos.TOP_LEFT);
        gridPageGame1.setBackground(game.getGameBackground());

        // Podział planaszy na pola (współrzędne)
        int rowCount = 11;
        int columnCount = 16;
        row.setPercentHeight(100d / rowCount);

        for (int i = 0; i < rowCount; i++) {
            gridPageGame1.getRowConstraints().add(row);
        }

        column.setPercentWidth(100d / columnCount);

        for (int i = 0; i < columnCount; i++) {
            gridPageGame1.getColumnConstraints().add(column);
        }

        ImageView imageView1 = yellow1.getPawnYellow();
        ImageView imageView2 = yellow2.getPawnYellow();
        ImageView imageView3 = yellow3.getPawnYellow();
        ImageView imageView4 = yellow4.getPawnYellow();

        gridPageGame1.add(imageView1, homeYellow.get(1).getColumn(), homeYellow.get(1).getRow());
        gridPageGame1.add(imageView2, homeYellow.get(2).getColumn(), homeYellow.get(2).getRow());
        gridPageGame1.add(imageView3, homeYellow.get(3).getColumn(), homeYellow.get(3).getRow());
        gridPageGame1.add(imageView4, homeYellow.get(4).getColumn(), homeYellow.get(4).getRow());

        // Ustawienie pioków zielonych w bazie
        ImageView imageView5 = green1.getPawnGreen();
        ImageView imageView6 = green2.getPawnGreen();
        ImageView imageView7 = green3.getPawnGreen();
        ImageView imageView8 = green4.getPawnGreen();

        gridPageGame1.add(imageView5, homeGreen.get(1).getColumn(), homeGreen.get(1).getRow());
        gridPageGame1.add(imageView6, homeGreen.get(2).getColumn(), homeGreen.get(2).getRow());
        gridPageGame1.add(imageView7, homeGreen.get(3).getColumn(), homeGreen.get(3).getRow());
        gridPageGame1.add(imageView8, homeGreen.get(4).getColumn(), homeGreen.get(4).getRow());

        // Ustawienie pionków czerwonych w bazie
        ImageView imageView9 = red1.getPawnRed();
        ImageView imageView10 = red2.getPawnRed();
        ImageView imageView11 = red3.getPawnRed();
        ImageView imageView12 = red4.getPawnRed();

        gridPageGame1.add(imageView9, homeRed.get(1).getColumn(), homeRed.get(1).getRow());
        gridPageGame1.add(imageView10, homeRed.get(2).getColumn(), homeRed.get(2).getRow());
        gridPageGame1.add(imageView11, homeRed.get(3).getColumn(), homeRed.get(3).getRow());
        gridPageGame1.add(imageView12, homeRed.get(4).getColumn(), homeRed.get(4).getRow());

        // Ustawienie pionków niebieskich w bazie
        ImageView imageView13 = blue1.getPawnBlue();
        ImageView imageView14 = blue2.getPawnBlue();
        ImageView imageView15 = blue3.getPawnBlue();
        ImageView imageView16 = blue4.getPawnBlue();

        gridPageGame1.add(imageView13, homeBlue.get(1).getColumn(), homeBlue.get(1).getRow());
        gridPageGame1.add(imageView14, homeBlue.get(2).getColumn(), homeBlue.get(2).getRow());
        gridPageGame1.add(imageView15, homeBlue.get(3).getColumn(), homeBlue.get(3).getRow());
        gridPageGame1.add(imageView16, homeBlue.get(4).getColumn(), homeBlue.get(4).getRow());

        gridPageGame1.setGridLinesVisible(false); //Powoduje widocznośc lub niewidoczność poidzału planszy kolumny iw iersze

        //Buttons
        Button buttonOfYellow = new Button(namePlayer1 + " get move");
        Button buttonOfGreen = new Button("Green get move");
        Button buttonOfRed = new Button("Red get move");
        Button buttonOfBlue = new Button("Blue get move");
        Button endGame = new Button("End Game");
        Button whoStart = new Button("Who start");
        Label labelOfYellow = new Label("Dice result:" + textDice);
        Label labelOfGreen = new Label("Dice result:" + textDice);
        Label labelOfRed = new Label("Dice result:" + textDice);
        Label labelOfBlue = new Label("Dice result:" + textDice);
        Label whoWin = new Label("Ranking: ");
        Label levelOfGame = new Label("Level: " + level);
        Label firstPlace = new Label();
        Label secendPlace = new Label();
        Label thirdPlace = new Label();
        Label fourthPlace = new Label();
        Label endGames = new Label();

        GridPane.setConstraints(buttonOfYellow, 2, 0, 2, 2);
        GridPane.setConstraints(buttonOfGreen, 11, 0, 2, 2);
        GridPane.setConstraints(buttonOfRed, 11, 9, 2, 2);
        GridPane.setConstraints(buttonOfBlue, 2, 9, 2, 2);
        GridPane.setConstraints(labelOfYellow, 2, 1, 2, 1);
        GridPane.setConstraints(labelOfGreen, 11, 1, 2, 1);
        GridPane.setConstraints(labelOfRed, 11, 10, 2, 1);
        GridPane.setConstraints(labelOfBlue, 2, 10, 2, 1);
        GridPane.setConstraints(endGame, 13, 10, 3, 1);
        GridPane.setConstraints(whoStart, 13, 1, 3, 1);
        GridPane.setConstraints(whoWin, 13, 4, 3, 1);
        GridPane.setConstraints(levelOfGame, 13, 2, 3, 1);
        GridPane.setConstraints(firstPlace, 13, 5, 3, 1);
        GridPane.setConstraints(secendPlace, 13, 6, 3, 1);
        GridPane.setConstraints(thirdPlace, 13, 7, 3, 1);
        GridPane.setConstraints(fourthPlace, 13, 8, 3, 1);

        gridPageGame1.setMargin(endGame, new Insets(0, 100, 10, 0));

        buttonOfYellow.setDisable(true);
        buttonOfGreen.setDisable(true);
        buttonOfRed.setDisable(true);
        buttonOfBlue.setDisable(true);

        gridPageGame1.getChildren().addAll(buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue,
                labelOfYellow, labelOfGreen, labelOfRed, labelOfBlue, whoStart, endGame, whoWin, levelOfGame);


        // Set player who start the game
        whoStart.setOnAction(event -> {
            moves.whoStart(buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue, numbersOfPlayers);
            whoStart.setDisable(true);
        });

        buttonOfYellow.setOnAction(event -> {

            //This method generatet and display dice result
            int result = dice.generatedAndDisplayResultForHumanPlayer(actualPositionOfYellow, level, labelOfYellow, gridPageGame1);

            // This method decides if the pawn can leave the base
            int startPositionFromMethod = (moves.pawnsMove(result, baseOfYellowPawns, homeYellowPawns,
                    imageView1, imageView2, imageView3, imageView4,
                    roadOfYellowPawns, gridPageGame1, actualPositionOfYellow));
            actualPositionOfYellow = startPositionFromMethod;

            // This method decides move pawn outside of base
            startPositionFromMethod = moves.moveFromBase(result, homeYellowPawns, baseOfYellowPawns,
                    imageView1, imageView2, imageView3, imageView4,
                    roadOfYellowPawns, gridPageGame1, actualPositionOfYellow);
            actualPositionOfYellow = startPositionFromMethod;

            //These three methods analyze the capture of a pawn by a pawn in motion
            actualPositionOfGreen = moves.pawnBeatGreenPawn(actualPositionOfYellow, actualPositionOfGreen,
                    roadOfYellowPawns, roadOfGreenPawns,
                    imageView5, imageView6, imageView7, imageView8,
                    homeGreenPawns, homeGreen, gridPageGame1);

            actualPositionOfRed = moves.pawnBeatRedPawn(actualPositionOfYellow, actualPositionOfRed,
                    roadOfYellowPawns, roadOfRedPawns,
                    imageView9, imageView10, imageView11, imageView12,
                    homeRedPawns, homeRed, gridPageGame1);

            actualPositionOfBlue = moves.pawnBeatBluePawn(actualPositionOfYellow, actualPositionOfBlue,
                    roadOfYellowPawns, roadOfBluePawns,
                    imageView13, imageView14, imageView15, imageView16,
                    homeBluePawns, homeBlue, gridPageGame1);

            //This method check who Player's won
            moves.checkWinner(baseOfYellowPawns, baseOfGreenPawns, baseOfRedPawns, baseOfBluePawns, ranking,
                    buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue, firstPlace, secendPlace, thirdPlace, fourthPlace, gridPageGame1);

            //This method decided about able or disable buttons depending of turn and full of bases
            moves.buttonsAbleAndDisable(baseOfYellowPawns, baseOfGreenPawns, baseOfRedPawns, baseOfBluePawns,
                    buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue, ranking);

            //This method decided about moves pawns belong to computer
            moves.computerMove(buttonOfGreen, buttonOfRed, buttonOfBlue, numbersOfPlayers);
        });
        buttonOfGreen.setOnAction(event -> {
            //This method generatet and display dice result
            int result = dice.generatedAndDisplayResultForComputerPlayer(actualPositionOfGreen, level, labelOfGreen, gridPageGame1);

            // This method decides if the pawn can leave the base
            int startPositionFromMethod = (moves.pawnsMove(result, baseOfGreenPawns, homeGreenPawns,
                    imageView5, imageView6, imageView7, imageView8,
                    roadOfGreenPawns, gridPageGame1, actualPositionOfGreen));
            actualPositionOfGreen = startPositionFromMethod;

            // This method decides move pawn outside of base
            startPositionFromMethod = moves.moveFromBase(result, homeGreenPawns, baseOfGreenPawns,
                    imageView5, imageView6, imageView7, imageView8,
                    roadOfGreenPawns, gridPageGame1, actualPositionOfGreen);
            actualPositionOfGreen = startPositionFromMethod;

            //These three methods analyze the capture of a pawn by a pawn in motion
            actualPositionOfYellow = moves.pawnBeatYellowPawn(actualPositionOfGreen, actualPositionOfYellow,
                    roadOfGreenPawns, roadOfYellowPawns,
                    imageView1, imageView2, imageView3, imageView4,
                    homeYellowPawns, homeYellow, gridPageGame1);

            actualPositionOfRed = moves.pawnBeatRedPawn(actualPositionOfGreen, actualPositionOfRed,
                    roadOfGreenPawns, roadOfRedPawns,
                    imageView9, imageView10, imageView11, imageView12,
                    homeRedPawns, homeRed, gridPageGame1);

            actualPositionOfBlue = moves.pawnBeatBluePawn(actualPositionOfGreen, actualPositionOfBlue,
                    roadOfGreenPawns, roadOfBluePawns,
                    imageView13, imageView14, imageView15, imageView16,
                    homeBluePawns, homeBlue, gridPageGame1);

            //This method check who Player's won
            moves.checkWinner(baseOfYellowPawns, baseOfGreenPawns, baseOfRedPawns, baseOfBluePawns, ranking,
                    buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue, firstPlace, secendPlace, thirdPlace, fourthPlace, gridPageGame1);

            //This method decided about able or disable buttons depending of turn and full of bases
            moves.buttonsAbleAndDisable(baseOfGreenPawns, baseOfYellowPawns, baseOfBluePawns, baseOfRedPawns,
                    buttonOfGreen, buttonOfRed, buttonOfBlue, buttonOfYellow, ranking);

            //This method decided about moves pawns belong to computer
            moves.computerMove(buttonOfRed, buttonOfBlue, buttonOfGreen, numbersOfPlayers);
        });
        buttonOfRed.setOnAction(event -> {
            //This method generatet and display dice result
            int result = dice.generatedAndDisplayResultForComputerPlayer(actualPositionOfRed, level, labelOfRed, gridPageGame1);

            // This method decides if the pawn can leave the base
            int startPositionFromMethod = (moves.pawnsMove(result, baseOfRedPawns, homeRedPawns,
                    imageView9, imageView10, imageView11, imageView12,
                    roadOfRedPawns, gridPageGame1, actualPositionOfRed));
            actualPositionOfRed = startPositionFromMethod;

            // This method decides move pawn outside of base
            startPositionFromMethod = moves.moveFromBase(result, homeRedPawns, baseOfRedPawns,
                    imageView9, imageView10, imageView11, imageView12,
                    roadOfRedPawns, gridPageGame1, actualPositionOfRed);
            actualPositionOfRed = startPositionFromMethod;

            //These three methods analyze the capture of a pawn by a pawn in motion
            actualPositionOfYellow = moves.pawnBeatYellowPawn(actualPositionOfRed, actualPositionOfYellow,
                    roadOfRedPawns, roadOfYellowPawns,
                    imageView1, imageView2, imageView3, imageView4,
                    homeYellowPawns, homeYellow, gridPageGame1);

            actualPositionOfGreen = moves.pawnBeatGreenPawn(actualPositionOfRed, actualPositionOfGreen,
                    roadOfRedPawns, roadOfGreenPawns,
                    imageView5, imageView6, imageView7, imageView8,
                    homeGreenPawns, homeGreen, gridPageGame1);

            actualPositionOfBlue = moves.pawnBeatBluePawn(actualPositionOfRed, actualPositionOfBlue,
                    roadOfRedPawns, roadOfBluePawns,
                    imageView13, imageView14, imageView15, imageView16,
                    homeBluePawns, homeBlue, gridPageGame1);

            //This method check who Player's won
            moves.checkWinner(baseOfYellowPawns, baseOfGreenPawns, baseOfRedPawns, baseOfBluePawns, ranking,
                    buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue, firstPlace, secendPlace, thirdPlace, fourthPlace, gridPageGame1);

            //This method decided about able or disable buttons depending of turn and full of bases
            moves.buttonsAbleAndDisable(baseOfRedPawns, baseOfBluePawns, baseOfYellowPawns, baseOfGreenPawns,
                    buttonOfRed, buttonOfBlue, buttonOfYellow, buttonOfGreen, ranking);

            //This method decided about moves pawns belong to computer
            moves.computerMove(buttonOfBlue, buttonOfGreen, buttonOfRed, numbersOfPlayers);
        });
        buttonOfBlue.setOnAction(event -> {
            //This method generatet and display dice result
            int result = dice.generatedAndDisplayResultForComputerPlayer(actualPositionOfBlue, level, labelOfBlue, gridPageGame1);

            // This method decides if the pawn can leave the base
            int startPositionFromMethod = (moves.pawnsMove(result, baseOfBluePawns, homeBluePawns,
                    imageView13, imageView14, imageView15, imageView16,
                    roadOfBluePawns, gridPageGame1, actualPositionOfBlue));
            actualPositionOfBlue = startPositionFromMethod;

            // This method decides move pawn outside of base
            startPositionFromMethod = moves.moveFromBase(result, homeBluePawns, baseOfBluePawns,
                    imageView13, imageView14, imageView15, imageView16,
                    roadOfBluePawns, gridPageGame1, actualPositionOfBlue);
            actualPositionOfBlue = startPositionFromMethod;

            //These three methods analyze the capture of a pawn by a pawn in motion
            actualPositionOfYellow = moves.pawnBeatYellowPawn(actualPositionOfBlue, actualPositionOfYellow,
                    roadOfBluePawns, roadOfYellowPawns,
                    imageView1, imageView2, imageView3, imageView4,
                    homeYellowPawns, homeYellow, gridPageGame1);

            actualPositionOfGreen = moves.pawnBeatGreenPawn(actualPositionOfBlue, actualPositionOfGreen,
                    roadOfBluePawns, roadOfGreenPawns,
                    imageView5, imageView6, imageView7, imageView8,
                    homeGreenPawns, homeGreen, gridPageGame1);

            actualPositionOfRed = moves.pawnBeatRedPawn(actualPositionOfBlue, actualPositionOfRed,
                    roadOfBluePawns, roadOfRedPawns,
                    imageView9, imageView10, imageView11, imageView12,
                    homeRedPawns, homeRed, gridPageGame1);

            //This method check who Player's won
            moves.checkWinner(baseOfYellowPawns, baseOfGreenPawns, baseOfRedPawns, baseOfBluePawns, ranking,
                    buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue, firstPlace, secendPlace, thirdPlace, fourthPlace, gridPageGame1);

            //This method decided about able or disable buttons depending of turn and full of bases
            moves.buttonsAbleAndDisable(baseOfBluePawns, baseOfYellowPawns, baseOfGreenPawns, baseOfRedPawns,
                    buttonOfBlue, buttonOfYellow, buttonOfGreen, buttonOfRed, ranking);

            //This method decided about moves pawns belong to computer
            moves.computerMove(buttonOfGreen, buttonOfRed, buttonOfBlue, numbersOfPlayers);
        });
        endGame.setOnAction(e -> {
            Scene pageIntroduce = getPageIntroduce();
            window.setScene(pageIntroduce);
        });
        Scene pageGame1 = new Scene(gridPageGame1, 960, height, Color.WHITESMOKE);
        return pageGame1;
    }

    public Scene getPageGame2(String namePlayer1, String namePlayer2, String level) {
        GridPane gridPageGame2 = new GridPane();
        int numbersOfPlayers = 2;
        //List of yellow pawns in home
        List<Pawn> homeYellowPawns = new ArrayList<>();
        Pawn yellow1 = new Pawn();
        Pawn yellow2 = new Pawn();
        Pawn yellow3 = new Pawn();
        Pawn yellow4 = new Pawn();

        homeYellowPawns.add(yellow1);
        homeYellowPawns.add(yellow2);
        homeYellowPawns.add(yellow3);
        homeYellowPawns.add(yellow4);

        //List of red pawns in home
        List<Pawn> homeRedPawns = new ArrayList<>();
        Pawn red1 = new Pawn();
        Pawn red2 = new Pawn();
        Pawn red3 = new Pawn();
        Pawn red4 = new Pawn();

        homeRedPawns.add(red1);
        homeRedPawns.add(red2);
        homeRedPawns.add(red3);
        homeRedPawns.add(red4);

        //List of green pawns in home
        List<Pawn> homeGreenPawns = new ArrayList<>();
        Pawn green1 = new Pawn();
        Pawn green2 = new Pawn();
        Pawn green3 = new Pawn();
        Pawn green4 = new Pawn();

        homeGreenPawns.add(green1);
        homeGreenPawns.add(green2);
        homeGreenPawns.add(green3);
        homeGreenPawns.add(green4);

        //List of blue pawns in home
        List<Pawn> homeBluePawns = new ArrayList<>();
        Pawn blue1 = new Pawn();
        Pawn blue2 = new Pawn();
        Pawn blue3 = new Pawn();
        Pawn blue4 = new Pawn();

        homeBluePawns.add(blue1);
        homeBluePawns.add(blue2);
        homeBluePawns.add(blue3);
        homeBluePawns.add(blue4);

        List<Pawn> baseOfYellowPawns = new ArrayList<>();
        List<Pawn> baseOfRedPawns = new ArrayList<>();
        List<Pawn> baseOfGreenPawns = new ArrayList<>();
        List<Pawn> baseOfBluePawns = new ArrayList<>();

        Map<Integer, Point> homeYellow = new HashMap<>();
        homeYellow.put(1, new Point(0, 0));
        homeYellow.put(2, new Point(0, 1));
        homeYellow.put(3, new Point(1, 0));
        homeYellow.put(4, new Point(1, 1));

        Map<Integer, Point> homeRed = new HashMap<>();
        homeRed.put(1, new Point(9, 9));
        homeRed.put(2, new Point(9, 10));
        homeRed.put(3, new Point(10, 9));
        homeRed.put(4, new Point(10, 10));

        Map<Integer, Point> homeGreen = new HashMap<>();
        homeGreen.put(1, new Point(9, 0));
        homeGreen.put(2, new Point(9, 1));
        homeGreen.put(3, new Point(10, 0));
        homeGreen.put(4, new Point(10, 1));

        Map<Integer, Point> homeBlue = new HashMap<>();
        homeBlue.put(1, new Point(0, 9));
        homeBlue.put(2, new Point(0, 10));
        homeBlue.put(3, new Point(1, 9));
        homeBlue.put(4, new Point(1, 10));

        List<List> ranking = new ArrayList<>();

        ListOfPositions yellowList = new ListOfPositions();
        Map<Integer, Point> roadOfYellowPawns = yellowList.positionForYellowPawns();
        ListOfPositions greeenList = new ListOfPositions();
        Map<Integer, Point> roadOfGreenPawns = greeenList.positionForGreenPawns();
        ListOfPositions redList = new ListOfPositions();
        Map<Integer, Point> roadOfRedPawns = redList.positionForRedPawns();
        ListOfPositions blueList = new ListOfPositions();
        Map<Integer, Point> roadOfBluePawns = blueList.positionForBluePawns();

        //********************************************************************

        //Ustawienie tła (planszy)
        gridPageGame2.setAlignment(Pos.TOP_LEFT);
        gridPageGame2.setBackground(game.getGameBackground());

        // Podział planaszy na pola (współrzędne)
        int rowCount = 11;
        int columnCount = 16;
        row.setPercentHeight(100d / rowCount);

        for (int i = 0; i < rowCount; i++) {
            gridPageGame2.getRowConstraints().add(row);
        }

        column.setPercentWidth(100d / columnCount);

        for (int i = 0; i < columnCount; i++) {
            gridPageGame2.getColumnConstraints().add(column);
        }

        ImageView imageView1 = yellow1.getPawnYellow();
        ImageView imageView2 = yellow2.getPawnYellow();
        ImageView imageView3 = yellow3.getPawnYellow();
        ImageView imageView4 = yellow4.getPawnYellow();

        gridPageGame2.add(imageView1, homeYellow.get(1).getColumn(), homeYellow.get(1).getRow());
        gridPageGame2.add(imageView2, homeYellow.get(2).getColumn(), homeYellow.get(2).getRow());
        gridPageGame2.add(imageView3, homeYellow.get(3).getColumn(), homeYellow.get(3).getRow());
        gridPageGame2.add(imageView4, homeYellow.get(4).getColumn(), homeYellow.get(4).getRow());

        // Ustawienie pioków zielonych w bazie
        ImageView imageView5 = green1.getPawnGreen();
        ImageView imageView6 = green2.getPawnGreen();
        ImageView imageView7 = green3.getPawnGreen();
        ImageView imageView8 = green4.getPawnGreen();

        gridPageGame2.add(imageView5, homeGreen.get(1).getColumn(), homeGreen.get(1).getRow());
        gridPageGame2.add(imageView6, homeGreen.get(2).getColumn(), homeGreen.get(2).getRow());
        gridPageGame2.add(imageView7, homeGreen.get(3).getColumn(), homeGreen.get(3).getRow());
        gridPageGame2.add(imageView8, homeGreen.get(4).getColumn(), homeGreen.get(4).getRow());

        // Ustawienie pionków czerwonych w bazie
        ImageView imageView9 = red1.getPawnRed();
        ImageView imageView10 = red2.getPawnRed();
        ImageView imageView11 = red3.getPawnRed();
        ImageView imageView12 = red4.getPawnRed();

        gridPageGame2.add(imageView9, homeRed.get(1).getColumn(), homeRed.get(1).getRow());
        gridPageGame2.add(imageView10, homeRed.get(2).getColumn(), homeRed.get(2).getRow());
        gridPageGame2.add(imageView11, homeRed.get(3).getColumn(), homeRed.get(3).getRow());
        gridPageGame2.add(imageView12, homeRed.get(4).getColumn(), homeRed.get(4).getRow());

        // Ustawienie pionków niebieskich w bazie
        ImageView imageView13 = blue1.getPawnBlue();
        ImageView imageView14 = blue2.getPawnBlue();
        ImageView imageView15 = blue3.getPawnBlue();
        ImageView imageView16 = blue4.getPawnBlue();

        gridPageGame2.add(imageView13, homeBlue.get(1).getColumn(), homeBlue.get(1).getRow());
        gridPageGame2.add(imageView14, homeBlue.get(2).getColumn(), homeBlue.get(2).getRow());
        gridPageGame2.add(imageView15, homeBlue.get(3).getColumn(), homeBlue.get(3).getRow());
        gridPageGame2.add(imageView16, homeBlue.get(4).getColumn(), homeBlue.get(4).getRow());

        gridPageGame2.setGridLinesVisible(false); //Powoduje widocznośc lub niewidoczność poidzału planszy kolumny iw iersze

        //Buttons
        Button buttonOfYellow = new Button(namePlayer1 + " get move");
        Button buttonOfGreen = new Button(namePlayer2 + " get move");
        Button buttonOfRed = new Button("Red get move");
        Button buttonOfBlue = new Button("Blue get move");
        Button endGame = new Button("End Game");
        Button whoStart = new Button("Who start");
        Label labelOfYellow = new Label("Dice result:" + textDice);
        Label labelOfGreen = new Label("Dice result:" + textDice);
        Label labelOfRed = new Label("Dice result:" + textDice);
        Label labelOfBlue = new Label("Dice result:" + textDice);
        Label whoWin = new Label("Ranking: ");
        Label levelOfGame = new Label("Level: " + level);
        Label firstPlace = new Label();
        Label secendPlace = new Label();
        Label thirdPlace = new Label();
        Label fourthPlace = new Label();
        Label endGames = new Label();

        GridPane.setConstraints(buttonOfYellow, 2, 0, 2, 2);
        GridPane.setConstraints(buttonOfGreen, 11, 0, 2, 2);
        GridPane.setConstraints(buttonOfRed, 11, 9, 2, 2);
        GridPane.setConstraints(buttonOfBlue, 2, 9, 2, 2);
        GridPane.setConstraints(labelOfYellow, 2, 1, 2, 1);
        GridPane.setConstraints(labelOfGreen, 11, 1, 2, 1);
        GridPane.setConstraints(labelOfRed, 11, 10, 2, 1);
        GridPane.setConstraints(labelOfBlue, 2, 10, 2, 1);
        GridPane.setConstraints(endGame, 13, 10, 3, 1);
        GridPane.setConstraints(whoStart, 13, 1, 3, 1);
        GridPane.setConstraints(whoWin, 13, 4, 3, 1);
        GridPane.setConstraints(levelOfGame, 13, 2, 3, 1);
        GridPane.setConstraints(firstPlace, 13, 5, 3, 1);
        GridPane.setConstraints(secendPlace, 13, 6, 3, 1);
        GridPane.setConstraints(thirdPlace, 13, 7, 3, 1);
        GridPane.setConstraints(fourthPlace, 13, 8, 3, 1);

        gridPageGame2.setMargin(endGame, new Insets(0, 100, 10, 0));

        buttonOfYellow.setDisable(true);
        buttonOfGreen.setDisable(true);
        buttonOfRed.setDisable(true);
        buttonOfBlue.setDisable(true);

        // Set player who start the game
        whoStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                moves.whoStart(buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue, numbersOfPlayers);
                whoStart.setDisable(true);
            }
        });

        gridPageGame2.getChildren().addAll(buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue,
                labelOfYellow, labelOfGreen, labelOfRed, labelOfBlue, whoStart, endGame, whoWin, levelOfGame);

        buttonOfYellow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //This method generatet and display dice result
                int result = dice.generatedAndDisplayResultForHumanPlayer(actualPositionOfYellow, level, labelOfYellow, gridPageGame2);

                // This method decides if the pawn can leave the base
                int startPositionFromMethod = (moves.pawnsMove(result, baseOfYellowPawns, homeYellowPawns,
                        imageView1, imageView2, imageView3, imageView4,
                        roadOfYellowPawns, gridPageGame2, actualPositionOfYellow));
                actualPositionOfYellow = startPositionFromMethod;

                // This method decides move pawn outside of base
                startPositionFromMethod = moves.moveFromBase(result, homeYellowPawns, baseOfYellowPawns,
                        imageView1, imageView2, imageView3, imageView4,
                        roadOfYellowPawns, gridPageGame2, actualPositionOfYellow);
                actualPositionOfYellow = startPositionFromMethod;

                //These three methods analyze the capture of a pawn by a pawn in motion
                actualPositionOfGreen = moves.pawnBeatGreenPawn(actualPositionOfYellow, actualPositionOfGreen,
                        roadOfYellowPawns, roadOfGreenPawns,
                        imageView5, imageView6, imageView7, imageView8,
                        homeGreenPawns, homeGreen, gridPageGame2);

                actualPositionOfRed = moves.pawnBeatRedPawn(actualPositionOfYellow, actualPositionOfRed,
                        roadOfYellowPawns, roadOfRedPawns,
                        imageView9, imageView10, imageView11, imageView12,
                        homeRedPawns, homeRed, gridPageGame2);

                actualPositionOfBlue = moves.pawnBeatBluePawn(actualPositionOfYellow, actualPositionOfBlue,
                        roadOfYellowPawns, roadOfBluePawns,
                        imageView13, imageView14, imageView15, imageView16,
                        homeBluePawns, homeBlue, gridPageGame2);

                //This method decided about able or disable buttons depending of turn and full of bases
                moves.buttonsAbleAndDisable(baseOfYellowPawns, baseOfGreenPawns, baseOfRedPawns, baseOfBluePawns,
                        buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue, ranking);

                //This method check who Player's won
                moves.checkWinner(baseOfYellowPawns, baseOfGreenPawns, baseOfRedPawns, baseOfBluePawns, ranking,
                        buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue, firstPlace, secendPlace, thirdPlace, fourthPlace, gridPageGame2);

                //This method decided about moves pawns belong to computer
                moves.computerMove(buttonOfRed, buttonOfBlue, buttonOfGreen, numbersOfPlayers);
            }
        });
        buttonOfGreen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //This method generatet and display dice result
                int result = dice.generatedAndDisplayResultForHumanPlayer(actualPositionOfGreen, level, labelOfGreen, gridPageGame2);

                // This method decides if the pawn can leave the base
                int startPositionFromMethod = (moves.pawnsMove(result, baseOfGreenPawns, homeGreenPawns,
                        imageView5, imageView6, imageView7, imageView8,
                        roadOfGreenPawns, gridPageGame2, actualPositionOfGreen));
                actualPositionOfGreen = startPositionFromMethod;

                // This method decides move pawn outside of base
                startPositionFromMethod = moves.moveFromBase(result, homeGreenPawns, baseOfGreenPawns,
                        imageView5, imageView6, imageView7, imageView8,
                        roadOfGreenPawns, gridPageGame2, actualPositionOfGreen);
                actualPositionOfGreen = startPositionFromMethod;

                //These three methods analyze the capture of a pawn by a pawn in motion
                actualPositionOfYellow = moves.pawnBeatYellowPawn(actualPositionOfGreen, actualPositionOfYellow,
                        roadOfGreenPawns, roadOfYellowPawns,
                        imageView1, imageView2, imageView3, imageView4,
                        homeYellowPawns, homeYellow, gridPageGame2);

                actualPositionOfRed = moves.pawnBeatRedPawn(actualPositionOfGreen, actualPositionOfRed,
                        roadOfGreenPawns, roadOfRedPawns,
                        imageView9, imageView10, imageView11, imageView12,
                        homeRedPawns, homeRed, gridPageGame2);

                actualPositionOfBlue = moves.pawnBeatBluePawn(actualPositionOfGreen, actualPositionOfBlue,
                        roadOfGreenPawns, roadOfBluePawns,
                        imageView13, imageView14, imageView15, imageView16,
                        homeBluePawns, homeBlue, gridPageGame2);

                //This method decided about able or disable buttons depending of turn and full of bases
                moves.buttonsAbleAndDisable(baseOfGreenPawns, baseOfRedPawns, baseOfBluePawns, baseOfYellowPawns,
                        buttonOfGreen, buttonOfRed, buttonOfBlue, buttonOfYellow, ranking);

                //This method check who Player's won
                moves.checkWinner(baseOfYellowPawns, baseOfGreenPawns, baseOfRedPawns, baseOfBluePawns, ranking,
                        buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue, firstPlace, secendPlace, thirdPlace, fourthPlace, gridPageGame2);

                //This method decided about moves pawns belong to computer
                moves.computerMove(buttonOfRed, buttonOfBlue, buttonOfYellow, numbersOfPlayers);
            }
        });
        buttonOfRed.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //This method generatet and display dice result
                int result = dice.generatedAndDisplayResultForComputerPlayer(actualPositionOfRed, level, labelOfRed, gridPageGame2);

                // This method decides if the pawn can leave the base
                int startPositionFromMethod = (moves.pawnsMove(result, baseOfRedPawns, homeRedPawns,
                        imageView9, imageView10, imageView11, imageView12,
                        roadOfRedPawns, gridPageGame2, actualPositionOfRed));
                actualPositionOfRed = startPositionFromMethod;

                // This method decides move pawn outside of base
                startPositionFromMethod = moves.moveFromBase(result, homeRedPawns, baseOfRedPawns,
                        imageView9, imageView10, imageView11, imageView12,
                        roadOfRedPawns, gridPageGame2, actualPositionOfRed);
                actualPositionOfRed = startPositionFromMethod;

                //These three methods analyze the capture of a pawn by a pawn in motion
                actualPositionOfYellow = moves.pawnBeatYellowPawn(actualPositionOfRed, actualPositionOfYellow,
                        roadOfRedPawns, roadOfYellowPawns,
                        imageView1, imageView2, imageView3, imageView4,
                        homeYellowPawns, homeYellow, gridPageGame2);

                actualPositionOfGreen = moves.pawnBeatGreenPawn(actualPositionOfRed, actualPositionOfGreen,
                        roadOfRedPawns, roadOfGreenPawns,
                        imageView5, imageView6, imageView7, imageView8,
                        homeGreenPawns, homeGreen, gridPageGame2);

                actualPositionOfBlue = moves.pawnBeatBluePawn(actualPositionOfRed, actualPositionOfBlue,
                        roadOfRedPawns, roadOfBluePawns,
                        imageView13, imageView14, imageView15, imageView16,
                        homeBluePawns, homeBlue, gridPageGame2);

                //This method decided about able or disable buttons depending of turn and full of bases
                moves.buttonsAbleAndDisable(baseOfRedPawns, baseOfBluePawns, baseOfYellowPawns, baseOfGreenPawns,
                        buttonOfRed, buttonOfBlue, buttonOfYellow, buttonOfGreen, ranking);

                //This method check who Player's won
                moves.checkWinner(baseOfYellowPawns, baseOfGreenPawns, baseOfRedPawns, baseOfBluePawns, ranking,
                        buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue, firstPlace, secendPlace, thirdPlace, fourthPlace, gridPageGame2);

                //This method decided about moves pawns belong to computer
                moves.computerMove(buttonOfBlue, buttonOfRed, buttonOfYellow, numbersOfPlayers);
            }
        });
        buttonOfBlue.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //This method generatet and display dice result
                int result = dice.generatedAndDisplayResultForComputerPlayer(actualPositionOfBlue, level, labelOfBlue, gridPageGame2);

                // This method decides if the pawn can leave the base
                int startPositionFromMethod = (moves.pawnsMove(result, baseOfBluePawns, homeBluePawns,
                        imageView13, imageView14, imageView15, imageView16,
                        roadOfBluePawns, gridPageGame2, actualPositionOfBlue));
                actualPositionOfBlue = startPositionFromMethod;

                // This method decides move pawn outside of base
                startPositionFromMethod = moves.moveFromBase(result, homeBluePawns, baseOfBluePawns,
                        imageView13, imageView14, imageView15, imageView16,
                        roadOfBluePawns, gridPageGame2, actualPositionOfBlue);
                actualPositionOfBlue = startPositionFromMethod;

                //These three methods analyze the capture of a pawn by a pawn in motion
                actualPositionOfYellow = moves.pawnBeatYellowPawn(actualPositionOfBlue, actualPositionOfYellow,
                        roadOfBluePawns, roadOfYellowPawns,
                        imageView1, imageView2, imageView3, imageView4,
                        homeYellowPawns, homeYellow, gridPageGame2);

                actualPositionOfGreen = moves.pawnBeatGreenPawn(actualPositionOfBlue, actualPositionOfGreen,
                        roadOfBluePawns, roadOfGreenPawns,
                        imageView5, imageView6, imageView7, imageView8,
                        homeGreenPawns, homeGreen, gridPageGame2);

                actualPositionOfRed = moves.pawnBeatRedPawn(actualPositionOfBlue, actualPositionOfRed,
                        roadOfBluePawns, roadOfRedPawns,
                        imageView9, imageView10, imageView11, imageView12,
                        homeRedPawns, homeRed, gridPageGame2);

                //This method decided about able or disable buttons depending of turn and full of bases
                moves.buttonsAbleAndDisable(baseOfBluePawns, baseOfYellowPawns, baseOfGreenPawns, baseOfRedPawns,
                        buttonOfBlue, buttonOfYellow, buttonOfGreen, buttonOfRed, ranking);

                //This method check who Player's won
                moves.checkWinner(baseOfYellowPawns, baseOfGreenPawns, baseOfRedPawns, baseOfBluePawns, ranking,
                        buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue, firstPlace, secendPlace, thirdPlace, fourthPlace, gridPageGame2);

                //This method decided about moves pawns belong to computer
                moves.computerMove(buttonOfRed, buttonOfBlue, buttonOfYellow, numbersOfPlayers);
            }
        });
        endGame.setOnAction(e -> {
            Scene pageIntroduce = getPageIntroduce();
            window.setScene(pageIntroduce);
        });
        Scene pageGame2 = new Scene(gridPageGame2, 960, height, Color.WHITESMOKE);
        return pageGame2;
    }

    public Scene getPageGame3(String namePlayer1, String namePlayer2, String namePlayer3, String level) {
        GridPane gridPageGame3 = new GridPane();
        int numbersOfPlayers = 3;

        List<Pawn> homeYellowPawns = new ArrayList<>();
        Pawn yellow1 = new Pawn();
        Pawn yellow2 = new Pawn();
        Pawn yellow3 = new Pawn();
        Pawn yellow4 = new Pawn();

        homeYellowPawns.add(yellow1);
        homeYellowPawns.add(yellow2);
        homeYellowPawns.add(yellow3);
        homeYellowPawns.add(yellow4);

        List<Pawn> homeRedPawns = new ArrayList<>();
        Pawn red1 = new Pawn();
        Pawn red2 = new Pawn();
        Pawn red3 = new Pawn();
        Pawn red4 = new Pawn();

        homeRedPawns.add(red1);
        homeRedPawns.add(red2);
        homeRedPawns.add(red3);
        homeRedPawns.add(red4);

        List<Pawn> homeGreenPawns = new ArrayList<>();
        Pawn green1 = new Pawn();
        Pawn green2 = new Pawn();
        Pawn green3 = new Pawn();
        Pawn green4 = new Pawn();

        homeGreenPawns.add(green1);
        homeGreenPawns.add(green2);
        homeGreenPawns.add(green3);
        homeGreenPawns.add(green4);

        List<Pawn> homeBluePawns = new ArrayList<>();
        Pawn blue1 = new Pawn();
        Pawn blue2 = new Pawn();
        Pawn blue3 = new Pawn();
        Pawn blue4 = new Pawn();

        homeBluePawns.add(blue1);
        homeBluePawns.add(blue2);
        homeBluePawns.add(blue3);
        homeBluePawns.add(blue4);

        List<Pawn> baseOfYellowPawns = new ArrayList<>();
        List<Pawn> baseOfRedPawns = new ArrayList<>();
        List<Pawn> baseOfGreenPawns = new ArrayList<>();
        List<Pawn> baseOfBluePawns = new ArrayList<>();

        Map<Integer, Point> homeYellow = new HashMap<>();
        homeYellow.put(1, new Point(0, 0));
        homeYellow.put(2, new Point(0, 1));
        homeYellow.put(3, new Point(1, 0));
        homeYellow.put(4, new Point(1, 1));

        Map<Integer, Point> homeRed = new HashMap<>();
        homeRed.put(1, new Point(9, 9));
        homeRed.put(2, new Point(9, 10));
        homeRed.put(3, new Point(10, 9));
        homeRed.put(4, new Point(10, 10));

        Map<Integer, Point> homeGreen = new HashMap<>();
        homeGreen.put(1, new Point(9, 0));
        homeGreen.put(2, new Point(9, 1));
        homeGreen.put(3, new Point(10, 0));
        homeGreen.put(4, new Point(10, 1));

        Map<Integer, Point> homeBlue = new HashMap<>();
        homeBlue.put(1, new Point(0, 9));
        homeBlue.put(2, new Point(0, 10));
        homeBlue.put(3, new Point(1, 9));
        homeBlue.put(4, new Point(1, 10));

        List<List> ranking = new ArrayList<>();

        ListOfPositions yellowList = new ListOfPositions();
        Map<Integer, Point> roadOfYellowPawns = yellowList.positionForYellowPawns();
        ListOfPositions greeenList = new ListOfPositions();
        Map<Integer, Point> roadOfGreenPawns = greeenList.positionForGreenPawns();
        ListOfPositions redList = new ListOfPositions();
        Map<Integer, Point> roadOfRedPawns = redList.positionForRedPawns();
        ListOfPositions blueList = new ListOfPositions();
        Map<Integer, Point> roadOfBluePawns = blueList.positionForBluePawns();

        //Ustawienie tła (planszy)
        gridPageGame3.setAlignment(Pos.TOP_LEFT);
        gridPageGame3.setBackground(game.getGameBackground());

        // Podział planaszy na pola (współrzędne)
        int rowCount = 11;
        int columnCount = 16;
        row.setPercentHeight(100d / rowCount);

        for (int i = 0; i < rowCount; i++) {
            gridPageGame3.getRowConstraints().add(row);
        }

        column.setPercentWidth(100d / columnCount);

        for (int i = 0; i < columnCount; i++) {
            gridPageGame3.getColumnConstraints().add(column);
        }

        ImageView imageView1 = yellow1.getPawnYellow();
        ImageView imageView2 = yellow2.getPawnYellow();
        ImageView imageView3 = yellow3.getPawnYellow();
        ImageView imageView4 = yellow4.getPawnYellow();

        gridPageGame3.add(imageView1, homeYellow.get(1).getColumn(), homeYellow.get(1).getRow());
        gridPageGame3.add(imageView2, homeYellow.get(2).getColumn(), homeYellow.get(2).getRow());
        gridPageGame3.add(imageView3, homeYellow.get(3).getColumn(), homeYellow.get(3).getRow());
        gridPageGame3.add(imageView4, homeYellow.get(4).getColumn(), homeYellow.get(4).getRow());

        // Ustawienie pioków zielonych w bazie
        ImageView imageView5 = green1.getPawnGreen();
        ImageView imageView6 = green2.getPawnGreen();
        ImageView imageView7 = green3.getPawnGreen();
        ImageView imageView8 = green4.getPawnGreen();

        gridPageGame3.add(imageView5, homeGreen.get(1).getColumn(), homeGreen.get(1).getRow());
        gridPageGame3.add(imageView6, homeGreen.get(2).getColumn(), homeGreen.get(2).getRow());
        gridPageGame3.add(imageView7, homeGreen.get(3).getColumn(), homeGreen.get(3).getRow());
        gridPageGame3.add(imageView8, homeGreen.get(4).getColumn(), homeGreen.get(4).getRow());

        // Ustawienie pionków czerwonych w bazie
        ImageView imageView9 = red1.getPawnRed();
        ImageView imageView10 = red2.getPawnRed();
        ImageView imageView11 = red3.getPawnRed();
        ImageView imageView12 = red4.getPawnRed();

        gridPageGame3.add(imageView9, homeRed.get(1).getColumn(), homeRed.get(1).getRow());
        gridPageGame3.add(imageView10, homeRed.get(2).getColumn(), homeRed.get(2).getRow());
        gridPageGame3.add(imageView11, homeRed.get(3).getColumn(), homeRed.get(3).getRow());
        gridPageGame3.add(imageView12, homeRed.get(4).getColumn(), homeRed.get(4).getRow());

        // Ustawienie pionków niebieskich w bazie
        ImageView imageView13 = blue1.getPawnBlue();
        ImageView imageView14 = blue2.getPawnBlue();
        ImageView imageView15 = blue3.getPawnBlue();
        ImageView imageView16 = blue4.getPawnBlue();

        gridPageGame3.add(imageView13, homeBlue.get(1).getColumn(), homeBlue.get(1).getRow());
        gridPageGame3.add(imageView14, homeBlue.get(2).getColumn(), homeBlue.get(2).getRow());
        gridPageGame3.add(imageView15, homeBlue.get(3).getColumn(), homeBlue.get(3).getRow());
        gridPageGame3.add(imageView16, homeBlue.get(4).getColumn(), homeBlue.get(4).getRow());

        gridPageGame3.setGridLinesVisible(false); //Powoduje widocznośc lub niewidoczność poidzału planszy kolumny iw iersze

        //Buttons
        Button buttonOfYellow = new Button(namePlayer1 + " get move");
        Button buttonOfGreen = new Button(namePlayer2 + " get move");
        Button buttonOfRed = new Button(namePlayer3 + " get move");
        Button buttonOfBlue = new Button("Blue get move");
        Button endGame = new Button("End Game");
        Button whoStart = new Button("Who start");
        Label labelOfYellow = new Label("Dice result:" + textDice);
        Label labelOfGreen = new Label("Dice result:" + textDice);
        Label labelOfRed = new Label("Dice result:" + textDice);
        Label labelOfBlue = new Label("Dice result:" + textDice);
        Label whoWin = new Label("Ranking: ");
        Label levelOfGame = new Label("Level: " + level);
        Label firstPlace = new Label();
        Label secendPlace = new Label();
        Label thirdPlace = new Label();
        Label fourthPlace = new Label();
        Label endGames = new Label();

        GridPane.setConstraints(buttonOfYellow, 2, 0, 2, 2);
        GridPane.setConstraints(buttonOfGreen, 11, 0, 2, 2);
        GridPane.setConstraints(buttonOfRed, 11, 9, 2, 2);
        GridPane.setConstraints(buttonOfBlue, 2, 9, 2, 2);
        GridPane.setConstraints(labelOfYellow, 2, 1, 2, 1);
        GridPane.setConstraints(labelOfGreen, 11, 1, 2, 1);
        GridPane.setConstraints(labelOfRed, 11, 10, 2, 1);
        GridPane.setConstraints(labelOfBlue, 2, 10, 2, 1);
        GridPane.setConstraints(endGame, 13, 10, 3, 1);
        GridPane.setConstraints(whoStart, 13, 1, 3, 1);
        GridPane.setConstraints(whoWin, 13, 4, 3, 1);
        GridPane.setConstraints(levelOfGame, 13, 2, 3, 1);
        GridPane.setConstraints(firstPlace, 13, 5, 3, 1);
        GridPane.setConstraints(secendPlace, 13, 6, 3, 1);
        GridPane.setConstraints(thirdPlace, 13, 7, 3, 1);
        GridPane.setConstraints(fourthPlace, 13, 8, 3, 1);
        gridPageGame3.setMargin(endGame, new Insets(0, 100, 10, 0));

        buttonOfYellow.setDisable(true);
        buttonOfGreen.setDisable(true);
        buttonOfRed.setDisable(true);
        buttonOfBlue.setDisable(true);

        // Set player who start the game
        whoStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                moves.whoStart(buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue, numbersOfPlayers);
                whoStart.setDisable(true);
            }
        });

        gridPageGame3.getChildren().addAll(buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue,
                labelOfYellow, labelOfGreen, labelOfRed, labelOfBlue, whoStart, endGame, whoWin, levelOfGame);

        buttonOfYellow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //This method generatet and display dice result
                int result = dice.generatedAndDisplayResultForHumanPlayer(actualPositionOfYellow, level, labelOfYellow, gridPageGame3);

                // This method decides if the pawn can leave the base
                int startPositionFromMethod = (moves.pawnsMove(result, baseOfYellowPawns, homeYellowPawns,
                        imageView1, imageView2, imageView3, imageView4,
                        roadOfYellowPawns, gridPageGame3, actualPositionOfYellow));
                actualPositionOfYellow = startPositionFromMethod;

                // This method decides move pawn outside of base
                startPositionFromMethod = moves.moveFromBase(result, homeYellowPawns, baseOfYellowPawns,
                        imageView1, imageView2, imageView3, imageView4,
                        roadOfYellowPawns, gridPageGame3, actualPositionOfYellow);
                actualPositionOfYellow = startPositionFromMethod;

                //These three methods analyze the capture of a pawn by a pawn in motion
                actualPositionOfGreen = moves.pawnBeatGreenPawn(actualPositionOfYellow, actualPositionOfGreen,
                        roadOfYellowPawns, roadOfGreenPawns,
                        imageView5, imageView6, imageView7, imageView8,
                        homeGreenPawns, homeGreen, gridPageGame3);

                actualPositionOfRed = moves.pawnBeatRedPawn(actualPositionOfYellow, actualPositionOfRed,
                        roadOfYellowPawns, roadOfRedPawns,
                        imageView9, imageView10, imageView11, imageView12,
                        homeRedPawns, homeRed, gridPageGame3);

                actualPositionOfBlue = moves.pawnBeatBluePawn(actualPositionOfYellow, actualPositionOfBlue,
                        roadOfYellowPawns, roadOfBluePawns,
                        imageView13, imageView14, imageView15, imageView16,
                        homeBluePawns, homeBlue, gridPageGame3);

                //This method decided about able or disable buttons depending of turn and full of bases
                moves.buttonsAbleAndDisable(baseOfYellowPawns, baseOfGreenPawns, baseOfRedPawns, baseOfBluePawns,
                        buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue, ranking);

                //This method check who Player's won
                moves.checkWinner(baseOfYellowPawns, baseOfGreenPawns, baseOfRedPawns, baseOfBluePawns, ranking,
                        buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue, firstPlace, secendPlace, thirdPlace, fourthPlace, gridPageGame3);

                //This method decided about moves pawns belong to computer
                moves.computerMove(buttonOfBlue, buttonOfYellow, buttonOfGreen, numbersOfPlayers);
            }
        });
        buttonOfGreen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //This method generatet and display dice result
                int result = dice.generatedAndDisplayResultForHumanPlayer(actualPositionOfGreen, level, labelOfGreen, gridPageGame3);

                // This method decides if the pawn can leave the base
                int startPositionFromMethod = (moves.pawnsMove(result, baseOfGreenPawns, homeGreenPawns,
                        imageView5, imageView6, imageView7, imageView8,
                        roadOfGreenPawns, gridPageGame3, actualPositionOfGreen));
                actualPositionOfGreen = startPositionFromMethod;

                // This method decides move pawn outside of base
                startPositionFromMethod = moves.moveFromBase(result, homeGreenPawns, baseOfGreenPawns,
                        imageView5, imageView6, imageView7, imageView8,
                        roadOfGreenPawns, gridPageGame3, actualPositionOfGreen);
                actualPositionOfGreen = startPositionFromMethod;

                //These three methods analyze the capture of a pawn by a pawn in motion
                actualPositionOfYellow = moves.pawnBeatYellowPawn(actualPositionOfGreen, actualPositionOfYellow,
                        roadOfGreenPawns, roadOfYellowPawns,
                        imageView1, imageView2, imageView3, imageView4,
                        homeYellowPawns, homeYellow, gridPageGame3);

                actualPositionOfRed = moves.pawnBeatRedPawn(actualPositionOfGreen, actualPositionOfRed,
                        roadOfGreenPawns, roadOfRedPawns,
                        imageView9, imageView10, imageView11, imageView12,
                        homeRedPawns, homeRed, gridPageGame3);

                actualPositionOfBlue = moves.pawnBeatBluePawn(actualPositionOfGreen, actualPositionOfBlue,
                        roadOfGreenPawns, roadOfBluePawns,
                        imageView13, imageView14, imageView15, imageView16,
                        homeBluePawns, homeBlue, gridPageGame3);

                //This method decided about able or disable buttons depending of turn and full of bases
                moves.buttonsAbleAndDisable(baseOfGreenPawns, baseOfRedPawns, baseOfBluePawns, baseOfYellowPawns,
                        buttonOfGreen, buttonOfRed, buttonOfBlue, buttonOfYellow, ranking);

                //This method check who Player's won
                moves.checkWinner(baseOfYellowPawns, baseOfGreenPawns, baseOfRedPawns, baseOfBluePawns, ranking,
                        buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue, firstPlace, secendPlace, thirdPlace, fourthPlace, gridPageGame3);

                //This method decided about moves pawns belong to computer
                moves.computerMove(buttonOfBlue, buttonOfYellow, buttonOfGreen, numbersOfPlayers);
            }
        });
        buttonOfRed.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //This method generatet and display dice result
                int result = dice.generatedAndDisplayResultForHumanPlayer(actualPositionOfRed, level, labelOfRed, gridPageGame3);

                // This method decides if the pawn can leave the base
                int startPositionFromMethod = (moves.pawnsMove(result, baseOfRedPawns, homeRedPawns,
                        imageView9, imageView10, imageView11, imageView12,
                        roadOfRedPawns, gridPageGame3, actualPositionOfRed));
                actualPositionOfRed = startPositionFromMethod;

                // This method decides move pawn outside of base
                startPositionFromMethod = moves.moveFromBase(result, homeRedPawns, baseOfRedPawns,
                        imageView9, imageView10, imageView11, imageView12,
                        roadOfRedPawns, gridPageGame3, actualPositionOfRed);
                actualPositionOfRed = startPositionFromMethod;

                //These three methods analyze the capture of a pawn by a pawn in motion
                actualPositionOfYellow = moves.pawnBeatYellowPawn(actualPositionOfRed, actualPositionOfYellow,
                        roadOfRedPawns, roadOfYellowPawns,
                        imageView1, imageView2, imageView3, imageView4,
                        homeYellowPawns, homeYellow, gridPageGame3);

                actualPositionOfGreen = moves.pawnBeatGreenPawn(actualPositionOfRed, actualPositionOfGreen,
                        roadOfRedPawns, roadOfGreenPawns,
                        imageView5, imageView6, imageView7, imageView8,
                        homeGreenPawns, homeGreen, gridPageGame3);

                actualPositionOfBlue = moves.pawnBeatBluePawn(actualPositionOfRed, actualPositionOfBlue,
                        roadOfRedPawns, roadOfBluePawns,
                        imageView13, imageView14, imageView15, imageView16,
                        homeBluePawns, homeBlue, gridPageGame3);

                //This method decided about able or disable buttons depending of turn and full of bases
                moves.buttonsAbleAndDisable(baseOfRedPawns, baseOfBluePawns, baseOfYellowPawns, baseOfGreenPawns,
                        buttonOfRed, buttonOfBlue, buttonOfYellow, buttonOfGreen, ranking);

                //This method check who Player's won
                moves.checkWinner(baseOfYellowPawns, baseOfGreenPawns, baseOfRedPawns, baseOfBluePawns, ranking,
                        buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue, firstPlace, secendPlace, thirdPlace, fourthPlace, gridPageGame3);

                //This method decided about moves pawns belong to computer
                moves.computerMove(buttonOfBlue, buttonOfYellow, buttonOfGreen, numbersOfPlayers);
            }
        });
        buttonOfBlue.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //This method generatet and display dice result
                int result = dice.generatedAndDisplayResultForComputerPlayer(actualPositionOfBlue, level, labelOfBlue, gridPageGame3);

                // This method decides if the pawn can leave the base
                int startPositionFromMethod = (moves.pawnsMove(result, baseOfBluePawns, homeBluePawns,
                        imageView13, imageView14, imageView15, imageView16,
                        roadOfBluePawns, gridPageGame3, actualPositionOfBlue));
                actualPositionOfBlue = startPositionFromMethod;

                // This method decides move pawn outside of base
                startPositionFromMethod = moves.moveFromBase(result, homeBluePawns, baseOfBluePawns,
                        imageView13, imageView14, imageView15, imageView16,
                        roadOfBluePawns, gridPageGame3, actualPositionOfBlue);
                actualPositionOfBlue = startPositionFromMethod;

                //These three methods analyze the capture of a pawn by a pawn in motion
                actualPositionOfYellow = moves.pawnBeatYellowPawn(actualPositionOfBlue, actualPositionOfYellow,
                        roadOfBluePawns, roadOfYellowPawns,
                        imageView1, imageView2, imageView3, imageView4,
                        homeYellowPawns, homeYellow, gridPageGame3);

                actualPositionOfGreen = moves.pawnBeatGreenPawn(actualPositionOfBlue, actualPositionOfGreen,
                        roadOfBluePawns, roadOfGreenPawns,
                        imageView5, imageView6, imageView7, imageView8,
                        homeGreenPawns, homeGreen, gridPageGame3);

                actualPositionOfRed = moves.pawnBeatRedPawn(actualPositionOfBlue, actualPositionOfRed,
                        roadOfBluePawns, roadOfRedPawns,
                        imageView9, imageView10, imageView11, imageView12,
                        homeRedPawns, homeRed, gridPageGame3);

                //This method decided about able or disable buttons depending of turn and full of bases
                moves.buttonsAbleAndDisable(baseOfBluePawns, baseOfYellowPawns, baseOfGreenPawns, baseOfRedPawns,
                        buttonOfBlue, buttonOfYellow, buttonOfGreen, buttonOfRed, ranking);

                //This method check who Player's won
                moves.checkWinner(baseOfYellowPawns, baseOfGreenPawns, baseOfRedPawns, baseOfBluePawns, ranking,
                        buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue, firstPlace, secendPlace, thirdPlace, fourthPlace, gridPageGame3);
            }
        });
        endGame.setOnAction(e -> {
            Scene pageIntroduce = getPageIntroduce();
            window.setScene(pageIntroduce);
        });
        Scene pageGame3 = new Scene(gridPageGame3, 960, height, Color.WHITESMOKE);
        return pageGame3;
    }


    public Scene getPageGame4(String namePlayer1, String namePlayer2, String namePlayer3, String namePlayer4, String level) {
        GridPane gridPageGame4 = new GridPane();
        int numbersOfPlayers = 4;
        //List of yellow pawns in home
        List<Pawn> homeYellowPawns = new ArrayList<>();
        Pawn yellow1 = new Pawn();
        Pawn yellow2 = new Pawn();
        Pawn yellow3 = new Pawn();
        Pawn yellow4 = new Pawn();

        homeYellowPawns.add(yellow1);
        homeYellowPawns.add(yellow2);
        homeYellowPawns.add(yellow3);
        homeYellowPawns.add(yellow4);

        //List of red pawns in home
        List<Pawn> homeRedPawns = new ArrayList<>();
        Pawn red1 = new Pawn();
        Pawn red2 = new Pawn();
        Pawn red3 = new Pawn();
        Pawn red4 = new Pawn();

        homeRedPawns.add(red1);
        homeRedPawns.add(red2);
        homeRedPawns.add(red3);
        homeRedPawns.add(red4);

        //List of green pawns in home
        List<Pawn> homeGreenPawns = new ArrayList<>();
        Pawn green1 = new Pawn();
        Pawn green2 = new Pawn();
        Pawn green3 = new Pawn();
        Pawn green4 = new Pawn();

        homeGreenPawns.add(green1);
        homeGreenPawns.add(green2);
        homeGreenPawns.add(green3);
        homeGreenPawns.add(green4);

        //List of blue pawns in home
        List<Pawn> homeBluePawns = new ArrayList<>();
        Pawn blue1 = new Pawn();
        Pawn blue2 = new Pawn();
        Pawn blue3 = new Pawn();
        Pawn blue4 = new Pawn();

        homeBluePawns.add(blue1);
        homeBluePawns.add(blue2);
        homeBluePawns.add(blue3);
        homeBluePawns.add(blue4);

        List<Pawn> baseOfYellowPawns = new ArrayList<>();
        List<Pawn> baseOfRedPawns = new ArrayList<>();
        List<Pawn> baseOfGreenPawns = new ArrayList<>();
        List<Pawn> baseOfBluePawns = new ArrayList<>();

        Map<Integer, Point> homeYellow = new HashMap<>();
        homeYellow.put(1, new Point(0, 0));
        homeYellow.put(2, new Point(0, 1));
        homeYellow.put(3, new Point(1, 0));
        homeYellow.put(4, new Point(1, 1));

        Map<Integer, Point> homeRed = new HashMap<>();
        homeRed.put(1, new Point(9, 9));
        homeRed.put(2, new Point(9, 10));
        homeRed.put(3, new Point(10, 9));
        homeRed.put(4, new Point(10, 10));

        Map<Integer, Point> homeGreen = new HashMap<>();
        homeGreen.put(1, new Point(9, 0));
        homeGreen.put(2, new Point(9, 1));
        homeGreen.put(3, new Point(10, 0));
        homeGreen.put(4, new Point(10, 1));

        Map<Integer, Point> homeBlue = new HashMap<>();
        homeBlue.put(1, new Point(0, 9));
        homeBlue.put(2, new Point(0, 10));
        homeBlue.put(3, new Point(1, 9));
        homeBlue.put(4, new Point(1, 10));

        List<List> ranking = new ArrayList<>();

        ListOfPositions yellowList = new ListOfPositions();
        Map<Integer, Point> roadOfYellowPawns = yellowList.positionForYellowPawns();
        ListOfPositions greeenList = new ListOfPositions();
        Map<Integer, Point> roadOfGreenPawns = greeenList.positionForGreenPawns();
        ListOfPositions redList = new ListOfPositions();
        Map<Integer, Point> roadOfRedPawns = redList.positionForRedPawns();
        ListOfPositions blueList = new ListOfPositions();
        Map<Integer, Point> roadOfBluePawns = blueList.positionForBluePawns();

        //********************************************************************

        //Ustawienie tła (planszy)
        gridPageGame4.setAlignment(Pos.TOP_LEFT);
        gridPageGame4.setBackground(game.getGameBackground());

        // Podział planaszy na pola (współrzędne)
        int rowCount = 11;
        int columnCount = 16;
        row.setPercentHeight(100d / rowCount);

        for (int i = 0; i < rowCount; i++) {
            gridPageGame4.getRowConstraints().add(row);
        }

        column.setPercentWidth(100d / columnCount);

        for (int i = 0; i < columnCount; i++) {
            gridPageGame4.getColumnConstraints().add(column);
        }

        ImageView imageView1 = yellow1.getPawnYellow();
        ImageView imageView2 = yellow2.getPawnYellow();
        ImageView imageView3 = yellow3.getPawnYellow();
        ImageView imageView4 = yellow4.getPawnYellow();

        gridPageGame4.add(imageView1, homeYellow.get(1).getColumn(), homeYellow.get(1).getRow());
        gridPageGame4.add(imageView2, homeYellow.get(2).getColumn(), homeYellow.get(2).getRow());
        gridPageGame4.add(imageView3, homeYellow.get(3).getColumn(), homeYellow.get(3).getRow());
        gridPageGame4.add(imageView4, homeYellow.get(4).getColumn(), homeYellow.get(4).getRow());

        // Ustawienie pioków zielonych w bazie
        ImageView imageView5 = green1.getPawnGreen();
        ImageView imageView6 = green2.getPawnGreen();
        ImageView imageView7 = green3.getPawnGreen();
        ImageView imageView8 = green4.getPawnGreen();

        gridPageGame4.add(imageView5, homeGreen.get(1).getColumn(), homeGreen.get(1).getRow());
        gridPageGame4.add(imageView6, homeGreen.get(2).getColumn(), homeGreen.get(2).getRow());
        gridPageGame4.add(imageView7, homeGreen.get(3).getColumn(), homeGreen.get(3).getRow());
        gridPageGame4.add(imageView8, homeGreen.get(4).getColumn(), homeGreen.get(4).getRow());

        // Ustawienie pionków czerwonych w bazie
        ImageView imageView9 = red1.getPawnRed();
        ImageView imageView10 = red2.getPawnRed();
        ImageView imageView11 = red3.getPawnRed();
        ImageView imageView12 = red4.getPawnRed();

        gridPageGame4.add(imageView9, homeRed.get(1).getColumn(), homeRed.get(1).getRow());
        gridPageGame4.add(imageView10, homeRed.get(2).getColumn(), homeRed.get(2).getRow());
        gridPageGame4.add(imageView11, homeRed.get(3).getColumn(), homeRed.get(3).getRow());
        gridPageGame4.add(imageView12, homeRed.get(4).getColumn(), homeRed.get(4).getRow());

        // Ustawienie pionków niebieskich w bazie
        ImageView imageView13 = blue1.getPawnBlue();
        ImageView imageView14 = blue2.getPawnBlue();
        ImageView imageView15 = blue3.getPawnBlue();
        ImageView imageView16 = blue4.getPawnBlue();

        gridPageGame4.add(imageView13, homeBlue.get(1).getColumn(), homeBlue.get(1).getRow());
        gridPageGame4.add(imageView14, homeBlue.get(2).getColumn(), homeBlue.get(2).getRow());
        gridPageGame4.add(imageView15, homeBlue.get(3).getColumn(), homeBlue.get(3).getRow());
        gridPageGame4.add(imageView16, homeBlue.get(4).getColumn(), homeBlue.get(4).getRow());

        gridPageGame4.setGridLinesVisible(false); //Powoduje widocznośc lub niewidoczność poidzału planszy kolumny iw iersze

        //Buttons
        Button buttonOfYellow = new Button(namePlayer1 + " get move");
        Button buttonOfGreen = new Button(namePlayer2 + " get move");
        Button buttonOfRed = new Button(namePlayer3 + " get move");
        Button buttonOfBlue = new Button(namePlayer4 + " get move");
        Button endGame = new Button("End Game");
        Button whoStart = new Button("Who start");
        Label labelOfYellow = new Label("Dice result:" + textDice);
        Label labelOfGreen = new Label("Dice result:" + textDice);
        Label labelOfRed = new Label("Dice result:" + textDice);
        Label labelOfBlue = new Label("Dice result:" + textDice);
        Label whoWin = new Label("Ranking: ");
        Label levelOfGame = new Label("Level: " + level);
        Label firstPlace = new Label();
        Label secendPlace = new Label();
        Label thirdPlace = new Label();
        Label fourthPlace = new Label();

        GridPane.setConstraints(buttonOfYellow, 2, 0, 2, 2);
        GridPane.setConstraints(buttonOfGreen, 11, 0, 2, 2);
        GridPane.setConstraints(buttonOfRed, 11, 9, 2, 2);
        GridPane.setConstraints(buttonOfBlue, 2, 9, 2, 2);
        GridPane.setConstraints(labelOfYellow, 2, 1, 2, 1);
        GridPane.setConstraints(labelOfGreen, 11, 1, 2, 1);
        GridPane.setConstraints(labelOfRed, 11, 10, 2, 1);
        GridPane.setConstraints(labelOfBlue, 2, 10, 2, 1);
        GridPane.setConstraints(endGame, 13, 10, 3, 1);
        GridPane.setConstraints(whoStart, 13, 1, 3, 1);
        GridPane.setConstraints(whoWin, 13, 4, 3, 1);
        GridPane.setConstraints(levelOfGame, 13, 2, 3, 1);
        GridPane.setConstraints(firstPlace, 13, 5, 3, 1);
        GridPane.setConstraints(secendPlace, 13, 6, 3, 1);
        GridPane.setConstraints(thirdPlace, 13, 7, 3, 1);
        GridPane.setConstraints(fourthPlace, 13, 8, 3, 1);
        gridPageGame4.setMargin(endGame, new Insets(0, 100, 10, 0));

        buttonOfYellow.setDisable(true);
        buttonOfGreen.setDisable(true);
        buttonOfRed.setDisable(true);
        buttonOfBlue.setDisable(true);

        // Set player who start the game
        whoStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                moves.whoStart(buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue, numbersOfPlayers);
                whoStart.setDisable(true);
            }
        });

        gridPageGame4.getChildren().addAll(buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue,
                labelOfYellow, labelOfGreen, labelOfRed, labelOfBlue, whoStart, endGame, whoWin, levelOfGame);

        buttonOfYellow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //This method generatet and display dice result
                int result = dice.generatedAndDisplayResultForHumanPlayer(actualPositionOfYellow, level, labelOfYellow, gridPageGame4);

                // This method decides if the pawn can leave the base
                int startPositionFromMethod = (moves.pawnsMove(result, baseOfYellowPawns, homeYellowPawns,
                        imageView1, imageView2, imageView3, imageView4,
                        roadOfYellowPawns, gridPageGame4, actualPositionOfYellow));
                actualPositionOfYellow = startPositionFromMethod;

                // This method decides move pawn outside of base
                startPositionFromMethod = moves.moveFromBase(result, homeYellowPawns, baseOfYellowPawns,
                        imageView1, imageView2, imageView3, imageView4,
                        roadOfYellowPawns, gridPageGame4, actualPositionOfYellow);
                actualPositionOfYellow = startPositionFromMethod;

                //These three methods analyze the capture of a pawn by a pawn in motion
                actualPositionOfGreen = moves.pawnBeatGreenPawn(actualPositionOfYellow, actualPositionOfGreen,
                        roadOfYellowPawns, roadOfGreenPawns,
                        imageView5, imageView6, imageView7, imageView8,
                        homeGreenPawns, homeGreen, gridPageGame4);

                actualPositionOfRed = moves.pawnBeatRedPawn(actualPositionOfYellow, actualPositionOfRed,
                        roadOfYellowPawns, roadOfRedPawns,
                        imageView9, imageView10, imageView11, imageView12,
                        homeRedPawns, homeRed, gridPageGame4);

                actualPositionOfBlue = moves.pawnBeatBluePawn(actualPositionOfYellow, actualPositionOfBlue,
                        roadOfYellowPawns, roadOfBluePawns,
                        imageView13, imageView14, imageView15, imageView16,
                        homeBluePawns, homeBlue, gridPageGame4);

                //This method decided about able or disable buttons depending of turn and full of bases
                moves.buttonsAbleAndDisable(baseOfYellowPawns, baseOfGreenPawns, baseOfRedPawns, baseOfBluePawns,
                        buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue, ranking);

                //This method check who Player's won
                moves.checkWinner(baseOfYellowPawns, baseOfGreenPawns, baseOfRedPawns, baseOfBluePawns, ranking,
                        buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue, firstPlace, secendPlace, thirdPlace, fourthPlace, gridPageGame4);
            }
        });
        buttonOfGreen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //This method generatet and display dice result
                int result = dice.generatedAndDisplayResultForHumanPlayer(actualPositionOfGreen, level, labelOfGreen, gridPageGame4);

                // This method decides if the pawn can leave the base
                int startPositionFromMethod = (moves.pawnsMove(result, baseOfGreenPawns, homeGreenPawns,
                        imageView5, imageView6, imageView7, imageView8,
                        roadOfGreenPawns, gridPageGame4, actualPositionOfGreen));
                actualPositionOfGreen = startPositionFromMethod;

                // This method decides move pawn outside of base
                startPositionFromMethod = moves.moveFromBase(result, homeGreenPawns, baseOfGreenPawns,
                        imageView5, imageView6, imageView7, imageView8,
                        roadOfGreenPawns, gridPageGame4, actualPositionOfGreen);
                actualPositionOfGreen = startPositionFromMethod;

                //These three methods analyze the capture of a pawn by a pawn in motion
                actualPositionOfYellow = moves.pawnBeatYellowPawn(actualPositionOfGreen, actualPositionOfYellow,
                        roadOfGreenPawns, roadOfYellowPawns,
                        imageView1, imageView2, imageView3, imageView4,
                        homeYellowPawns, homeYellow, gridPageGame4);

                actualPositionOfRed = moves.pawnBeatRedPawn(actualPositionOfGreen, actualPositionOfRed,
                        roadOfGreenPawns, roadOfRedPawns,
                        imageView9, imageView10, imageView11, imageView12,
                        homeRedPawns, homeRed, gridPageGame4);

                actualPositionOfBlue = moves.pawnBeatBluePawn(actualPositionOfGreen, actualPositionOfBlue,
                        roadOfGreenPawns, roadOfBluePawns,
                        imageView13, imageView14, imageView15, imageView16,
                        homeBluePawns, homeBlue, gridPageGame4);

                //This method decided about able or disable buttons depending of turn and full of bases
                moves.buttonsAbleAndDisable(baseOfGreenPawns, baseOfRedPawns, baseOfBluePawns, baseOfYellowPawns,
                        buttonOfGreen, buttonOfRed, buttonOfBlue, buttonOfYellow, ranking);

                //This method check who Player's won
                moves.checkWinner(baseOfYellowPawns, baseOfGreenPawns, baseOfRedPawns, baseOfBluePawns, ranking,
                        buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue, firstPlace, secendPlace, thirdPlace, fourthPlace, gridPageGame4);
            }
        });
        buttonOfRed.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //This method generatet and display dice result
                int result = dice.generatedAndDisplayResultForHumanPlayer(actualPositionOfRed, level, labelOfRed, gridPageGame4);

                // This method decides if the pawn can leave the base
                int startPositionFromMethod = (moves.pawnsMove(result, baseOfRedPawns, homeRedPawns,
                        imageView9, imageView10, imageView11, imageView12,
                        roadOfRedPawns, gridPageGame4, actualPositionOfRed));
                actualPositionOfRed = startPositionFromMethod;

                // This method decides move pawn outside of base
                startPositionFromMethod = moves.moveFromBase(result, homeRedPawns, baseOfRedPawns,
                        imageView9, imageView10, imageView11, imageView12,
                        roadOfRedPawns, gridPageGame4, actualPositionOfRed);
                actualPositionOfRed = startPositionFromMethod;

                //These three methods analyze the capture of a pawn by a pawn in motion
                actualPositionOfYellow = moves.pawnBeatYellowPawn(actualPositionOfRed, actualPositionOfYellow,
                        roadOfRedPawns, roadOfYellowPawns,
                        imageView1, imageView2, imageView3, imageView4,
                        homeYellowPawns, homeYellow, gridPageGame4);

                actualPositionOfGreen = moves.pawnBeatGreenPawn(actualPositionOfRed, actualPositionOfGreen,
                        roadOfRedPawns, roadOfGreenPawns,
                        imageView5, imageView6, imageView7, imageView8,
                        homeGreenPawns, homeGreen, gridPageGame4);

                actualPositionOfBlue = moves.pawnBeatBluePawn(actualPositionOfRed, actualPositionOfBlue,
                        roadOfRedPawns, roadOfBluePawns,
                        imageView13, imageView14, imageView15, imageView16,
                        homeBluePawns, homeBlue, gridPageGame4);

                //This method decided about able or disable buttons depending of turn and full of bases
                moves.buttonsAbleAndDisable(baseOfRedPawns, baseOfBluePawns, baseOfYellowPawns, baseOfGreenPawns,
                        buttonOfRed, buttonOfBlue, buttonOfYellow, buttonOfGreen, ranking);

                //This method check who Player's won
                moves.checkWinner(baseOfYellowPawns, baseOfGreenPawns, baseOfRedPawns, baseOfBluePawns, ranking,
                        buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue, firstPlace, secendPlace, thirdPlace, fourthPlace, gridPageGame4);
            }
        });
        buttonOfBlue.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //This method generatet and display dice result
                int result = dice.generatedAndDisplayResultForHumanPlayer(actualPositionOfBlue, level, labelOfBlue, gridPageGame4);

                // This method decides if the pawn can leave the base
                int startPositionFromMethod = (moves.pawnsMove(result, baseOfBluePawns, homeBluePawns,
                        imageView13, imageView14, imageView15, imageView16,
                        roadOfBluePawns, gridPageGame4, actualPositionOfBlue));
                actualPositionOfBlue = startPositionFromMethod;

                // This method decides move pawn outside of base
                startPositionFromMethod = moves.moveFromBase(result, homeBluePawns, baseOfBluePawns,
                        imageView13, imageView14, imageView15, imageView16,
                        roadOfBluePawns, gridPageGame4, actualPositionOfBlue);
                actualPositionOfBlue = startPositionFromMethod;

                //These three methods analyze the capture of a pawn by a pawn in motion
                actualPositionOfYellow = moves.pawnBeatYellowPawn(actualPositionOfBlue, actualPositionOfYellow,
                        roadOfBluePawns, roadOfYellowPawns,
                        imageView1, imageView2, imageView3, imageView4,
                        homeYellowPawns, homeYellow, gridPageGame4);

                actualPositionOfGreen = moves.pawnBeatGreenPawn(actualPositionOfBlue, actualPositionOfGreen,
                        roadOfBluePawns, roadOfGreenPawns,
                        imageView5, imageView6, imageView7, imageView8,
                        homeGreenPawns, homeGreen, gridPageGame4);

                actualPositionOfRed = moves.pawnBeatRedPawn(actualPositionOfBlue, actualPositionOfRed,
                        roadOfBluePawns, roadOfRedPawns,
                        imageView9, imageView10, imageView11, imageView12,
                        homeRedPawns, homeRed, gridPageGame4);

                //This method decided about able or disable buttons depending of turn and full of bases
                moves.buttonsAbleAndDisable(baseOfBluePawns, baseOfYellowPawns, baseOfGreenPawns, baseOfRedPawns,
                        buttonOfBlue, buttonOfYellow, buttonOfGreen, buttonOfRed, ranking);

                //This method check who Player's won
                moves.checkWinner(baseOfYellowPawns, baseOfGreenPawns, baseOfRedPawns, baseOfBluePawns, ranking,
                        buttonOfYellow, buttonOfGreen, buttonOfRed, buttonOfBlue, firstPlace, secendPlace, thirdPlace, fourthPlace, gridPageGame4);
            }
        });
        endGame.setOnAction(e -> {
            Scene pageIntroduce = getPageIntroduce();
        });
        Scene pageGame4 = new Scene(gridPageGame4, 960, height, Color.WHITESMOKE);
        return pageGame4;
    }

}
