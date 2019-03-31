/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.computerfactory;

import java.util.HashMap;
import main.components.CPU;
import main.components.Case;
import main.components.Component;
import main.components.GPU;
import main.components.Motherboard;
import main.components.NIC;
import main.components.RAM;

/**
 *
 * @author Eero
 */
public class PerformanceComputerFactory extends AbstractComputerFactory {
    
    public PerformanceComputerFactory() {
        super();
        super.add(Case.class, 300);
        super.add(Motherboard.class, 430);
        super.add(CPU.class, 1020);
        super.add(GPU.class, 1450);
        super.add(RAM.class, 215);
        super.add(NIC.class, 40); 
    }
}
