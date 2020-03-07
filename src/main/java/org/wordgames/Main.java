package org.wordgames;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.wordgames.Permutation.*;


public class Main {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        getAllPossibleValues("liberation",5);
        PostgresSQLWordChecker.findAllWordsFromArray();
        long finish = System.currentTimeMillis();
        double timeConsumedMillis = finish - start;
        System.out.println(timeConsumedMillis/1000);

        Exporter ex = new Exporter();
        ex.exportIntoCSV();
    }
}
