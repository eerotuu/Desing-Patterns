/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import main.withapi.Clock;
import main.withapi.Timer;

/**
 *
 * @author Eero
 */
public class Main {

    public static void main(String[] args) throws IOException {

        /*
        DigitalClock digitalClock = new DigitalClock(new ClockTimer());
        AnalogClock analogClock = new AnalogClock(new ClockTimer());

        digitalClock.start();
        analogClock.start();
         */
        
        // with api
        
        Timer timer = new Timer();
        timer.addObserver(new Clock());
        new Thread(timer).start();
        System.in.read();
        timer.stop();
    }
}
