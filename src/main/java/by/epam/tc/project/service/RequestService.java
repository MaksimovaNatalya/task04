package by.epam.tc.project.service;

import by.epam.tc.project.entity.Request;
import by.epam.tc.project.service.exception.ServiceException;

import java.util.List;

public interface RequestService {
    List<Request> getAllRequests();
    List<Request> getRequestsByLogin(String login) throws ServiceException;
}
