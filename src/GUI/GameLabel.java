/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Ковалев Владислав
 */
public class GameLabel extends JLabel {
    
    private String text;
    
    public GameLabel(String text, int number){
        super(text + ": " + number);
	this.text = text;
        setForeground(Color.WHITE);
	Font f = new Font("Comic Sans MS", 0, 24);
	setFont(f);
	setSize(200, 30);
    }
    
    public void change(int number) {
	setText(text + ": " + number);
    }
    
}
