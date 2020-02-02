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
public class Cigarette extends Enemy{
    
    public Cigarette(int border, int w) {
        super(border, w, "siga.jpg");
    }
    
    public int getFallLive(boolean capture){
        return (capture ? -3 : 0);
    }
    
    public int getFallPoint(boolean capture){
        return (capture ? -15 : 1);
    }
    
}
