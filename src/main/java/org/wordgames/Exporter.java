package org.wordgames;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

class Exporter {
    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String username = "postgres";
    private static String password = "password";

    HashMap<String, String> exportIntoHashMap(){

        HashMap<String, String> results = new HashMap();
        Connection con;

        try {
            con = DriverManager.getConnection(url, username, password);
            ResultSet rs = con.createStatement().executeQuery("Select * from results_with_meanings");
            while(rs.next()) {
                results.put(rs.getString(1),rs.getString(2));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
    void print(){

        Connection con;

        try {
            con = DriverManager.getConnection(url, username, password);
            ResultSet rs = con.createStatement().executeQuery("Select * from results_with_meanings");
            while(rs.next()) {
                System.out.println(rs.getString(1)+"   "+rs.getString(2));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    void exportIntoCSV(){
        Connection con;

        try {
            con = DriverManager.getConnection(url, username, password);
            ResultSet rs = con.createStatement().executeQuery("Select * from results_with_meanings");
            new File("result.csv");
            try (PrintWriter csvWriter = new PrintWriter(new FileWriter("result.csv"))) {
                while(rs.next()){
                    csvWriter.println(rs.getString(1)+"|"+ rs.getString(2));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
