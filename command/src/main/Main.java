/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import main.commands.DownCommand;
import main.commands.UpCommand;

/**
 *
 * @author Eero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Screen screen = new Screen(); 
    
        WallButton up = new WallButton(new UpCommand(screen));
        WallButton down = new WallButton(new DownCommand(screen));
        
        up.push();
        down.push();
        up.push();
        
    }
    
}
