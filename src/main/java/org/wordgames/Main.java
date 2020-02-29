package org.wordgames;

import java.util.ArrayList;

import static org.wordgames.Permutation.*;


public class Main {

    public static void main(String[] args) {
        ArrayList words = getAllPossibleValues("qwerty",2);
        long start = System.currentTimeMillis();
        MySQLWordChecker.findAllWordsFromArray(words);
        long finish = System.currentTimeMillis();

        long timeConsumedMillis = finish - start;
        System.out.println(timeConsumedMillis);
        start = System.currentTimeMillis();
        PostgresSQLWordChecker.findAllWordsFromArray(words);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println(timeConsumedMillis);
    }
}
