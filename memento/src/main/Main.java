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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Riddler r = new Riddler();

        String name = "thread-";
        for (int i = 0; i < 5; i++) {
            new Thread(new Client(r,name + i)).start();
        }
    }
}
