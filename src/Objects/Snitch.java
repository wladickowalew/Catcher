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
public class Snitch extends Enemy{
    
    public Snitch(int border, int w, double level) {
        super(border, w, "snitch.png", level);
    }
    
    public int getFallLive(boolean capture){
        return (capture ? 1 : 0);
    }
    
    public int getFallPoint(boolean capture){
        return (capture ? 10 : -3);
    }
    
}
