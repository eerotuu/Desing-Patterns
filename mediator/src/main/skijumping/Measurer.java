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
public class Measurer extends Entity {

    public Measurer(JumpingMediator m) {
        super(m);
    }

    public double measureJump() {
        return (Math.random() * 200) + 40;
    }
}
