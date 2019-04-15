/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.builders;

/**
 *
 * @author Eero
 * @param <DataType>
 */
public interface BurgerBuilder<DataType> {

    public abstract void createNewBurger();

    public abstract void buildPatty();

    public abstract void buildBun();

    public abstract void buildSauce();

    public DataType getBurger();
}
