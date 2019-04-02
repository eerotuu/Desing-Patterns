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
public interface SortingStrategy {

    public void sort(int[] arr, int size);

    public long getComparisons();

    public long getArrayAccess();
}
