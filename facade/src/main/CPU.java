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
public class CPU {

    private long position;

    public void freeze() {
        System.out.println("freeze");
    }

    void jump(long position) {
        System.out.println("jumping : " + String.format("%x", position));
        this.position = position;
    }

    void execute() {
        System.out.println("excecuting");
        System.out.println(Memory.memMap.get(position));
    }
}
