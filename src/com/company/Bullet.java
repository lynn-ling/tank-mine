package com.company;

import java.awt.*;

public class Bullet {

    private int x, y;
    private Directions directions;
    private final static int speed = 5;
    TankFrame tankFrame;
    boolean live = true;

    public Bullet(int x, int y, Directions directions, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.directions = directions;
        this.tankFrame = tankFrame;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Directions getDirections() {
        return directions;
    }

    public void setDirections(Directions directions) {
        this.directions = directions;
    }

    private void move() {
        switch (directions) {
            case DOWN:
                y += speed;
                break;
            case UP:
                y -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            default:
                break;
        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            live = false;
        }

    }

    public void paint(Graphics g) {
        Color c = Color.BLACK;
        g.setColor(Color.RED);
        g.fillOval(this.x, this.y, 20, 20);
        g.setColor(c);
        move();
        if (!live) {
            tankFrame.bullets.remove(this);
        }


    }
}
