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
public enum ResultLogger {
    INSTANCE;

    public synchronized void logResult(String name, int correct, int guesses) {
        String format = "%-10s %s %10s \n";
        System.out.format(format, "client", ":", name);
        System.out.format(format, "correct", ":", correct);
        System.out.format(format, "guesses", ":", guesses);
        System.out.println("");
    }
}
