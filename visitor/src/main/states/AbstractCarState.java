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
public abstract class AbstractCarState implements CarState {
   
    // no need to make new state for car object on every state change.
    // could have done states as singleton pattern that every car uses, 
    // but wanted to test this way and add state variable that is car object specific.
    protected AbstractCarState next;
    protected AbstractCarState prev;
    
    private final int maxStates = 3;
    
    public AbstractCarState(AbstractCarState prev) {
        this.prev = prev;
    }

    @Override
    public abstract void next(Car c);
    
    @Override
    public abstract void addBonus(Car c);

    @Override
    public void prev(Car c) {
        c.setState(prev);
    }
    
    /**
     * called in concrete state next() method if next == null
     * sets link to first created state if state amount reaches maxStates
     * 
     * @return 
     */
    protected boolean isLastState() {  
        AbstractCarState current = this;
        int c = 1;
        while(current.prev != null) {
            current = current.prev;
            c++;
        }  
        if(c == maxStates) {
            next = current;
            next.prev = this;
            return true;
        }     
        return false;      
    }
}
