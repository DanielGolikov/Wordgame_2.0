package org.wordgames;


import java.sql.*;
import java.util.ArrayList;


class MySQLWordChecker {
    private static String url = "jdbc:mysql://localhost/mysql?allowMultiQueries=true";
    private static String username = "root";
    private static String password = "password";


    static void findAllWordsFromArray(ArrayList<String> allPossibleValues){
        try {
            Connection con;
            con = DriverManager.getConnection(url, username, password);

            PreparedStatement ps = con.prepareStatement("create temporary table temporary_results(word varchar(15) primary key);");
            ps.executeUpdate();

            for (String item:allPossibleValues){
                ps = con.prepareStatement("insert into temporary_results values('"+ item +"');");
                ps.executeUpdate();
               // System.out.println(".");
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
