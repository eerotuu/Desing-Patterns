/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;

/**
 *
 * @author Eero
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        ClockFace c = new ClockFace();
        new Thread(c).start();
        
        System.in.read();
        System.out.println("Stopping original, starting clone");
        
        c.stop(); 
        // clone has all attribute values that original has at given time it is cloned
        ClockFace c2 = c.clone(); 
        new Thread(c2).start();
        
        System.in.read();
        System.out.println("Stopping clone, starting original");
        
        // original still has his values when it was stopped since clone is just a clone of a object
        // on given time
        c2.stop();
        new Thread(c).start();
        
        System.in.read();
        System.out.println("Cloning clone into original");
        // if we want to get clone values to original
        c.stop();
        c = c2.clone();
        new Thread(c).start();
        
        System.in.read();   
    }
    
}
