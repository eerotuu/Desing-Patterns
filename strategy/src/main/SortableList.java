/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.util.Pair;

/**
 *
 * @author Eero
 */
public class SortableList {

    private SortingStrategy sortingStrategy;
    private int[] arr;
    private int size = 0;

    public SortableList(SortingStrategy s) {
        sortingStrategy = s;
        arr = new int[16];
    }

    public void add(int e) {
        if (size >= arr.length) {
            int[] temp = new int[arr.length * 2];
            System.arraycopy(arr, 0, temp, 0, arr.length);
            arr = temp;
        }
        arr[size] = e;
        size++;
    }

    public void remove(int i) {
        if (i < size) {
            int numMoved = size - i - 1;
            if (numMoved > 0) {
                System.arraycopy(arr, i + 1, arr, i, numMoved);
            }
            arr[--size] = 0;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int size() {
        return size;
    }

    /**
     * Sorts data using set sorting strategy.
     *
     * @return Pair(Comparisons, array accesses) used in sorting.
     */
    public Pair<Long, Long> sort() {
        sortingStrategy.sort(arr, size);
        return new Pair<>(sortingStrategy.getComparisons(),
                sortingStrategy.getArrayAccess());
    }

    public int get(int i) {
        if (i >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return arr[i];
    }

    public void setSortingStrategy(SortingStrategy s) {
        sortingStrategy = s;
    }

    @Override
    public String toString() {
        return sortingStrategy.toString();
    }
}
