package by.epam.tc.project.service;

import by.epam.tc.project.entity.User;
import by.epam.tc.project.service.exception.ServiceException;
import by.epam.tc.project.service.validator.ValidatorException;

public interface UserService {
    /**
     * Check if there is such a user in database and retrieves them
     * @param login is the entered login
     * @param password is the entered password
     * @return a user with such login from database
     * @throws ServiceException if there is no such a user in database
     */
    User authorize(String login, String password) throws ServiceException;

    /**
     * Add a new user in database according to the parameters
     * @param user is a new user
     * @throws ServiceException if such user's login already exists
     * @throws ValidatorException if entered parameters are not valid
     */
    void register(User user) throws ServiceException, ValidatorException;

    /**
     * Retrieve a user from database according to its login
     * @param login is user's login
     * @return a user with such login from database
     * @throws ServiceException if there is no such a user in database
     */
    User getUser(String login) throws ServiceException;

    /**
     * Update user's information in database
     * @param newLogin is a new (if there is) entered login of a user (or previous if not changed)
     * @param name is a new (if there is) entered name of a user (or previous if not changed)
     * @param surname is a new (if there is)entered surname of a user (or previous if not changed)
     * @param email is a new (if there is) entered email of a user (or previous if not changed)
     * @param country is a new (if there is) entered country of a user (or previous if not changed)
     * @param phone is a new (if there is) entered phone of a user (or previous if not changed)
     * @param login is a (previous) login of a user from the database
     * @throws ValidatorException if entered parameters are not valid
     */
    void updateUserInfo(String newLogin, String name, String surname, String email, String country, String phone, String login) throws ServiceException, ValidatorException;
}

