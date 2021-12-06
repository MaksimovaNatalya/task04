package main;

import dao.exception.DAOException;
import dao.impl.UserDAOImpl;
import entity.Role;
import entity.User;

import java.sql.Connection;
import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) {

    //    Connection connection;

        {

             //   connection = ConnectorDB.getConnection();
            UserDAOImpl userDAO = null;
            try {
                userDAO = new UserDAOImpl();
            } catch (DAOException e) {
                e.printStackTrace();
            }
//            try {
//                System.out.println( userDAO.retrieveUserById(1));
//            } catch (DAOException e) {
//                e.printStackTrace();
//            }
            try {
                System.out.println( userDAO.retrieveAllUsers());
            } catch (DAOException e) {
                e.printStackTrace();
            }

            //   userDAO.addUser(new User(3, "mary", "123321", "mary", "fedorova",
               //         "mary@tut.by", "Belarus", "+375296215487", Role.Guest));



        }
    }
}
