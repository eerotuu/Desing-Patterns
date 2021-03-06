/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import main.components.CPU;
import main.components.Case;
import main.components.GPU;
import main.components.Motherboard;
import main.components.RAM;
import main.computerfactory.*;

/**
 *
 * @author Eero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Computer c = new Computer();
        
        // Cheap
        c.create(new CheapComputerFactory());  
        System.out.println("Cheap setup, Total: " + c.getPrice() + "€");
        c.printComponents();
        
        // Performance
        c.create(new PerformanceComputerFactory());
        System.out.println("\nPerformance setup, Total: " + c.getPrice() + "€");
        c.printComponents();
        
        // Custom
        ComputerFactory factory = new CustomComputerFactory();
        factory.add(CPU.class, 140);
        factory.add(Motherboard.class, 80);
        factory.add(Case.class, 60);   
        factory.add(GPU.class, 210);
        factory.add(RAM.class, 60);
        c.create(factory);
        System.out.println("\nCustom setup, Total: " + c.getPrice() + "€");
        c.printComponents();
        
        // Remove Motherboard from custom factory -> building only creates new Case
        factory.remove(Motherboard.class);
        c.create(factory);
        System.out.println("\nCustom setup, Total: " + c.getPrice() + "€");
        c.printComponents();
        
    }
    
}
