/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author ir191258
 */
public class MakingWindow {
    
    public static void main (String[] args){
        
        JFrame window = new JFrame("Window");
        window.setSize(400,400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new GridLayout(3,1));
        
        JLabel title = new JLabel("Henlo");
        title.setFont(new Font("Comic Sans MS",11,JLabel.TOP));
        
        window.getContentPane().add(title);
        
        
        
        
        
        window.setVisible(true);
    }
    
    
}
