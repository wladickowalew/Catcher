/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author Ковалев Владислав
 */
public class Casino extends Enemy{
    
    public Casino(int border, int w, double level) {
        super(border, w, "casino.png", level);
    }
    
    public int getFallLive(boolean capture){
        return 0;
    }
    
    public int getFallPoint(boolean capture){
        return (capture ? -1000000 : 0);
    }
    
}
