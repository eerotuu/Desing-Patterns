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
public class QuickSort implements SortingStrategy {

    private long c; // comparisons counter
    private long a; // array access counter

    @Override
    public void sort(int[] arr, int size) {
        c = 0;
        a = 0;

        quickSort(arr, 0, size - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        c++;
        if (low < high) {
            int i = partition(arr, low, high);

            quickSort(arr, low, i - 1);
            quickSort(arr, i + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        a++;
        int i = (low - 1);

        c++;
        for (int j = low; j < high; j++) {
            c++;
            a++;
            if (arr[j] <= pivot) {
                i++;
                a += 4;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            c++;
        }
        a += 4;
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
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
        return "quick";
    }
}
