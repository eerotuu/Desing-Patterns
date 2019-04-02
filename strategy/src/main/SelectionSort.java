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
public class SelectionSort implements SortingStrategy {

    private long c; // comparisons counter
    private long a; // array access counter

    @Override
    public void sort(int[] arr, int size) {
        c = 0;
        a = 0;

        c++;
        for (int i = 0; i < size; i++) {
            int smallest = i;
            c++;
            for (int j = i + 1; j < size; j++) {
                c++;
                a += 2;
                if (arr[j] < arr[smallest]) {
                    smallest = j;
                }
                c++;
            }
            c++;
            if (smallest != i) {
                a += 4;
                int temp = arr[smallest];
                arr[smallest] = arr[i];
                arr[i] = temp;
            }
            c++;
        }
    }

    @Override
    public long getComparisons() {
        return c;
    }

    @Override
    public long getArrayAccess() {
        return a;
    }

    @Override
    public String toString() {
        return "selection";
    }
}
