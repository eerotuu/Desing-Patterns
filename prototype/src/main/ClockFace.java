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
public class ClockFace implements Cloneable, Runnable {

    private boolean isRunning;

    private Hand minuteHand;
    private Hand hourHand;

    public ClockFace() {
        minuteHand = new Hand(60);
        hourHand = new Hand(12);
    }

    @Override
    public ClockFace clone() {
        ClockFace c = null;
        try {
            c = (ClockFace) super.clone();
            c.minuteHand = (Hand) minuteHand.clone();
            c.hourHand = (Hand) hourHand.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(ClockFace.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    @Override
    public void run() {
        isRunning = true;
        printTime();
        while (isRunning) {
            try {
                Thread.sleep(1000);
                tick();
            } catch (InterruptedException ex) {
                Logger.getLogger(ClockFace.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
    }

    private void tick() {
        if (minuteHand.tick()) {
            minuteHand.reset();
            if (hourHand.tick()) {
                hourHand.reset();
            }
        }
        printTime();
    }
    
    private void printTime() {
        String time = String.format("%02d:%02d", hourHand.getVal(), minuteHand.getVal());
        System.out.println(time);
    }
    
    public void stop() {
        isRunning = false;
    }
}
