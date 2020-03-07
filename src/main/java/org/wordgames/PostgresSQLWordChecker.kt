package org.wordgames;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class PostgresSQLWordChecker {
    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String username = "postgres";
    private static String password = "password";

    static void findAllWordsFromArray() {
        Connection con;

        try {
            con = DriverManager.getConnection(url, username, password);


            PreparedStatement ps = con.prepareStatement("drop table if exists permutation ;" +
                    "create table permutation(word varchar(15) primary key);");
            ps.executeUpdate();
            System.out.println("table was created");

            ps = con.prepareStatement("COPY permutation FROM '/Users/daniel/IdeaProjects/Wordgame_2.0/all_permutations.csv' DELIMITER ' ' ;");
            ps.executeUpdate();
            System.out.println("results inserted");
            ps = con.prepareStatement(
                    "create temporary table results as " +
                    "SELECT wn_pro_mysql.wn_words.word " +
                    "From wn_pro_mysql.wn_words\n" +
                    "inner join permutation\n" +
                    "on wn_pro_mysql.wn_words.word=permutation.word");
            ps.executeUpdate();
            System.out.println("results created");
            ps = con.prepareStatement("drop table if exists wn_pro_mysql.results_with_meanings;" +
                    "create table wn_pro_mysql.results_with_meanings as " +
                    "SELECT results.word,wn_word_and_gloss.gloss " +
                    "From results " +
                    " inner join wn_pro_mysql.wn_word_and_gloss" +
                    " on results.word=wn_pro_mysql.wn_word_and_gloss.word;");
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
