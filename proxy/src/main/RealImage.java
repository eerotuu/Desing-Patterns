/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Date;

/**
 *
 * @author Eero
 */
public class RealImage implements Image {
    
    private final String fileName;   
    
    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }
    
    private void loadFromDisk() {
        System.out.println("Loading  " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    @Override
    public void showData() {
        System.out.println("Name: " + fileName);
    }
    
}
