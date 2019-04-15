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
public class Sauce implements Ingredients {
    private String type;
    
    public Sauce(String type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        return type + " sauce";
    }
}
