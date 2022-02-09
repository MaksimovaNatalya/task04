package by.epam.tc.project.service;

import by.epam.tc.project.entity.User;
import by.epam.tc.project.service.exception.ServiceException;
import by.epam.tc.project.service.validator.ValidatorException;

public interface UserService {

    User authorize(String login, String password) throws ServiceException;

    void register(User user) throws ServiceException, ValidatorException;

    User getUser(String login) throws ServiceException;

    void updateUserInfo(String newLogin, String name, String surname, String email, String country, String phone, String login) throws ServiceException;
}

