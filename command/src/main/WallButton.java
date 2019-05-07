/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import main.commands.Command;

/**
 *
 * @author Eero
 */
public class WallButton {

    private Command cmd;

    public WallButton(Command c) {
        cmd = c;
    }
    
    public void push() {
        cmd.execute();
    }
}
