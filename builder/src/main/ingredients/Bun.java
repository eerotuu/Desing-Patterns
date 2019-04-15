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
public class Bun implements Ingredients {
    
    private String type;
    
    public Bun(String type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        return type + " bun";
    }
}
