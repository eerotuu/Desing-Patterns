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
public class Screen {
    
    private boolean isDown = false;
    
    public void up() {
        if(isDown) {
            System.out.println("Screen is now up");
            isDown = false;
        }
    }
    
    public void down() {
        if(!isDown) {
            System.out.println("Screen is now down");
            isDown = true;
        }
    }
}
