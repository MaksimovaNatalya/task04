package by.epam.tc.project.service;

import by.epam.tc.project.entity.User;
import by.epam.tc.project.service.exception.ServiceException;

public interface UserService {

    User authorize(String login, String password) throws ServiceException;

    void register(User user) throws ServiceException;

    User getUser(String login) throws ServiceException;

    void delete(User user) throws ServiceException;
}
