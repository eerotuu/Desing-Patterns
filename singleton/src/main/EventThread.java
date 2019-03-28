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
public class EventThread implements Runnable {

    private boolean running = false;
    private String mName;

    public EventThread(String aName) {
        mName = aName;
    }

    @Override
    public void run() {
        running = true;
        while (running) {
            try {
                Thread.sleep((long) (Math.floor(Math.random() * 5000) + 1000));
                EventLogger.getInstance().log(mName + " did something.");
            } catch (InterruptedException ex) {
                Logger.getLogger(EventThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void stop() {
        running = false;
    }
}
