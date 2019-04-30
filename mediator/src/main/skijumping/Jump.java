/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.skijumping;

/**
 *
 * @author Eero
 */
public class Jump {

    private double length;
    private int stylePoints;

    public void setStylePoints(int stylePoints) {
        this.stylePoints = stylePoints;
    }

    public int getStylePoints() {
        return stylePoints;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }
}
