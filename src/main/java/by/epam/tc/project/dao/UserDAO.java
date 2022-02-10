package by.epam.tc.project.dao;

import by.epam.tc.project.dao.exception.DAOException;
import by.epam.tc.project.entity.User;

import java.util.List;

public interface UserDAO {
    /**
     * Check if there is such a user in database and retrieves them
     * @param login is the entered login
     * @param password is the entered password
     * @return a user with such login from database
     * @throws DAOException if there is no such a user in database
     */
    User authorize(String login, String password) throws DAOException;

    /**
     * Retrieve a user by his id
     * @param id is id of a user
     */
    User retrieveUserById(Integer id) throws DAOException;

    /**
     * Retrieve a user by his login
     * @param login is login of a user
     */
    User retrieveUserByLogin(String login) throws DAOException;

    /**
     * Add a new user in database according to the parameters
     * @param user is a new user
     * @throws DAOException if such a user already exists
     */
    void addUser(User user) throws DAOException;

    /**
     * Update user's information in database
     * @param newLogin is a new (if there is) entered login of a user (or previous if not changed)
     * @param name is a new (if there is) entered name of a user (or previous if not changed)
     * @param surname is a new (if there is)entered surname of a user (or previous if not changed)
     * @param email is a new (if there is) entered email of a user (or previous if not changed)
     * @param country is a new (if there is) entered country of a user (or previous if not changed)
     * @param phone is a new (if there is) entered phone of a user (or previous if not changed)
     * @param login is a (previous) login of a user from the database
     */
    void updateUserInfo(String newLogin, String name, String surname, String email, String country, String phone, String login
    ) throws DAOException;

    /**
     * Delete the user by login from database
     * @param login is login of a user
     */
    void deleteUser (String login) throws DAOException;
}

