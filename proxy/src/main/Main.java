/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Eero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        List<Image> list = new ArrayList<>();

        String name = "photo_";
        for (int i = 0; i < 10; i++) {
            list.add(new ProxyImage(name + i));
        }

        System.out.println("Contents:");
        list.forEach(Image::showData);
        System.out.println("");

        Iterator<Image> itr;

        // iterate list thru 2 times, first time it loads and displays
        for (int i = 0; i < 2; i++) {
            itr = list.iterator();
            while (itr.hasNext()) {
                itr.next().display();
                System.in.read();
            }
        }

    }

}
