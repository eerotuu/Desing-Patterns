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
public class Judge extends Entity {

    public Judge(JumpingMediator m) {
        super(m);
    }

    public int giveStylePoints() {
        return (int) (Math.floor(Math.random() * 10) + 1);
    }
}
