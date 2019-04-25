/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eero
 */
public class Hand implements Cloneable {
    
    private int maxVal;
    private int currVal;
    
    public Hand(int t) {
        maxVal = t;
        currVal = 0;
    }
    
    @Override
    public Object clone() {
        Object c = null;
        try {
            c = super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Hand.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return c;
    }

    public boolean tick() {
        return ++currVal >= maxVal;
    }

    public void reset() {
        currVal = 0;
    }

    public int getVal() {
        return currVal;
    }
}
