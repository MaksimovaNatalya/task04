package dao.impl;

import dao.RequestDAO;
import dao.exception.DAOException;
import entity.Request;
import entity.Room;

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
