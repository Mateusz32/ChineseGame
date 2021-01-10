package com.chinesegame;

public class Point {

    private final int column;
    private final int row;

    Point(int column, int row) {
        this.column = column;
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
