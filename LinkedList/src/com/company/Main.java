package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // linkedListPlayground();
        playWithIntList();
    }

    private static void playWithIntList() {

        IntList ages = new IntList();
        ages.add(9);
        ages.add(3);
        ages.add(2);
        System.out.println(ages);

        System.out.println("Adding 50,000 items to IntList");
        long startTime = System.nanoTime();
        for (int i = 1; i < 50000; i++) {
            ages.add(i);
        }
        long endTime = System.nanoTime();
        printElapsedTime("Created the list", startTime, endTime);
    }

    private static void linkedListPlayground() {
        // write your code here
        LinkedList<String> names = new LinkedList<String>();
        names.add("Jack");
        names.add("Jim");

        System.out.println("My list: " + names);

        List<String> javaNames = new ArrayList<String>();
        javaNames.add("Jack");
        javaNames.add("Jim");
        System.out.println("Java list: " + javaNames);

        System.out.println(javaNames.get(1));
        System.out.println(names.get(1));

        LinkedList<Integer> favoriteNumbers = new LinkedList<Integer>();

        System.out.println("Adding 50,000 items to LinkedList");
        long startTime = System.nanoTime();
        for (int i = 1; i < 50000; i++) {
            favoriteNumbers.add(i);
        }
        long endTime = System.nanoTime();
        printElapsedTime("Created the list", startTime, endTime);
    }

    private static void printElapsedTime(String msg, long startTime, long endTime) {
        long elapsedNs = endTime - startTime;
        double elapsedMs = ((double) elapsedNs / 1000000);
        System.out.println(msg + ": " + elapsedMs + "ms");
    }
}

