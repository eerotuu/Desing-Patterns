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
public class Employee {

    private double salary;
    private Management manager;

    public Employee(double s, Management m) {
        salary = s;
        manager = m;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double s) {
        salary = s;
    }

    public void askRaise(double raise) {
        manager.handle(this, raise);
    }

}
