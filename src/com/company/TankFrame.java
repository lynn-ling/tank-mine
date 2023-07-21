package com.company;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    int x = 200;
    int y = 200;
    int speed = 20;

    public TankFrame(){
        setTitle("Tank War");
        setSize(800,800);
        setResizable(false);
        setBackground(Color.BLACK);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });




        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case (KeyEvent.VK_DOWN):
                        y += speed;
                        break;
                    case (KeyEvent.VK_UP):
                        y -= speed;
                        break;
                    case (KeyEvent.VK_RIGHT):
                        x += speed;
                        break;
                    case (KeyEvent.VK_LEFT):
                        x -= speed;
                        break;
                    default:
                        break;

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    @Override
    public void paint(Graphics g){
        Color c = Color.BLACK;
        g.setColor(Color.BLUE);
        g.fillRect(x,y,50,50);
        g.setColor(c);

    }





}
