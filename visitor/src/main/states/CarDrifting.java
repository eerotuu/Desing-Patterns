package main.states;

import main.Car;
import main.Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Eero
 */
public class CarDrifting extends AbstractCarState {

    private final int bonus = 10;
    private double bonusModifier = 1.0; // the car gets more points if it stays longer in this state.

    public CarDrifting(AbstractCarState prev) {
        super(prev);
    }

    @Override
    public void next(Car c) {
        if (next == null) {
            if (!isLastState()) {
                next = new CarSpeeding(this);
                Main.STATE_COUNT++;
            }
        }
        c.setState(next);
        bonusModifier = 1.0;
    }

    @Override
    public void addBonus(Car c) {
        c.addPoints((int) (bonus * bonusModifier));
        bonusModifier *= 1.2;
    }

    @Override
    public String toString() {
        return "Drifting";
    }
}
