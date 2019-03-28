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
public class ClockTimer extends Subject implements Runnable {

    private int hours;
    private int minutes;
    private int seconds;

    private boolean running = false;

    public ClockTimer() {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }

    /**
     * @return the hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * @return the minutes
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * @return the seconds
     */
    public int getSeconds() {
        return seconds;
    }

    void tick() {
        seconds++;
        if (seconds > 59) {
            seconds = 0;
            minutes++;
            if (minutes > 59) {
                minutes = 0;
                hours++;
            }
        }
        notifyObservers();
    }

    @Override
    public void run() {
        running = true;
        while (running) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ClockTimer.class.getName()).log(Level.SEVERE, null, ex);
            }
            tick();
        }
    }

    public void stop() {
        running = false;
    }
}
