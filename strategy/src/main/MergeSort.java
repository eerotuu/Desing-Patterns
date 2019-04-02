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
public class MergeSort implements SortingStrategy {

    private long c; // comparisons counter
    private long a; // array access counter

    @Override
    public void sort(int[] arr, int size) {
        c = 0;
        a = 0;

        mergeSort(arr, 0, size - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        c++;
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }

    private void merge(int[] arr, int l, int m, int r) {

        int max1 = m - l + 1;
        int max2 = r - m;

        int leftArr[] = new int[max1];
        int rightArr[] = new int[max2];
        c++;
        for (int i = 0; i < max1; i++) {
            leftArr[i] = arr[l + i];
            a += 2;
            c++;
        }
        c++;
        for (int j = 0; j < max2; j++) {
            rightArr[j] = arr[m + 1 + j];
            a += 2;
            c++;
        }

        int i = 0, j = 0;
        int k = l;

        c += 2;
        while (i < max1 && j < max2) {
            c++;
            a += 2;
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                a += 2;
                i++;
            } else {
                arr[k] = rightArr[j];
                a += 2;
                j++;
            }
            k++;
            c += 2;
        }
        c++;
        while (i < max1) {
            arr[k] = leftArr[i];
            a += 2;
            i++;
            k++;
            c++;
        }
        c++;
        while (j < max2) {
            arr[k] = rightArr[j];
            a += 2;
            j++;
            k++;
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
        return "merge";
    }
}
