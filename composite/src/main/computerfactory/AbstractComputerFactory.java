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
public abstract class AbstractComputerFactory implements ComputerFactory {

    private Map<Class, Component> mComponentMap;

    public AbstractComputerFactory() {
        mComponentMap = new HashMap();
    }
    
    @Override
    public void add(Component c) {
        if (mComponentMap != null) {
            mComponentMap.put(c.getClass(), c);
        }
    }
    
    @Override
    public void remove(Class c) {
        Composite root = (Composite) mComponentMap.get(Case.class);
        root.removeComponent(mComponentMap.get(c));
        mComponentMap.remove(c);
    }

    @Override
    public Component build() {
        return mComponentMap != null ? createCase() : null;
    }

    private Component createCase() {
        Composite c = (Composite) mComponentMap.get(Case.class);
        if (c != null) {
            c.addComponent(createMotherboard());
        }
        return c;
    }

    private Component createMotherboard() {
        Composite m = (Composite) mComponentMap.get(Motherboard.class);
        if (m != null) {
            m.addComponent(createCPU());
            m.addComponent(createGPU());
            m.addComponent(createRAM());
            m.addComponent(createNIC());
        }
        return m;
    }

    private CPU createCPU() {
        return (CPU) mComponentMap.get(CPU.class);
    }

    private GPU createGPU() {
        return (GPU) mComponentMap.get(GPU.class);
    }

    private RAM createRAM() {
        return (RAM) mComponentMap.get(RAM.class);
    }

    private NIC createNIC() {
        return (NIC) mComponentMap.get(NIC.class);
    }
    

}
