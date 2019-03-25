/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.components;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Eero
 */
public abstract class AbstractComposite implements Composite<Component> {

    protected int mPrice;
    private Map<Class, Component> components;

    public AbstractComposite() {
        components = new HashMap();
    }

    public AbstractComposite(int aPrice) {
        components = new HashMap();
        mPrice = aPrice;
    }

    @Override
    public boolean addComponent(Component c) {
        if (c == null || components.containsKey(c.getClass())) {
            return false;
        }
        components.put(c.getClass(), c);
        return true;
    }

    @Override
    public boolean removeComponent(Component c) {
        return components.remove(c) != null;
    }

    @Override
    public int getComponentCount() {
        return components.size();
    }

    @Override
    public Map<Class, Component> getComponents() {
        return components;
    }
     
    /**
     * Calculate total price recursively from attached components.
     * @return Total price
     */
    @Override
    public int getPrice() {
        if (components.isEmpty()) return mPrice;

        int total = mPrice;
        for (Map.Entry<Class, Component> entry : components.entrySet()) {
            total += entry.getValue().getPrice();
        }
        return total;
    }

    @Override
    public void setPrice(int aPrice) {
        mPrice = aPrice;
    }
    
    /**
     * Create String recursively from attached Components.
     * @return String containing all components and their price.
     */
    @Override
    public String print() {
        String s = this.toString();
        if (components.isEmpty()) return s;
   
        for (Map.Entry<Class, Component> entry : components.entrySet()) {
            s += "\n " + entry.getValue().print();
        }
        return s;
    }
}
