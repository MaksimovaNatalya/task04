package dao;

import dao.exception.DAOException;
import entity.User;

import java.util.List;

public interface UserDAO {
    List<User> retrieveAllUsers() throws DAOException;

    User retrieveUserById(Integer id) throws DAOException;

    User retrieveUserByLogin(String login) throws DAOException;

    User retrieveUserByNameAndSurname(String name, String surname) throws DAOException;

    void addUser(User user) throws DAOException;

    void updateUser (User user) throws DAOException;

    void deleteUser(int id) throws DAOException;
}
