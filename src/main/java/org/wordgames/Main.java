package org.wordgames;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        WordGameConnector.playWordGame("tar",3);
        Exporter exporter=new Exporter();
        exporter.print();

    }
}
