/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.logging.Level;
import java.util.logging.Logger;
import main.visitors.CarVisitor;
import main.states.*;
import main.visitors.BonusVisitor;
import main.visitors.StateVisitor;

/**
 *
 * @author Eero
 */
public class Car implements Runnable {

    private CarState state;

    private String name;
    private int points;

    private boolean running;

    public Car(String name) {
        this.name = name;
        state = new CarBraking(null);
        Main.STATE_COUNT++;
        points = 0;
    }

    public void accept(CarVisitor v) {
        v.visit(state, this);
    }

    public void setState(CarState s) {
        state = s;
    }

    public void addPoints(int p) {
        points += p;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public void run() {
        running = true;

        while (running) {
            try {
                Thread.sleep((int) Math.floor(Math.random() * 1000) + 200);
                if (Math.random() <= 0.5) {
                    this.accept(new BonusVisitor());
                } else {
                    this.accept(new StateVisitor());
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println(name + ", " + state + ", points:" + points + ", sc: " + Main.STATE_COUNT);

        }
        System.out.println(name + " | points: " + points);
    }

    public void stop() {
        running = false;
    }
}
