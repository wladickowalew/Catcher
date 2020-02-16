/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.JRadioButton;

/**
 *
 * @author Ковалев Владислав
 */
public class Main {

    private static final String[] RESOLUTIONS = {"800×600", "1024×768", 
        "1200×600", "1280×1024", "1680×1050", "1920×1080"};
    private static final String DEFAULT = "800×600";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ans = showAnswer();
        int pos = ans.indexOf("×");
        int w = Integer.parseInt(ans.substring(0, pos));
        int h = Integer.parseInt(ans.substring(pos+1));
        Window window = new Window(w, h);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static String showAnswer(){
        final JPanel panel = new JPanel();
        final ButtonGroup group = new ButtonGroup();
        final Box box = Box.createVerticalBox();
        for (String res: RESOLUTIONS){
            addButton(res, group, box);
        }
        panel.add(box);
        JOptionPane.showMessageDialog(null, panel);
        return group.getSelection().getActionCommand();
    }
    
    private static void addButton(String res, ButtonGroup group, Box box){
        JRadioButton button = new JRadioButton(res);
        if (res == DEFAULT)
            button.setSelected(true);
        button.setActionCommand(res);
        group.add(button);
        box.add(button);
    }

}
