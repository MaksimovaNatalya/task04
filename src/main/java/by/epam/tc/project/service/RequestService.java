package by.epam.tc.project.service;

import by.epam.tc.project.dao.exception.DAOException;
import by.epam.tc.project.entity.Request;
import by.epam.tc.project.entity.User;
import by.epam.tc.project.service.exception.ServiceException;

import java.util.List;

public interface RequestService {
    List<Request> getAllRequests() throws ServiceException;
    List<Request> getRequestsByLogin(String login) throws ServiceException;
    void addRequest (Request request) throws ServiceException;
}
