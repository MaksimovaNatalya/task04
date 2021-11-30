package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class Connection {


    public static void main(String[] args) {
        Logger log = LogManager.getRootLogger();


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try {
                java.sql.Connection connection = ConnectorDB.getConnection();
                System.out.println("connection good");
                Statement st = connection.createStatement();
                System.out.println("statement good");
                ResultSet resultSet = st.executeQuery("SELECT *");
                System.out.println("resultSEt good");

                while (resultSet.next()) {
                    System.out.println("круто");
                    System.out.println(resultSet.getRow());
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
