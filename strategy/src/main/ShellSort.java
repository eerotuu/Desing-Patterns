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
public class ShellSort implements SortingStrategy {

    private long c; // comparisons counter
    private long a; // array access counter

    @Override
    public void sort(int[] arr, int size) {
        c = 0;
        a = 0;

        c++;
        for (int gap = size / 2; gap > 0; gap /= 2) {
            c++;
            for (int i = gap; i < size; i += 1) {
                int temp = arr[i];
                a++;
                int j;
                c += 2;
                a++;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                    a += 2;
                    c += 2;
                }
                arr[j] = temp;
                a++;
                c++;
                a++;
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
        return "shell";
    }

}
