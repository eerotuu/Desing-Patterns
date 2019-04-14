/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.states;

import main.Car;
import main.Main;

/**
 *
 * @author Eero
 */
public class CarSpeeding extends AbstractCarState {

    private final int bonus = 6;

    public CarSpeeding(AbstractCarState prev) {
        super(prev);
    }

    @Override
    public void next(Car c) {
        if (next == null) {
            if (!isLastState()) {
                next = new CarDrifting(this);
                Main.STATE_COUNT++;
            }
        }
        c.setState(next);
    }

    @Override
    public void addBonus(Car c) {
        c.addPoints(bonus);
    }

    @Override
    public String toString() {
        return "Speeding";
    }

}
