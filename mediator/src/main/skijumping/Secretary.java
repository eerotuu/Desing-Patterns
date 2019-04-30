/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.skijumping;

/**
 *
 * @author Eero
 */
public class Secretary extends Entity {
    
    public Secretary(JumpingMediator m) {
        super(m);
    }

    public double calculateScore(Jump jump) {
        return ((jump.getStylePoints() * jump.getLength()) / 100);
    }    
}
