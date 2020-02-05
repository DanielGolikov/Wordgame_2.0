package org.wordgames;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MySQLWordChecker {
    static Map<String, String> findAllWordsFromArray(ArrayList<String> allPossibleValues) throws IOException {
        MySQLConnector mySQLConnector = new MySQLConnector();
        Map<String,String> results = new HashMap<>();
        System.out.println("size:" + allPossibleValues.size());
        for (int i=0;i<allPossibleValues.size();i++) {
            String description = mySQLConnector.getWordDescription(allPossibleValues.get(i));
            if (!description.isEmpty()){
                results.put(allPossibleValues.get(i),description);
               System.out.println("adding");
            }else {
                System.out.println("passing");
            }
            System.out.print(i/(allPossibleValues.size()/100) + "% "+i+"  from "+ allPossibleValues.size()+"  is  ");

        }
        return results;
    }
}
