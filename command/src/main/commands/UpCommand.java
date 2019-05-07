/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.commands;

import main.Screen;

/**
 *
 * @author Eero
 */
public class UpCommand extends ScreenCommand {

    public UpCommand(Screen s) {
        super(s);
    }

    @Override
    public void execute() {
        screen.up();
    }
}
