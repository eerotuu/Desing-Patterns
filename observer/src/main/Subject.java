/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Eero
 */
public class Subject {

    private Set<Observer> observers = new HashSet();

    public void attach(Observer o) {
        observers.add(o);
    }

    public void detach(Observer o) {
        observers.remove(o);
    }

    protected void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }
}
