package org.example;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Task1 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int n = scanner.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt();
        }

        int minValue = a[0];

        for (int i = 1; i < n; i++) {
            if (abs(a[i]) < abs(minValue)) {
                minValue = a[i];
            }
        }

        System.out.println("Сгенерированный массив:");
        for (int num : a) {
            System.out.println(num);
        }

        System.out.println("Минимальное по модулю число: " + minValue);

        scanner.close();
    }
}