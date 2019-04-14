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
public class ProxyImage implements Image {
    
    private final String fileName;
    private RealImage image;
    
    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    public void display() {
        if(image == null) {
            image = new RealImage(fileName);
        }
        image.display();
    }

    @Override
    public void showData() {
        System.out.println("Name: " + fileName);
    }
}
