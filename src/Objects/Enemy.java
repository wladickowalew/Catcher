/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Timer;

/**
 *
 * @author Ковалев Владислав
 */
public class Enemy extends Player {
    
    private Timer timer;

    public Enemy(int border, int w) {
        super(null, border, w);
        Image img = null;
        try {
            img = ImageIO.read(new File("data/images/enemy.png"));
            setImg(img);
        } catch (IOException ex) {
            Logger.getLogger(Catcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        setY(-100);
        setX((int) (Math.random() * (w - 100)));
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setY(getY() + 5);
            }
        };
        timer = new Timer(100, al);
        timer.start();
    }
    
    public int getFallLive(boolean capture){
        return (capture ? 0 : -1);
    }
    
    public int getFallPoint(boolean capture){
        return (capture ? 2 : 0);
    }

}
