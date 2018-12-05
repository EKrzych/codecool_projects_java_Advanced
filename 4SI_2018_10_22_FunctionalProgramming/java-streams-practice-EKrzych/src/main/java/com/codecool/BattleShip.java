package com.codecool;

public class BattleShip {
    private int startX;
    private int startY;
    private int length;

    public BattleShip(int startX, int startY, int length) {
        this.startX = startX;
        this.startY = startY;
        this.length = length;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "BattleShip{" +
                "startX=" + startX +
                ", startY=" + startY +
                ", length=" + length +
                '}';
    }
}
