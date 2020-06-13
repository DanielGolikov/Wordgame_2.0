package org.wordgames;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StopWatch;

import java.sql.SQLException;
import java.util.HashMap;


public class WordGameConnector {
    static private Logger log = LogManager.getLogger(Permutation.class);

    public static HashMap<String, String> playWordGame(String word, long length) throws SQLException {
        StopWatch stopWatch = new StopWatchMilli();

        log.info("Origin word is obtained");
        stopWatch.start("letters permutations");
        Permutation.getAllPossibleValues(word.toLowerCase(), length);
        stopWatch.stop();
      //  stopWatch.start("filtering out trashy words");
        PostgresSQLWordChecker.findAllWordsFromArray(stopWatch);
       // stopWatch.stop();
        log.info(stopWatch.prettyPrint());
        Exporter ex = new Exporter();
        return ex.exportIntoHashMap();
    }
}
