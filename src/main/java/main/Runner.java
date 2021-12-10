package main;

import dao.DAOFactory;
import dao.RequestDAO;
import dao.RoomDAO;
import dao.UserDAO;
import dao.exception.DAOException;
import dao.impl.UserDAOImpl;
import entity.Role;
import entity.User;

import java.sql.Connection;
import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws DAOException {

        {
            DAOFactory daoFactory = DAOFactory.getInstance();
            UserDAO userDAO = daoFactory.getUserDAO();
            RoomDAO roomDAO = daoFactory.getRoomDAO();
            RequestDAO requestDAO = daoFactory.getRequestDAO();


            System.out.println("-----------------------------------");
            System.out.println(userDAO.retrieveAllUsers());

          //  System.out.println(userDAO.retrieveUserById(2));

            System.out.println("-----------------------------------");

            System.out.println(roomDAO.retrieveAllURooms());


            System.out.println("-----------------------------------");

            System.out.println(roomDAO.retrieveAllRoomsThatHaveRequests());

//            userDAO.addUser(new User(3, "mary", "123321", "mary", "fedorova",
//                    "mary@tut.by", "Belarus", "+375296215487", Role.Guest));


        }
    }
}
