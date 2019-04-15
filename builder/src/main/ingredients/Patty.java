/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.ingredients;

/**
 *
 * @author Eero
 */
public class Patty implements Ingredients {
    
    private int mass;
    private String type;
    
    public Patty(int mass, String type) {
        this.mass = mass;
        this.type = type;
    }
    
    @Override
    public String toString() {
        return mass + " " + type + " patty";
    }
}
