/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.withapi;

import java.util.Observable;

/**
 *
 * @author Eero
 */
public class Timer extends Observable implements Runnable {

    private boolean isRunning;

    private int hours;
    private int minutes;
    private int seconds;

    public Timer() {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }

    @Override
    public void run() {
        isRunning = true;
        while (isRunning) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            tick();
        }
    }

    private void tick() {
        seconds++;
        if (seconds > 59) {
            seconds = 0;
            minutes++;
            if (minutes > 59) {
                minutes = 0;
                hours++;
            }
        }
        setChanged();
        notifyObservers(new int[]{hours, minutes, seconds});
    }

    public void stop() {
        isRunning = false;
    }
}
