/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.withapi;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Eero
 */
public class Clock implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        int[] args = (int[]) arg;
        System.out.format("%02d:%02d:%02d\n", args[0], args[1], args[2]);
    }
}
