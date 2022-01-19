package by.epam.tc.project.dao;

import by.epam.tc.project.dao.exception.DAOException;
import by.epam.tc.project.entity.User;

import java.util.List;

public interface UserDAO {
    User authorization(String login, String password) throws DAOException;

    List<User> retrieveAllUsers() throws DAOException;

   List<User> retrieveAllAdmins() throws DAOException;
   List<User> retrieveAllManagers() throws DAOException;
   List<User> retrieveAllGuests() throws DAOException;

    User retrieveUserById(Integer id) throws DAOException;

    User retrieveUserByLogin(String login) throws DAOException;

    User retrieveUserByNameAndSurname(String name, String surname) throws DAOException;

    void addUser(User user) throws DAOException;

    void updateUser (User user) throws DAOException;

    void deleteUser(int id) throws DAOException;
}
