package org.wordgames;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StopWatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


class PostgresSQLWordChecker {
    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String username = "postgres";
    private static String password = "password";
    static private Logger log = LogManager.getLogger(Permutation.class);

    static void findAllWordsFromArray(StopWatch stopWatch) throws SQLException {


        Connection con = DriverManager.getConnection(url, username, password);


        PreparedStatement ps = con.prepareStatement("drop table if exists all_combinations ;"+
                "create table all_combinations(word varchar(15) unique );");
        ps.executeUpdate();
        ps.close();
        log.info("Empty table was created");

        stopWatch.start("insert");
        ps = con.prepareStatement("COPY all_combinations FROM '/Users/daniel/IdeaProjects/Wordgame_2.0/all_permutations.csv' DELIMITER ' ';");
        ps.execute();
        ps.close();
        stopWatch.stop();
        log.info("Combinations from file were inserted into table");
        log.info("INDICES CREATION");
//        ps = con.prepareStatement("alter table all_combinations " +
//                "add constraint all_combinations_pkey " +
//                "primary key (word);");
//        ps.executeUpdate();
//        ps.close();
        log.info("DONE");
        stopWatch.start("separating words from all combinations");
        ps = con.prepareStatement("drop table if exists results_with_meanings;" +
                "create table results_with_meanings as " +
                "SELECT all_combinations.word,wn_word_and_gloss.gloss " +
                "From all_combinations " +
                " inner join wn_pro_mysql.wn_word_and_gloss" +
                " on all_combinations.word=wn_pro_mysql.wn_word_and_gloss.word;");
        ps.execute();
        ps.close();
        stopWatch.stop();
        con.close();


    }
}
