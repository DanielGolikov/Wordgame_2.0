package org.wordgames;


import java.util.Map;
import java.util.Scanner;

import static org.wordgames.WordPicker.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String,String> result =getAllPossibleWordsFromOne(scanner.nextLine(),scanner.nextByte());
        System.out.println("result size:" + result.size());
        for (Map.Entry entry : result.entrySet()) {
            System.out.println(entry.getKey() + "   : " + entry.getValue());
        }
        MySQLConnector mySQLConnector=new MySQLConnector();
        System.out.println(mySQLConnector.getWordDescription("Fuji"));
    }
}
