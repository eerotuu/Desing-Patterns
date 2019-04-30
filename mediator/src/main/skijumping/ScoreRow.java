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
public class ScoreRow implements Comparable<ScoreRow> {

    private String jumperName;
    private double score;

    public ScoreRow(String jumperName, double score) {
        this.jumperName = jumperName;
        this.score = score;
    }
    
    public String getJumperName() {
        return jumperName;
    }

    @Override
    public int compareTo(ScoreRow o) {
        if(score < o.score) return -1;
        if(score > o.score) return 1;
        return 0;
    }
    
    @Override
    public String toString() {
        return jumperName + " | " + String.format("%.2f", score);
    }
}
