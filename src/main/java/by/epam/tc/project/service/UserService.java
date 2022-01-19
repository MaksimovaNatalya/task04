package by.epam.tc.project.service;

import by.epam.tc.project.entity.User;
import by.epam.tc.project.service.exception.ServiceException;

public interface UserService {

    User authorization(String login, String password) throws ServiceException;

    void registration(String firstName, String lastName, String email, String country, String password) throws ServiceException;

    User getUser(String login) throws ServiceException;

    void delete(User user) throws ServiceException;
}
