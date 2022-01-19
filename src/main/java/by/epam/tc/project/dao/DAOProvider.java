package by.epam.tc.project.dao;

import by.epam.tc.project.dao.impl.RequestDAOImpl;
import by.epam.tc.project.dao.impl.RoomDAOImpl;
import by.epam.tc.project.dao.impl.UserDAOImpl;

public final class DAOProvider {
    public  static final DAOProvider instance = new DAOProvider();

private final UserDAO userDAO = new UserDAOImpl();
private final RoomDAO roomDAO = new RoomDAOImpl();
    private final RequestDAO requestDAO = new RequestDAOImpl();

    //TODO all other DAO

    public DAOProvider() {    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public RoomDAO getRoomDAO()  {
        return roomDAO;
    }

    public RequestDAO getRequestDAO()  {
        return requestDAO;
    }

    public static DAOProvider getInstance() {
        return instance;
    }
}
