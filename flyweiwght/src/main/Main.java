/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Eero
 */
public class Main extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Example 1. Flyweigt strings
        String x = "x", y = "y";
        String x2 = "x", y2 = "y";
        
        // == operator evaluates true if the objects it comapares are the same.
        System.out.println(x == x2);
        System.out.println(y == y2);
        
        // Strings computed at runtime, are not flyweights by default.
        String xy = x + y;
        System.out.println(xy == "xy");
        
        // you can force the issue with String.intern() which returns flyweights
        // for strings computed at runtime.
        xy = (x + y).intern();     
        System.out.println(xy == "xy");
        
        //Example 2. Border flyweights
        Main m = new Main();
        m.setBounds(20,20,250,150);
        m.setVisible(true);
    }
    
    public Main() {
      super("Border flyweights");
      JPanel panel   = new JPanel(), panel2 = new JPanel();

      // createRaisedBevelBorder() doesn't create new border, instead the method 
      // returns a shared static object.
      Border border  = BorderFactory.createRaisedBevelBorder();
      Border border2 = BorderFactory.createRaisedBevelBorder();
      
      panel.setBorder(border);
      panel.setPreferredSize(new Dimension(100,100));
      
      panel2.setBorder(border2);
      panel2.setPreferredSize(new Dimension(100,100));
      
      Container contentPane = getContentPane();
      contentPane.setLayout(new FlowLayout());
      contentPane.add(panel);
      contentPane.add(panel2);
      
      setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosed(WindowEvent e) {
            System.exit(0);
         }
      });
      
      // since border is shared by multiple components, the border does not 
      // maintain extrinsic state.
      
      if(border == border2)
         System.out.println("bevel borders are shared");
      else
         System.out.println("bevel borders are NOT shared");
      
   }
}
