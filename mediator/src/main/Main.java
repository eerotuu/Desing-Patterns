/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import main.skijumping.Secretary;
import main.skijumping.ScoreBoard;
import main.skijumping.Measurer;
import main.skijumping.JumpingMediator;
import main.skijumping.Jumper;
import main.skijumping.Judge;
import main.skijumping.Entity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Eero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        JumpingMediator mediator = new JumpingMediator();

        Judge[] judges = new Judge[5];
        for (int i = 0; i < 5; i++) {
            judges[i] = new Judge(mediator);
        }
        Jumper jumper1 = new Jumper(mediator, "Jumper1");
        Measurer measurer = new Measurer(mediator);
        ScoreBoard scoreBoard = new ScoreBoard(mediator);
        Secretary secretary = new Secretary(mediator);

        List<Entity> entities = new ArrayList<Entity>(Arrays.asList(judges));
        Collections.addAll(entities, jumper1, measurer, scoreBoard, secretary);
        mediator.addAll(entities);

        mediator.nextJump();
        mediator.nextJump();
    }
}
