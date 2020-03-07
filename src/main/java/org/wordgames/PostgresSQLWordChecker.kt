package org.wordgames

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object PostgresSQLWordChecker {
    private const val url = "jdbc:postgresql://localhost:5432/postgres"
    private const val username = "postgres"
    private const val password = "password"
    @JvmStatic
    fun findAllWordsFromArray() {
        val con: Connection
        try {
            con = DriverManager.getConnection(url, username, password)
            var ps = con.prepareStatement("drop table if exists permutation ;" +
                    "create table permutation(word varchar(15) primary key);")
            ps.executeUpdate()
            println("table was created")
            ps = con.prepareStatement("COPY permutation FROM '/Users/daniel/IdeaProjects/Wordgame_2.0/all_permutations.csv' DELIMITER ' ' ;")
            ps.executeUpdate()
            println("results inserted")
            ps = con.prepareStatement(
                    "create temporary table results as " +
                            "SELECT wn_pro_mysql.wn_words.word " +
                            "From wn_pro_mysql.wn_words\n" +
                            "inner join permutation\n" +
                            "on wn_pro_mysql.wn_words.word=permutation.word")
            ps.executeUpdate()
            println("results created")
            ps = con.prepareStatement("drop table if exists wn_pro_mysql.results_with_meanings;" +
                    "create table wn_pro_mysql.results_with_meanings as " +
                    "SELECT results.word,wn_word_and_gloss.gloss " +
                    "From results " +
                    " inner join wn_pro_mysql.wn_word_and_gloss" +
                    " on results.word=wn_pro_mysql.wn_word_and_gloss.word;")
            ps.executeUpdate()
            con.close()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }
}