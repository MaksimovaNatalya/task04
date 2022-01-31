package by.epam.tc.project.dao;

import by.epam.tc.project.dao.exception.DAOException;
import by.epam.tc.project.entity.Request;

import java.util.List;

public interface RequestDAO {
    List<Request> retrieveAllRequests() throws DAOException;

    List<Request> retrieveRequestsByUserId(String login) throws DAOException;

    void addRequest(Request request) throws DAOException;

    void approveRequest(int requestId) throws DAOException;

    void declineRequest(int id) throws DAOException;

    void cancelBooking(int id) throws DAOException;
}
