package org.wordgames;

import java.util.ArrayList;

import static org.wordgames.Permutation.*;


public class Main {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ArrayList words = getAllPossibleValues("apple",4);
        MySQLWordChecker.findAllWordsFromArray(words);
        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
        System.out.println(timeConsumedMillis);
    }
}
