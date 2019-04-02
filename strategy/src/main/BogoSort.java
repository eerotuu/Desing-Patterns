package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Eero
 */
public class BogoSort implements SortingStrategy {

    private long c; // comparisons counter
    private long a; // array access counter

    @Override
    public void sort(int[] arr, int size) {
        c = 0;
        a = 0;

        c++;
        while (!isSorted(arr, size)) {
            suffle(arr, size);
            c++;
        }
    }

    private boolean isSorted(int[] arr, int size) {
        c++;
        for (int i = 1; i < size; i++) {
            c++;
            a += 2;
            if (arr[i] < arr[i - 1]) {
                return false;
            }
            c++;
        }
        return true;
    }

    private void suffle(int[] arr, int size) {
        c++;
        for (int i = 1; i <= size; i++) {
            int j = (int) (Math.random() * i);

            a += 4;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
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
        return "bogo";
    }

}
