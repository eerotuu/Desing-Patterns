/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.skijumping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Eero
 */
public class JumpingMediator {

    private List<Judge> judges = new ArrayList<>();
    private List<Jumper> jumpers = new ArrayList<>();

    private Measurer measurer;
    private Secretary secretary;
    private ScoreBoard scoreBoard;

    private int nextJumper = 0;

    public void addAll(Collection<? extends Entity> c) {
        for (Entity e : c) {
            if (e.getClass() == Judge.class) {
                judges.add((Judge) e);
            } else if (e.getClass() == Jumper.class) {
                jumpers.add((Jumper) e);
            } else if (e.getClass() == Measurer.class) {
                measurer = (Measurer) e;
            } else if (e.getClass() == Secretary.class) {
                secretary = (Secretary) e;
            } else if (e.getClass() == ScoreBoard.class) {
                scoreBoard = (ScoreBoard) e;
            }
        }
    }

    public void nextJump() {
        if (nextJumper >= jumpers.size()) {
            nextJumper = 0;
        }
        Jumper j = jumpers.get(nextJumper++);

        Jump jump = j.jump();
        if (jump != null) {
            registerJump(j, jump);
        }

    }
    
    private void registerJump(Jumper jumper, Jump jump) {
        jump.setLength(measurer.measureJump());

        int stylePoints = 0;
        for (Judge j : judges) {
            stylePoints += j.giveStylePoints();
        }
        jump.setStylePoints(stylePoints);

        double score = secretary.calculateScore(jump);
        scoreBoard.createRow(jumper.getName(), score);
        scoreBoard.showBoard();
    }
}
