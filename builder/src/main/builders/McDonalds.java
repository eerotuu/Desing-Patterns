/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.builders;

import main.ingredients.Bun;
import main.ingredients.Patty;
import main.ingredients.Sauce;

/**
 *
 * @author Eero
 */
public class McDonalds implements BurgerBuilder<StringBuilder> {
    
    private StringBuilder burger;
    
    @Override
    public void createNewBurger() {
        burger = new StringBuilder();
    }

    @Override
    public void buildPatty() {
        burger.append("150g beef patty\n");
    }

    @Override
    public void buildBun() {
        burger.append("seasame seed bun\n");
    }

    @Override
    public void buildSauce() {
        burger.append("chili mayonnaise sauce\n");
    }

    @Override
    public StringBuilder getBurger() {
        return burger;
    }

}
