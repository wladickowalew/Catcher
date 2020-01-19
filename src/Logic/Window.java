/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author Ковалев Владислав
 */
public class Window extends JFrame {

    private Field gameField;
    private int w;

    private class MyKey implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            int x = gameField.getCatX();
            switch (key) {
                case 37:
                    if (x > -50) {
                        gameField.setCatX(x - 25);
                    } else {
                        gameField.setCatX(w - 50);
                    }
                    break;
                case 39:
                    if (x < w - 50) {
                        gameField.setCatX(x + 25);
                    } else {
                        gameField.setCatX(-50);
                    }
                    break;
                case 27:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    public Window(int w, int h) {
        addKeyListener(new MyKey());
        this.w = w;
        setFocusable(true);
        setResizable(false);
        setBounds(0, 0, w, h);
        setTitle("My Game");

        gameField = new Field(h, w);
        Container c = getContentPane();
        c.add(gameField);
        setVisible(true);
    }

}
