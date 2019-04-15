/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.builders;

import java.util.ArrayList;
import java.util.List;
import main.ingredients.*;

/**
 *
 * @author Eero
 */
public class Hesburger implements BurgerBuilder<List<Ingredients>> {
    
    private List<Ingredients> burger; 
   
    @Override
    public void createNewBurger() {
        burger = new ArrayList<>(); 
    }

    @Override
    public void buildPatty() {
        burger.add(new Patty(150, "beef"));
    }

    @Override
    public void buildBun() {
        burger.add(new Bun("seasame seed"));
    }

    @Override
    public void buildSauce() {
        burger.add(new Sauce("hesburger mayonnaise"));
    }    

    @Override
    public List<Ingredients> getBurger() {
        return burger;
    } 
}
