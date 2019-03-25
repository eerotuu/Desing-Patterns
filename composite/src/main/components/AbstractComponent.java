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
public abstract class AbstractComponent implements Component {
    
    protected int mPrice;  
    
    public AbstractComponent(){}
    
    public AbstractComponent(int aPrice) {
       mPrice = aPrice; 
    }    
    
    @Override
    public int getPrice() {
        return mPrice;
    }

    @Override
    public void setPrice(int aPrice) {
        mPrice = aPrice;
    }
    
    @Override
    public String print(){
        return "  " + this;
    }
    
}
