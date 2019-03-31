/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.computerfactory;

import main.components.Component;

/**
 *
 * @author Eero
 */
public class Computer {
    
    private Component pc;
    
    public void create(ComputerFactory factory) {
        pc = factory.build();
    }
    
    /**
     * 
     * @return Total price or 0 if computer root component is null (not built)
     */
    public int getPrice() {
        if(pc != null) {
            return pc.getPrice();
        }  
        return 0;   
    }
    
    public void printComponents(){
        if(pc != null) {
            System.out.println(pc.print());
            
        }
        
    }
}
