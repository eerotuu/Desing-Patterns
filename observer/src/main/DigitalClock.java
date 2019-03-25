/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Eero
 */
public class DigitalClock implements Observer {
    
    private ClockTimer timer;
    
    public DigitalClock(ClockTimer c) {
        timer = c;
        timer.attach(this);
    }
    
    @Override
    public void update(Subject s) {
        if(s == timer) {
            draw();
        }
    }
    
    private void draw() {
        int hours = timer.getHours();
        int minutes = timer.getMinutes();
        int seconds = timer.getSeconds();
        
        System.out.format("%02d:%02d:%02d\n", hours,minutes,seconds);
    }
    
    public void start() {
        new Thread(timer).start();
    }
    
    public void stop() {
        timer.stop();
    }
    
}
