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
public abstract class Management {

    private Management successor;
    protected double raiseTreshold;

    public Management(Management s) {
        successor = s;
    }

    public void handle(Employee e, double raise) {

        double newSalary = e.getSalary() + raise;
        double percent = (newSalary / e.getSalary()) - 1;

        if (successor == null) {
            
            // modifier for raise -> higher raise request = lower chance
            double chanceModifier = 1 - (percent + 0.4);

            System.out.println(this + " ponders, chance: " 
                    + String.format("%.1f", chanceModifier * 100) + "%");

            // lets make ceo to not accept every request
            if (Math.random() <= chanceModifier) {
                e.setSalary(newSalary);
            }
            
        } else {
            if (percent <= raiseTreshold) {
                e.setSalary(newSalary);
            } else {
                System.out.println(String.format("%.1f", percent * 100) 
                        + "% raise is too much for " + this + ", asks " + successor);
                successor.handle(e, raise);
            }
        }
    }
}
