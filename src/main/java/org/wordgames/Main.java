package org.wordgames;

import java.util.ArrayList;
import java.util.Scanner;

import static org.wordgames.Permutation.*;


public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ArrayList words = getAllPossibleValues("apple");
        MySQLWordChecker.findAllWordsFromArray(words);
        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
        System.out.println(timeConsumedMillis);
    }
}
