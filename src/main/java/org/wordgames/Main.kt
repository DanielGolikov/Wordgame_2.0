package org.wordgames;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.wordgames.Permutation.*;


public class Main {

    public static void main(String[] args) {
        getAllPossibleValues("object",3);

        long start = System.currentTimeMillis();
        PostgresSQLWordChecker.findAllWordsFromArray();
        long finish = System.currentTimeMillis();
        double timeConsumedMillis = finish - start;
        System.out.println(timeConsumedMillis/1000);

        Exporter ex = new Exporter();
        ex.exportIntoCSV();
    }
}
