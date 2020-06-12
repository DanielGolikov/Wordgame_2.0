package org.wordgames;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        WordGameConnector.playWordGame("apple",4);
        Exporter exporter=new Exporter();
        exporter.print();
    }
}
