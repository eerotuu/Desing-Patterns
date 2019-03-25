/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.computerfactory;

import java.util.HashMap;
import java.util.Map;
import main.components.*;

/**
 *
 * @author Eero
 */
public class CheapComputerFactory extends AbstractComputerFactory {
    
    public CheapComputerFactory() {
        super();
        super.add(new Case(20));
        super.add(new Motherboard(60));
        super.add(new CPU(40));
        super.add(new GPU(50));
        super.add(new RAM(20));
        super.add(new NIC(20));  
    }
}
