/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Ковалев Владислав
 */
public class Catcher extends Player{
    
    public Catcher(int border, int w) {
        super(null, border, w);
        System.out.println(border);
        Image img = null;
        try {
            img = ImageIO.read(new File("data/images/catcher.png"));
            setImg(img);
        } catch (IOException ex) {
            Logger.getLogger(Catcher.class.getName()).log(Level.SEVERE, null, ex);
        }   
        setY(border);
        setX((w - img.getWidth(null))/2);
    }
    
}
