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
public class Charmeleon extends PokemonState {

    private static Charmeleon sInstance;
    private final double weight = 19.0;
    private final double height = 1.1;

    private Charmeleon() {}

    public static synchronized Charmeleon getInstance() {
        if (sInstance == null) {
            sInstance = new Charmeleon();
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
        super.changeState(p, Charizard.getInstance());
        return true;
    }

    @Override
    public String toString() {
        return "Charmeleon";
    }
}
