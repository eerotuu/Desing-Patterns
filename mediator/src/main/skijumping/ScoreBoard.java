/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.skijumping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Eero
 */
public class ScoreBoard extends Entity {

    List<ScoreRow> table = new ArrayList<>();

    public ScoreBoard(JumpingMediator m) {
        super(m);
    }

    public void createRow(String name, double score) {
        table.add(new ScoreRow(name, score));
    }

    public void showBoard() {
        System.out.println("Printing board");
        Collections.sort(table);
        Collections.reverse(table);
        table.forEach(System.out::println);
        System.out.println("");
    }
}
