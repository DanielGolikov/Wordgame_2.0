package org.wordgames;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostgresSQLWordChecker {
    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String username = "postgres";
    private static String password = "password";
    static void findAllWordsFromArray(ArrayList<String> allPossibleValues) {
        try {
            Connection con;
            con = DriverManager.getConnection(url, username, password);

            PreparedStatement ps = con.prepareStatement("create temporary table temporary_results(word varchar(15) primary key);");
            ps.executeUpdate();
            System.out.println(allPossibleValues.size());
//            ps = con.prepareStatement("INSERT INTO temporary_results VALUES (?)");
//
//            for (int i=0;i<allPossibleValues.size();i++){
//                ps.setString(1, allPossibleValues.get(i));
//                System.out.println(i);
//                ps.addBatch();
//            }
//            ps.executeBatch();

            File csvFile = new File("file.csv");
            try (PrintWriter csvWriter = new PrintWriter(new FileWriter("file.csv"));){
                for(String item : allPossibleValues){
                    csvWriter.println(item);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            ps = con.prepareStatement("COPY temporary_results FROM '/Users/daniel/IdeaProjects/Wordgame_2.0/file.csv' DELIMITER ' ' ;");
            ps.executeUpdate();

            ps = con.prepareStatement("drop table if exists wn_pro_mysql.results;"+
                    "create table wn_pro_mysql.results as " +
                    "SELECT wn_pro_mysql.wn_words.word " +
                    "From wn_pro_mysql.wn_words\n" +
                    "inner join temporary_results\n" +
                    "on wn_pro_mysql.wn_words.word=temporary_results.word");
            ps.executeUpdate();

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
    }
