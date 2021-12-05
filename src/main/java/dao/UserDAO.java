package dao;

import dao.exception.DAOException;
import entity.User;

import java.sql.SQLException;
import java.util.Set;

public interface UserDAO {
    Set<User> retrieveAllUsers() throws DAOException;
    User retrieveUserById(Integer id) throws SQLException, DAOException;
    User retrieveUserByLogin(String login) throws DAOException;
    User retrieveUserByNameAndSurname (String name, String surname) throws DAOException;
    void addUser (User user) throws DAOException;
    void updateUser() throws DAOException;
    void deleteUser() throws DAOException;
}
