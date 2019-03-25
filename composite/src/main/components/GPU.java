/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.components;

/**
 *
 * @author Eero
 */
public class GPU extends AbstractComponent {
    
    public GPU(int aPrice) {
        super(aPrice);
    }
    
    @Override
    public String toString() {     
        return "GPU - " + super.mPrice + "€";
    }
}
