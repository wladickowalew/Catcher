/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Ковалев Владислав
 */
public abstract class Player {
    private Image img;
    private int x, y;
    private int border;
    private int width;
    
    public Player(Image img, int border, int w) {
	this.img = img;
        this.border = border;
        this.width = w;
    }
    
    public void draw(Graphics gr) {
	gr.drawImage(img, x, y, null);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
    
    public boolean isFall() {
	return y + img.getHeight(null) >= border;
    }
    
    public int getFallLive(boolean capture){return 0;}
    public int getFallPoint(boolean capture){return 0;}
}
