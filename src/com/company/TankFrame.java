package com.company;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {

    Tank myTank = new Tank(200, 200, Directions.DOWN,this);
    List<Bullet> bullets = new ArrayList<>();

    static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量："+bullets.size(),10,60);
        g.setColor(c);

        myTank.paint(g);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

    }

    public TankFrame() {
        setTitle("Tank War");
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setBackground(Color.BLACK);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new MyKeyListener());
    }

    Image offScreenImage = null;
    @Override
    public void update(Graphics g){
        if(offScreenImage == null){
            offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);
    }

    class MyKeyListener extends KeyAdapter {

        boolean bD = false;
        boolean bU = false;
        boolean bR = false;
        boolean bL = false;

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case (KeyEvent.VK_DOWN):
                    bD = true;
                    break;
                case (KeyEvent.VK_UP):
                    bU = true;
                    break;
                case (KeyEvent.VK_RIGHT):
                    bR = true;
                    break;
                case (KeyEvent.VK_LEFT):
                    bL = true;
                    break;
                default:
                    break;
            }

            directionChange();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case (KeyEvent.VK_DOWN):
                    bD = false;
                    break;
                case (KeyEvent.VK_UP):
                    bU = false;
                    break;
                case (KeyEvent.VK_RIGHT):
                    bR = false;
                    break;
                case (KeyEvent.VK_LEFT):
                    bL = false;
                    break;
                case (KeyEvent.VK_CONTROL):
                    myTank.fire();
                default:
                    break;
            }

            directionChange();
        }

        public void directionChange() {
            if (!bD && !bL && !bR && !bU) myTank.setMoving(false);
            else {
                myTank.setMoving(true);
                if (bD) myTank.setDirection(Directions.DOWN);
                if (bU) myTank.setDirection(Directions.UP);
                if (bR) myTank.setDirection(Directions.RIGHT);
                if (bL) myTank.setDirection(Directions.LEFT);
            }
        }


    }


}
