/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.commands;

import main.Screen;
import main.commands.ScreenCommand;

/**
 *
 * @author Eero
 */
public class DownCommand extends ScreenCommand {

    public DownCommand(Screen s) {
        super(s);
    }

    @Override
    public void execute() {
        screen.down();
    }
}
