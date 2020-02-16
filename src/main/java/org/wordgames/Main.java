package org.wordgames;

import java.util.ArrayList;
import java.util.Scanner;

import static org.wordgames.Permutation.*;


public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
// поиск смысла жизни ...
        ArrayList words = getAllPossibleValues("");
        MySQLWordChecker.findAllWordsFromArray(words);
        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
        System.out.println(timeConsumedMillis);
    }
}
