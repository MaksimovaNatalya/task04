package dao;

import dao.exception.DAOException;
import dao.impl.RequestDAOImpl;
import dao.impl.RoomDAOImpl;
import dao.impl.UserDAOImpl;

public final class DAOFactory {
    private final static DAOFactory instance = new DAOFactory();

    private UserDAO userDAO;
    private RoomDAO roomDAO;
    private RequestDAO requestDAO;

    public static DAOFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() throws DAOException {
        if (userDAO == null) {
            userDAO = new UserDAOImpl();
        }
        return userDAO;
    }

    public RoomDAO getRoomDAO() throws DAOException {
        if (roomDAO == null) {
            roomDAO = new RoomDAOImpl();
        }
        return roomDAO;
    }

    public RequestDAO getRequestDAO() throws DAOException {
        if (requestDAO == null) {
            requestDAO = new RequestDAOImpl();
        }
        return requestDAO;
    }
}
