package com.company;

import java.awt.*;

public class Tank {

    private int x  ,  y;
    private  Directions direction;
    private static final int speed = 20;
    private boolean moving = false;
    TankFrame tankFrame;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Tank(int x, int y, Directions direction,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.direction = direction;
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

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    private void move() {
        if (!moving) return;
        switch (direction) {
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

    }

    public void paint(Graphics g) {
        Color c = Color.BLACK;
        g.setColor(Color.BLUE);
        g.fillRect(this.x, this.y, 50, 50);
        g.setColor(c);
        move();

    }

    public void fire() {
        tankFrame.bullets.add( new Bullet(this.x,this.y,this.direction,this.tankFrame));
    }
}
