package by.epam.tc.project.service;

import by.epam.tc.project.entity.Request;
import by.epam.tc.project.service.exception.ServiceException;

import java.util.List;

public interface RequestService {
    List<Request> getAllRequests() throws ServiceException;

    List<Request> getRequestsByLogin(String login) throws ServiceException;

    void addRequest(Request request) throws ServiceException;

    void approveRequest(int requestId) throws ServiceException;

    void declineRequest(int id) throws ServiceException;

    void cancelBooking(int id) throws ServiceException;
}
