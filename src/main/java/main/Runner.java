package main;

import dao.exception.DAOException;
import dao.impl.UserDAOImpl;
import entity.Role;
import entity.User;

import java.sql.Connection;
import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws DAOException {

        {
            UserDAOImpl userDAO = null;
            userDAO = new UserDAOImpl();


            System.out.println("-----------------------------------");
            System.out.println(userDAO.retrieveAllUsers());

            System.out.println("-----------------------------------");
            System.out.println(userDAO.retrieveUserById(2));

            System.out.println("-----------------------------------");

//            userDAO.addUser(new User(3, "mary", "123321", "mary", "fedorova",
//                    "mary@tut.by", "Belarus", "+375296215487", Role.Guest));


        }
    }
}
