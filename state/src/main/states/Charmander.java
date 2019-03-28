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
public class Charmander extends PokemonState {

    private static Charmander sInstance;
    private final double weight = 8.5;
    private final double height = 0.6;

    private Charmander() {}

    public static synchronized Charmander getInstance() {
        if (sInstance == null) {
            sInstance = new Charmander();
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
        super.changeState(p, Charmeleon.getInstance());
        return true;
    }

    @Override
    public String toString() {
        return "Charmander";
    }
}
