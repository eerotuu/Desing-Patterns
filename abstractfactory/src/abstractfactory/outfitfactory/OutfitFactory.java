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
public interface OutfitFactory {
    
    public abstract Clothing create(Class c);
    public abstract Clothing createHat();
    public abstract Clothing createShirt();
    public abstract Clothing createPants();
    public abstract Clothing createShoes();
}
