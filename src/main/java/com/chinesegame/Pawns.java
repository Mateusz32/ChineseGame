package com.chinesegame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Pawns {
    ImageView imageView;
    private Image redPawn = new Image("file:src/main/resources/redPawn.png");
    private Image yellowPawn = new Image("file:src/main/resources/yellowPawn.png");
    private int column;
    private int row;
    private boolean occupied;

    private int x;

    Pawns() {
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public int getX() {
        return x;
    }

    Pawns(ImageView imageView, int column, int row, boolean occupied) {
        this.imageView = imageView;
        this.column=column;
        this.row=row;
        this.occupied=occupied;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public Image getRedPawn() {
        return redPawn;
    }

    public Image getYellowPawn() {
        return yellowPawn;
    }

    public void movePawn(int x, ImageView image) {
        int i = 0;
        System.out.println("kkkk");
        GridPane gridPane = new GridPane();
        System.out.println(x);
        if (i < 3) {
            i++;
            System.out.println("i= "+i);
            if (x == 6) {
                gridPane.setConstraints(image, 0, 4);
                i = 3;
            }
        }
        // }
        System.out.println("Jestem poza");
        //  }
        //}


//    public void movePawn2(int x, ImageView image) {
//        int i = 0;
//        GridPane gridPane = new GridPane();
//        System.out.println(x);
        //while (i < 3) {
        //   gridPane.setConstraints(image, 0, 4);
//        System.out.println(x + "Dupa2");
        //       PositionOfBoard positionOfBoard = new PositionOfBoard();
//        System.out.println(x + "Dupa3");
//          positionOfBoard.getList().remove(1);
//        PositionOfBoard newPosition = new PositionOfBoard(0, 4, true);
//        System.out.println(x + "Dupa4");
//        positionOfBoard.list.add(1, newPosition);
//        System.out.println(x + "Dupa5");

        // } else {
        // System.out.println("Nie wyszła 6");
        //}

    }
}


