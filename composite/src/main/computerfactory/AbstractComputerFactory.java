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

    private Map<Class, Integer> mComponentMap;

    public AbstractComputerFactory() {
        mComponentMap = new HashMap();
    }

    @Override
    public void add(Class c, int price) {
        if (mComponentMap != null) {
            mComponentMap.put(c, price);
        }
    }

    @Override
    public void remove(Class c) {
        mComponentMap.remove(c);
    }

    @Override
    public Component build() {
        return mComponentMap != null ? createCase() : null;
    }

    private Component createCase() {
        Case c = null;
        if (mComponentMap.containsKey(Case.class)) {
            c = new Case(mComponentMap.get(Case.class));
            c.addComponent(createMotherboard());
        }
        return c;
    }

    private Component createMotherboard() {
        Motherboard m = null;
        if (mComponentMap.containsKey(Motherboard.class)) {
            m = new Motherboard(mComponentMap.get(Motherboard.class));
            m.addComponent(createCPU());
            m.addComponent(createGPU());
            m.addComponent(createRAM());
            m.addComponent(createNIC());
        }
        return m;
    }

    private CPU createCPU() {
        return mComponentMap.containsKey(Motherboard.class) 
                ? new CPU(mComponentMap.get(CPU.class))
                : null;
    }

    private GPU createGPU() {
        return mComponentMap.containsKey(Motherboard.class)
                ? new GPU(mComponentMap.get(GPU.class))
                : null;
    }

    private RAM createRAM() {
        return mComponentMap.containsKey(RAM.class)
                ? new RAM(mComponentMap.get(RAM.class))
                : null;
    }

    private NIC createNIC() {
        return mComponentMap.containsKey(NIC.class) 
                ? new NIC(mComponentMap.get(NIC.class))
                : null;
    }

}
