package main;

import dao.exception.DAOException;
import dao.impl.UserDAOImpl;
import entity.Role;
import entity.User;

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
               // System.out.println( userDAO.retrieveUserById(1));
              // System.out.println( userDAO.retrieveAllUsers());
               userDAO.addUser(new User(3, "mary", "123321", "mary", "fedorova",
                       "mary@tut.by", "Belarus", "+375296215487", Role.Guest));


            } catch (SQLException e) {
                e.printStackTrace();
            } catch (DAOException e) {
                e.printStackTrace();
            }
        }
    }
}
