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
public class Charizard extends PokemonState {

    private static Charizard sInstance;
    private final double weight = 90.5;
    private final double height = 1.7;

    private Charizard() {}

    public static synchronized Charizard getInstance() {
        if (sInstance == null) {
            sInstance = new Charizard();
        }
        return sInstance;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public boolean evolve(Pokemon p) {
        return false;
    }

    @Override
    public String toString() {
        return "Charizard";
    }
}
