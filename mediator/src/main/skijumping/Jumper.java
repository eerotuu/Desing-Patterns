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
public class Jumper extends Entity {

    private String name;

    private Jump[] jumps = new Jump[2];
    private int jumpCount = 0;

    public Jumper(JumpingMediator m, String name) {
        super(m);
        this.name = name;
    }

    protected Jump jump() {
        Jump jump = null;
        if (jumpCount < 2) {
            jump = new Jump();
            jumps[jumpCount++] = jump;

        }
        return jump;
    }

    protected String getName() {
        return name;
    }
}
