/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory.outfitfactory;

import abstractfactory.clothing.*;

/**
 *
 * @author Eero
 */
public class Outfit {
    
    private Clothing hat;
    private Clothing pants;
    private Clothing shirt;
    private Clothing shoes;
    
    public void createOutfit(OutfitFactory factory) {
       hat = factory.create(Hat.class);
       pants = factory.create(Pants.class);
       shirt = factory.create(Shirt.class);
       shoes = factory.create(Shoes.class);
    }
    
    @Override
    public String toString() {
        return "Outfit\n===============\n" + hat + "\n" + shirt  + "\n" + pants 
                + "\n" + shoes;
    }
}
