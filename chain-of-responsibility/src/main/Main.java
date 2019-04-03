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

    public static void main(String[] args) {
        Management supervisor = new Supervisor();
        
        Employee e = new Employee(3500, supervisor);
        
        // ask raise, manager who approves the request sets new salary for employee
        e.askRaise(234);
        
        System.out.format("%.2f\n",e.getSalary());

    }
    
}
