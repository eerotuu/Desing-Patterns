/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.states;

import main.Car;

/**
 *
 * @author Eero
 */
public interface CarState {

    public void next(Car c);

    public void prev(Car c);
    
    public void addBonus(Car c);
}
