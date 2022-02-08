package by.epam.tc.project.dao;

import by.epam.tc.project.dao.exception.DAOException;
import by.epam.tc.project.entity.User;

import java.util.List;

public interface UserDAO {
    User authorize(String login, String password) throws DAOException;

    List<User> retrieveAllUsers() throws DAOException;

    User retrieveUserById(Integer id) throws DAOException;

    User retrieveUserByLogin(String login) throws DAOException;

    void addUser(User user) throws DAOException;

    void updateUserInfo(String newLogin, String name, String surname, String email, String country, String phone, String login
    ) throws DAOException;

    void deleteUser (String login) throws DAOException;
}

