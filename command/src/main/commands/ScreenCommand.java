/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.commands;

import main.Screen;
import main.commands.Command;

/**
 *
 * @author Eero
 */
public abstract class ScreenCommand implements Command {

    protected Screen screen;

    public ScreenCommand(Screen s) {
        screen = s;
    }

    @Override
    public abstract void execute();
}
