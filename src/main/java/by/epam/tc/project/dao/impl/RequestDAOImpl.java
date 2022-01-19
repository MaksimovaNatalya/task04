package by.epam.tc.project.dao.impl;

import by.epam.tc.project.dao.RequestDAO;
import by.epam.tc.project.dao.exception.DAOException;
import by.epam.tc.project.entity.Request;
import by.epam.tc.project.entity.Room;

import java.util.List;

public class RequestDAOImpl implements RequestDAO {
    @Override
    public List<Request> retrieveAllRequests() throws DAOException {
        return null;
    }

    @Override
    public Request retrieveRequestById(Integer id) throws DAOException {
        return null;
    }

    @Override
    public void deleteRequest(Integer id) throws DAOException {

    }

    @Override
    public List<Room> retrieveAllFreeRooms() throws DAOException {
        return null;
    }

    @Override
    public List<Room> retrieveFreeRoomsByMaxPersons() throws DAOException {
        return null;
    }

    @Override
    public List<Room> retrieveFreeRoomsByCategoryAndMaxPersons() throws DAOException {
        return null;
    }
}
