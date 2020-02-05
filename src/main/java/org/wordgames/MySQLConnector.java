package org.wordgames;

import java.sql.*;
import java.util.*;

class MySQLConnector {
    private String url = "jdbc:mysql://localhost/mysql";
    private String username = "daniel";
    private String password = "password";

     String getWordDescription(String input) {
        try {
            Connection con;
            con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = con.prepareStatement("SELECT wn_pro_mysql.wn_synset.word, wn_pro_mysql.wn_gloss.gloss\n" +
                    "FROM wn_pro_mysql.wn_synset\n" +
                    "INNER JOIN wn_pro_mysql.wn_gloss ON wn_pro_mysql.wn_synset.synset_id = wn_pro_mysql.wn_gloss.synset_id\n" +
                    "where wn_pro_mysql.wn_synset.word='"+input+"';");
            ResultSet resultSet = ps.executeQuery();
            List<String> descriptions = new ArrayList<>();
            while (resultSet.next()) {
                descriptions.add(resultSet.getString("gloss"));
            }
            con.close();
            if (descriptions.isEmpty()) {
                return "";
            }
            return descriptions.get(0);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return "";
    }
}

