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
public class HeadOfUnit extends Management {

    public HeadOfUnit() {
        super(new CEO());
        this.raiseTreshold = 0.05;
    }
    
    @Override
    public String toString() {
        return "head of unit";
    }
}
