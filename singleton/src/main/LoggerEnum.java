/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eero
 */
public enum LoggerEnum {
    INSTANCE;
    
    private FileWriter FW;
    private PrintWriter WRITER;
    
    private LoggerEnum() {
        try {
            FW = new FileWriter("event_log.txt");
            WRITER = new PrintWriter(FW, true);
        } catch (IOException ex) {
            Logger.getLogger(LoggerEnum.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized void log(String event) {
        WRITER.println("[" + new Date() + "] : " + event);
        WRITER.flush();
    }  
}
