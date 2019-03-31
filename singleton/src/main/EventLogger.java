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

/**
 *
 * @author Eero
 */
public class EventLogger {

    private PrintWriter writer;
    private static EventLogger sInstance = null;

    private EventLogger() {
        try {
            FileWriter fw = new FileWriter("event_log.txt");
            writer = new PrintWriter(fw, true);
        } catch (IOException ex) {
        }
    }

    public static EventLogger getInstance() {
        if (sInstance == null) {
            synchronized (EventLogger.class) {
                if(sInstance == null) {
                    sInstance = new EventLogger();
                }
            }
        }
        return sInstance;
    }

    public synchronized void log(String event) {
        writer.println("[" + new Date() + "] : " + event);
        writer.flush();
    }
}
