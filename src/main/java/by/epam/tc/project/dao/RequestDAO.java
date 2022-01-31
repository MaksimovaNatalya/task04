package by.epam.tc.project.dao;

import by.epam.tc.project.dao.exception.DAOException;
import by.epam.tc.project.entity.Request;
import by.epam.tc.project.entity.Room;

import java.util.List;

public interface RequestDAO {
    List<Request> retrieveAllRequests () throws DAOException;
    List<Request> retrieveRequestsByUserId(String login) throws DAOException;

    void deleteRequest (Integer id) throws DAOException;

    List<Room> retrieveAllFreeRooms () throws DAOException;

    List<Room> retrieveFreeRoomsByMaxPersons () throws DAOException;
    List<Room> retrieveFreeRoomsByCategoryAndMaxPersons () throws DAOException;

    void addRequest(Request request) throws DAOException;

    void approveRequest(int requestId) throws DAOException;

}
