package org.wordgames;

import java.util.ArrayList;

import static org.wordgames.Permutation.*;


public class Main {

    public static void main(String[] args) {
        ArrayList words = getAllPossibleValues("apple",4);
//        long start = System.currentTimeMillis();
//        MySQLWordChecker.findAllWordsFromArray(words);
//        long finish = System.currentTimeMillis();
//        long timeConsumedMillis = finish - start;
//        System.out.println(timeConsumedMillis);
        long start = System.currentTimeMillis();
        PostgresSQLWordChecker.findAllWordsFromArray(words);
        long finish = System.currentTimeMillis();
        double timeConsumedMillis = finish - start;
        System.out.println(timeConsumedMillis/60000);
    }
}
