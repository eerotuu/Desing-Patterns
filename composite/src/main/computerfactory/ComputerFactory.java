/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.computerfactory;

import java.util.Map;
import main.components.Component;

/**
 *
 * @author Eero
 */
public interface ComputerFactory {
    public Component build();
    public void add(Class c, int p);
    public void remove(Class c);
}
