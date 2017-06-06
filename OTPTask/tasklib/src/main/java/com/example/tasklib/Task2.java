package com.example.tasklib;

import java.util.Random;

/**
 * Created by Egor Gritsina on 6/6/17.
 */

public class Task2 {

    private enum Direction {
        LEFT,
        DOWN,
        RIGHT,
        UP
    }

    public static void main(String[] args) {

        int N = 4;
        int array[][] = new int[2*N -1][2*N - 1];
        Random random = new Random();

        for (int i = 0; i < 2*N-1; i++) {
            for (int j = 0; j < 2*N-1; j++) {
                array[i][j] = random.nextInt(9);
                System.out.print(array[i][j]+ " ");
            }
            System.out.print("\n");
        }

        System.out.print("\n");

        Direction direction = Direction.LEFT;

        int i, j, step, iteration ;
        i = j = N - 1;                // set to central item
        step = iteration = 1;         // control for iterations
        long size = (2*N-1)*(2*N-1);  // global matrix size

        while (size > 0) {
            System.out.print(array[i][j] + " ");
            size--;
            switch (direction) {  // move to next item
                case LEFT:
                    j--;
                    break;
                case DOWN:
                    i++;
                    break;
                case UP:
                    i--;
                    break;
                case RIGHT:
                    j++;
                    break;
            }
            step--;
            if (step == 0) {   // change direction;
                switch (direction) {
                    case LEFT:
                        direction = Direction.DOWN;
                        break;
                    case DOWN:
                        direction = Direction.RIGHT;
                        iteration++;
                        break;
                    case UP:
                        direction = Direction.LEFT;
                        iteration++;
                        break;
                    case RIGHT:
                        direction = Direction.UP;
                        break;
                }
                step = iteration;
            }
        }
        System.out.println("\nIterations: " + iteration);
    }

}
