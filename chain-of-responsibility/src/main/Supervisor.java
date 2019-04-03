/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Eero
 */
public class Supervisor extends Management {

    public Supervisor() {
        super(new HeadOfUnit());
        this.raiseTreshold = 0.02;
    }
    
    @Override
    public String toString() {
        return "supervisor";
    }
}
