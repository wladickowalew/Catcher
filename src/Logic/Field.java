/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import GUI.GameLabel;
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
    
    private final int SEC = 30;
    private final int MAX_LEVEL = 20;

    private ArrayList<Player> objects;
    private Image background, end;
    private int border, width;
    private Catcher cat;
    private Timer timer_draw, timer_update, timer_level;
    private int lives, points, level;
    private GameLabel liveslbl, levellbl, pointslbl;

    public Field(int h, int w) {
        border = h - 125;
        width = w;
        addBackground();
        startData();
        addLabels();
    }
    
    private void startData(){
        cat = new Catcher(border, width);
        objects = new ArrayList<>(); 
        lives = 3;
        points = 0;
        level = 1;
        addTimers();
    }
    
    private void addLabels() {
        setLayout(null);
	liveslbl = new GameLabel("Lives", lives);
	liveslbl.setLocation(10, 10);
	this.add(liveslbl);
        
        levellbl = new GameLabel("Level", level);
	levellbl.setLocation(220, 10);
	this.add(levellbl);
		
	pointslbl = new GameLabel("Points", points);
	pointslbl.setLocation(430, 10);
	this.add(pointslbl);
    }
    
    private void updateLabels(){
        liveslbl.change(lives);
        pointslbl.change(points);
        levellbl.change(level);
    }
    
    private void addTimers(){
        ActionListener drawListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 repaint();
            }
        };
        timer_draw = new Timer(50, drawListener);
        timer_draw.start();
        ActionListener updateListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 update();
            }
        };
        timer_update = new Timer(500, updateListener);
        timer_update.start();
        ActionListener levelListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (level < MAX_LEVEL)
                    level++;
                updateLabels();
            }
        };
        timer_level = new Timer(SEC * 1000, levelListener);
        timer_level.start();
    }
    
    private void update(){
        double maxP = 0.9, minP = 0.2;
        double d = (maxP - minP)/(MAX_LEVEL - 1);
        double p = minP + (level - 1) * d;
        if (Math.random() < p) 
            addObject();
        for (int i = 0; i < objects.size(); i++){
            if (objects.get(i).isFall()){ 
                objectFall(objects.get(i));
                objects.remove(i);
            }
        } 
    }
    
    private void objectFall(Player obj){
        boolean capture = cat.catchObject(obj.getX());
        lives += obj.getFallLive(capture);
        points += obj.getFallPoint(capture);
        if (lives < 0) lives = 0;
        if (points < 0) points = 0;
        printStat();
        updateLabels();
        endGame();
    }
    
    private void addObject(){
        double p = Math.random();
        double level = this.level/(double)MAX_LEVEL;
        Player obj = null;
        if (p < 0.2) 
            obj = new Friend(border, width, level);
        if (0.2 <= p && p < 0.5) 
            obj = new Enemy(border, width, level);
        if (0.5 <= p && p < 0.65) 
            obj = new Bomb(border, width, level);
        if (0.65 <= p && p < 0.72) 
            obj = new Casino(border, width, level);
        if (0.72 <= p && p < 0.82) 
            obj = new Cigarette(border, width, level);
        if (0.82 <= p && p < 0.87) 
            obj = new Death(border, width, level);
        if (0.87 <= p && p < 0.97) 
            obj = new Heart(border, width, level);
        if (0.97 <= p) 
            obj = new Snitch(border, width, level); 
        objects.add(obj);
    }
    
    private void addBackground(){
        try {
            background = ImageIO.read(new File("data/images/background.jpg"));
            background = background.getScaledInstance(width, border+125, Image.SCALE_DEFAULT);
        } catch (IOException ex) {
            Logger.getLogger(Catcher.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    private void addEnd(){
        try {
            end = ImageIO.read(new File("data/images/end.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Catcher.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    private void endGame(){
        if (lives > 0) return;
        timer_draw.stop();
        timer_update.stop();
        timer_level.stop();
        addEnd();
        repaint();
    }

    private void printStat(){
        System.out.println("Lives: " + lives + 
                           " Points: " + points +
                           " Level: " + level) ;
    }
    
    public void setCatX(int x) {cat.setX(x);}
    public int getCatX() {return cat.getX();}

    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        gr.drawImage(background, 0, 0, null);
        for (Player player : objects) {
            player.draw(gr);
        }
        cat.draw(gr);
        if (end != null){
            int x = (width - end.getWidth(null))/2;
            int y = (border + 125 - end.getHeight(null))/2;
            gr.drawImage(end, x, y, null);
        }
    }

}
