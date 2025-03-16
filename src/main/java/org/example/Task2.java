package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Task2 {

    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            list.add(random.nextDouble() * 100);
        }

        System.out.println("До сортировки: " + list);

        quickSort(list, 0, list.size() - 1);

        System.out.println("После сортировки: " + list);
    }

    public static void quickSort(ArrayList<Double> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);

            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }

    public static int partition(ArrayList<Double> list, int low, int high) {
        double pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j) <= pivot) {
                i++;
                double temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        double temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        return i + 1;
    }
}