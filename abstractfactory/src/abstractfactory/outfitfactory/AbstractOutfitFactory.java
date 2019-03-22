/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory.outfitfactory;

import abstractfactory.clothing.Clothing;
import abstractfactory.clothing.Hat;
import abstractfactory.clothing.Pants;
import abstractfactory.clothing.Shirt;
import abstractfactory.clothing.Shoes;
import java.lang.reflect.Constructor;

/**
 *
 * @author Eero
 */
public abstract class AbstractOutfitFactory implements OutfitFactory{
    
    private String mBrand;
    
    public AbstractOutfitFactory(String aBrand){
        mBrand = aBrand;
    }
    
    @Override
    public Clothing create(Class c) {
        try {
            Constructor ctor = c.getConstructor(String.class);         
            return (Clothing) ctor.newInstance(mBrand);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Hat createHat() {
        return new Hat(mBrand);
    }

    @Override
    public Shirt createShirt() {
        return new Shirt(mBrand);
    }

    @Override
    public Pants createPants() {
        return new Pants(mBrand);
    }

    @Override
    public Shoes createShoes() {
        return new Shoes(mBrand);
    }
    
}
