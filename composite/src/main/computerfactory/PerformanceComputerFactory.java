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
        super.add(new Case(300));
        super.add(new Motherboard(430));
        super.add(new CPU(1020));
        super.add(new GPU(1450));
        super.add(new RAM(215));
        super.add(new NIC(40)); 
    }
}
