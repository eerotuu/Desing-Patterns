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
public class HeapSort implements SortingStrategy {

    private long c; // comparisons
    private long a; // array accesses

    @Override
    public void sort(int[] arr, int size) {
        c = 0;
        a = 0;

        c++;
        for (int i = size / 2; i >= 0; i--) {
            heapify(arr, size, i);
            c++;
        }

        c++;
        for (int i = size - 1; i >= 0; i--) {
            a += 4;
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int size, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        c += 2;
        a += 2;
        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }
        c += 2;
        a += 2;
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }
        c++;
        if (largest != i) {
            a += 4;
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, size, largest);
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
        return "heap";
    }

}
