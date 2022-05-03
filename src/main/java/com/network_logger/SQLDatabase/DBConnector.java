package com.network_logger.SQLDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {


    public Connection connectToLocalDB() {
        //localhost
        //3306
        String serverIP = "130.225.170.95:3306";
        String dbName = "activity_log";
        String url = "jdbc:mysql://locahost:3306/activity_log";
        String username = "admin3";
        String password = "abcdE123!";
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public Connection connectToRemoteDB() {
        //localhost
        //3306
        String serverIP = "130.225.170.95:3306";
        String dbName = "activity_log";
        String url = "jdbc:mysql://130.225.170.95:3306/activity_log";
        String username = "admin3";
        String password = "abcdE123!";
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return connection;
    }
}

