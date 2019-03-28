/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import main.states.PokemonState;

/**
 *
 * @author Eero
 */
public class Pokemon {
    
    private PokemonState state;
    
    public Pokemon(PokemonState s) {
        state = s;
    }
    
    public void changeState(PokemonState s) {
        state = s;
    }
    
    public boolean evolve() {
        return state.evolve(this);
    }
    
    public double getWeight() {
        return state.getWeight();
    }
    
    public double getHeight() {
        return state.getHeight();
    }
    
    public String getName() {
        return state.getName();
    }
}
