package org.wordgames;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


class MySQLWordChecker {
    private static String url = "jdbc:mysql://localhost/mysql?allowMultiQueries=true";
    private static String username = "root";
    private static String password = "password";


    static void findAllWordsFromArray(ArrayList<String> allPossibleValues){
        try {
            Connection con;
            con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = con.prepareStatement("TRUNCATE TABLE wn_pro_mysql.temporary_results");
            ps.executeUpdate();
            for (String item:allPossibleValues){
                 ps = con.prepareStatement("CALL wn_pro_mysql.get_word_meaning ('" + item + "' ,@a);\n" +
                        "INSERT wn_pro_mysql.temporary_results(word,meaning) \n" +
                        "VALUES ('" + item +"' ,@a);" +
                         "DELETE FROM wn_pro_mysql.temporary_results WHERE meaning IS NULL");
                ps.executeUpdate();
                System.out.println(".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
