/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.states;

import main.Pokemon;

/**
 *
 * @author Eero
 */
public abstract class PokemonState {
    
    public abstract double getWeight();
    public abstract double getHeight();
    public abstract boolean evolve(Pokemon p);
    
    void changeState(Pokemon p, PokemonState s) {
        p.changeState(s);
    }
    
    public String getName(){
        return this.toString();
    }
}
