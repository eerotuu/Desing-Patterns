/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.List;
import main.builders.Hesburger;
import main.builders.McDonalds;
import main.ingredients.Ingredients;

/**
 *
 * @author Eero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BurgerDirector pattyFlipper = new BurgerDirector(new McDonalds());
        pattyFlipper.constructBurger();
        System.out.println(pattyFlipper.getBurger());
        
        pattyFlipper.setBuilder(new Hesburger());
        pattyFlipper.constructBurger();
        ((List<Ingredients>) pattyFlipper.getBurger()).forEach(System.out::println);
    }
}
