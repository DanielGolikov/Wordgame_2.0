package org.wordgames

import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.io.PrintWriter
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class Exporter {
    fun printResults() {
        val con: Connection
        try {
            con = DriverManager.getConnection(url, username, password)
            val rs = con.createStatement().executeQuery("Select * from wn_pro_mysql.results_with_meanings")
            while (rs.next()) {
                println("word: " + rs.getString(1) + "                definition: " + rs.getString(2))
            }
            con.close()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    fun exportIntoCSV() {
        val con: Connection
        try {
            con = DriverManager.getConnection(url, username, password)
            val rs = con.createStatement().executeQuery("Select * from wn_pro_mysql.results_with_meanings")
            File("result.csv")
            try {
                PrintWriter(FileWriter("result.csv")).use { csvWriter ->
                    while (rs.next()) {
                        csvWriter.println(rs.getString(1) + "|" + rs.getString(2))
                    }
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
            con.close()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    companion object {
        private const val url = "jdbc:postgresql://localhost:5432/postgres"
        private const val username = "postgres"
        private const val password = "password"
    }
}