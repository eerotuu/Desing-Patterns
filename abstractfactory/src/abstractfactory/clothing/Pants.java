/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory.clothing;

/**
 *
 * @author Eero
 */
public class Pants extends Clothing{
    
    public Pants(String brand) {
        super(brand);
    }
    
    @Override
    public String toString() {
        return "Pants : " + brand;
    }
    
}
