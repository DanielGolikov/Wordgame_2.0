package org.wordgames;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class OxfordWordsChecker {

    Map<String, String> findAllPossibleWordsFromArray(ArrayList<String> allPossibleValues) throws IOException {

        OxfordDictionaryAccess oxfordDictionaryAccess = new OxfordDictionaryAccess();

        Map<String,String> results = new HashMap<>();

        for (String item : allPossibleValues) {
            String description = oxfordDictionaryAccess.getWordDescription(item);
            if (!description.isEmpty()){
                results.put(item,description);
            }
        }
        return (results);
    }


}
