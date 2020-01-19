/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Objects.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Ковалев Владислав
 */
public class Field extends JPanel {

    private ArrayList<Player> objects;
    private Image background, end;
    private int border, width;
    private Catcher cat;
    private Timer timer_draw;

    public Field(int h, int w) {
        this.border = h - 125;
        this.width = w;
        objects = new ArrayList<>();
        cat = new Catcher(border, w);
        objects.add(cat);
        ActionListener drawListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 repaint();
            }
        };
        timer_draw = new Timer(50, drawListener);
        timer_draw.start();
        addBackground();
    }
    
    public void addBackground(){
        try {
            background = ImageIO.read(new File("data/images/background.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Catcher.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    public void setCatX(int x) {cat.setX(x);}
    public int getCatX() {return cat.getX();}

    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        gr.drawImage(background, 0, 0, null);
        for (Player player : objects) {
            player.draw(gr);
        }
    }

}
