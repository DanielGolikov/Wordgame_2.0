package org.wordgames;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static org.wordgames.MySQLWordChecker.findAllWordsFromArray;
import static org.wordgames.Permutation.getAllPossibleValues;

public class WordPicker {

    static Map<String, String> getAllPossibleWordsFromOne(String word,int size){
        ArrayList<String> allPossibleValues = new ArrayList<>(getAllPossibleValues(word));
        ArrayList<String> values = new ArrayList<>();
        for (String item:allPossibleValues){
            if (item.length()>=size){
                values.add(item);
            }
        }

        try {
            Map<String,String> result= findAllWordsFromArray(values);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
