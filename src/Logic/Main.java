/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import javax.swing.JFrame;

/**
 *
 * @author Ковалев Владислав
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int w= 800, h= 600;
        Window window = new Window(w, h);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
