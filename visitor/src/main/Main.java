/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;

/**
 *
 * @author Eero
 */
public class Main {

    public static int STATE_COUNT = 0; // for checking created state objects

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        Car[] cars = new Car[]{
            new Car("Mazda RX7"),
            new Car("Toyota AE86"),
            new Car("BMW M3 (E36)")
        };

        for (Car c : cars) {
            new Thread(c).start();
        }

        System.in.read();

        for (Car c : cars) {
            c.stop();
        }
    }
}
