package com.example.tasklib;

import java.util.Random;

/**
 * Created by Egor Gritsina on 6/6/17.
 */

public class Task2 {

    private static int array[][];

    public static void main(String[] args) {

        int N = 2;
        array = new int[2*N -1][2*N - 1];
        Random random = new Random();

        for (int i = 0; i < 2*N-1; i++) {
            for (int j = 0; j < 2*N-1; j++) {
                array[i][j] = random.nextInt(9);
                System.out.print(array[i][j]+ " ");
            }
            System.out.print("\n");
        }



    }

}
