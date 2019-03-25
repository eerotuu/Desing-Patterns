/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.components;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Eero
 * @param <C>
 */
public interface Composite<C> extends Component {
    public boolean addComponent(C c);
    public boolean removeComponent(C c);
    public int getComponentCount();
    public Map<Class, C> getComponents();
}
