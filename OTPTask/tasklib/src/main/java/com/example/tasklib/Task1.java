package com.example.tasklib;

import android.provider.MediaStore;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Egor Gritsina on 6/5/17.
 */

public class Task1 {

    private static String FILE_NAME = "input.txt";
    private static List<InputLetter> inputList;

    public static void main(String[] args) {

        inputList = new ArrayList<>();

        try {
            readInputList();
        } catch (IOException e) {
            System.out.println("Impossible! Some exception..");
            e.printStackTrace();
            return;
        }
        System.out.println("Input: " + inputList);
        String stringToFind = "OneTwoTrip";

        boolean isFind = false;
        for (Character ch : stringToFind.toLowerCase().toCharArray()) {
            isFind = false;
            for (InputLetter letter : inputList) {
                if (letter.getCh() == ch) {
                    System.out.println(letter);
                    inputList.remove(letter);
                    isFind = true;
                    break;
                }
            }
            if (!isFind) {
                System.out.println("Impossible!");
                return;
            }
        }

        System.out.println("Output: " + inputList);

    }

    private static void readInputList() throws IOException {

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(FILE_NAME), StandardCharsets.UTF_8))) {

            String line = reader.readLine();
            int M, N;
            String[] sizes = line.split(" ");
            M = Integer.valueOf(sizes[0]);
            N = Integer.valueOf(sizes[1]);

            for (int i = 0; i < M; i++) {
                line = reader.readLine().toLowerCase();
                for (int j = 0; j < N; j++) {
                    inputList.add(new InputLetter(i,j,line.charAt(j)));
                }
            }

        } catch (Exception e) {
            throw new IOException();
        }

    }
    static class InputLetter {
        private int i;
        private int j;
        private char ch;

        public InputLetter(int i, int j, char ch) {
            this.i = i;
            this.j = j;
            this.ch = ch;
        }

        public char getCh() {
            return ch;
        }

        @Override
        public String toString() {
            return ch + " - ("+i+","+j+")";
        }
    }

}
