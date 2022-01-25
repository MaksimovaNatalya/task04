package by.epam.tc.project;

import by.epam.tc.project.dao.DAOProvider;
import by.epam.tc.project.dao.RequestDAO;
import by.epam.tc.project.dao.RoomDAO;
import by.epam.tc.project.dao.UserDAO;
import by.epam.tc.project.dao.exception.DAOException;

public class Runner {
    public static void main(String[] args) throws DAOException {

        {
            DAOProvider daoFactory = DAOProvider.getInstance();
            UserDAO userDAO = daoFactory.getUserDAO();
            RoomDAO roomDAO = daoFactory.getRoomDAO();
            RequestDAO requestDAO = daoFactory.getRequestDAO();


            System.out.println("-----------------------------------");
            System.out.println(userDAO.retrieveAllUsers());

          //  System.out.println(userDAO.retrieveUserById(2));

            System.out.println("-----------------------------------");

            System.out.println(roomDAO.retrieveAllRooms());


            System.out.println("-----------------------------------");

            System.out.println(roomDAO.retrieveAllRoomsThatHaveRequests());

//            userDAO.addUser(new User(3, "mary", "123321", "mary", "fedorova",
//                    "mary@tut.by", "Belarus", "+375296215487", Role.Guest));


        }
    }
}
