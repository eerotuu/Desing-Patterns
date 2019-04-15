/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import main.builders.BurgerBuilder;

/**
 *
 * @author Eero
 */
public class BurgerDirector {
    
    private BurgerBuilder builder;
    
    public BurgerDirector(BurgerBuilder b) {
        builder = b;
    }
    
    public void constructBurger() {
        builder.createNewBurger();
        builder.buildBun();
        builder.buildPatty();
        builder.buildSauce();
    }
    
    public Object getBurger() {
        return builder.getBurger();
    }   

    public void setBuilder(BurgerBuilder builder) {
        this.builder = builder;
    }
}
