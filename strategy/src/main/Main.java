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
public class Main {

    static final int DATA_SIZE = 1000;
    static final String FORMAT = "%-12s %s %12s %s %16s\n";

    public static void main(String[] args) {

        int[] generatedData = new int[DATA_SIZE];
        for (int i = 0; i < DATA_SIZE; i++) {
            generatedData[i] = (int) (Math.floor(Math.random() * 1000) + 1);
        }

        System.out.println("data size: " + DATA_SIZE);
        System.out.format(FORMAT, "ALGORITHM", "|", "COMPARISONS", "|", "ARRAY ACCESSES");

        getAnalysis(new SortableList(new QuickSort()), generatedData);
        getAnalysis(new SortableList(new ShellSort()), generatedData);
        getAnalysis(new SortableList(new MergeSort()), generatedData);
        getAnalysis(new SortableList(new HeapSort()), generatedData);
        getAnalysis(new SortableList(new SelectionSort()), generatedData);

        // give bogo a better chance...
        int bogoDataSize = 10;
        generatedData = new int[bogoDataSize];
        for (int i = 0; i < bogoDataSize; i++) {
            generatedData[i] = (int) (Math.floor(Math.random() * 1000) + 1);
        }

        System.out.println("\n\ndata size: " + bogoDataSize);
        System.out.format(FORMAT, "ALGORITHM", "|", "COMPARISONS", "|", "ARRAY ACCESSES");

        getAnalysis(new SortableList(new BogoSort()), generatedData);
        
    }

    public static void getAnalysis(SortableList list, int[] data) {
        for (int i = 0; i < data.length; i++) {
            list.add(data[i]);
        }

        Pair<Long, Long> result = list.sort();
        System.out.format(FORMAT, list, "|", result.getKey(), "|", result.getValue());
    }
}
