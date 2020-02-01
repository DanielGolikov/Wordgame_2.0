
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class WordsGenerator {

    Map<String, String> findAllPossibleWords(String word) throws IOException {
        Heaps_algorithm algorithm= new Heaps_algorithm();
        ArrayList<String> allPossibleValues= algorithm.getAllPossibleValues(word);

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
