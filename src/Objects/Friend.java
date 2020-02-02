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
public class Friend extends Enemy{
    
    public Friend(int border, int w) {
        super(border, w);
        try {
            Image img = ImageIO.read(new File("data/images/friend.png"));
            setImg(img);
        } catch (IOException ex) {
            Logger.getLogger(Catcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getFallLive(boolean capture){
        return 0;
    }
    
    public int getFallPoint(boolean capture){
        return (capture ? 1 : 0);
    }
    
}
