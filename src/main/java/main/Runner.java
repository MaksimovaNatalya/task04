package main;

import dao.impl.UserDAOImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) {

        Connection connection;

        {
            try {
                connection = ConnectorDB.getConnection();
                System.out.println("Connection is good");
                UserDAOImpl userDAO = new UserDAOImpl();
                System.out.println( userDAO.retrieveUserById(1));
              //  System.out.println( userDAO.retrieveAllUsers());

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
