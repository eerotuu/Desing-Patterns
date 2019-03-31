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
        super.add(Case.class, 20);
        super.add(Motherboard.class, 60);
        super.add(CPU.class, 40);
        super.add(GPU.class, 50);
        super.add(RAM.class, 20);
        super.add(NIC.class, 20); 
    }
}
