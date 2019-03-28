/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import main.states.Charmander;

/**
 *
 * @author Eero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Pokemon p = new Pokemon(Charmander.getInstance());
        Main.print(p);
        for (int i = 0; i < 3; i++) {
            p.evolve();
            Main.print(p);
        }
    }

    public static void print(Pokemon p) {
        System.out.println("Name: " + p.getName());
        System.out.println("Weight: " + p.getWeight());
        System.out.println("Height: " + p.getHeight() + "\n");
    }
}
