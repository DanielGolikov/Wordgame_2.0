package org.wordgames;

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
            for (int i=0;i<allPossibleValues.size();i++){
                ps = con.prepareStatement("insert into temporary_results values ('"+ allPossibleValues.get(i) +"');");
                ps.executeUpdate();
                System.out.println(i);
            }

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
