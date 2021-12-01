package dao;

import dao.exception.DAOException;
import entity.User;

import java.sql.SQLException;
import java.util.Set;

public interface UserDAO {
    Set<User> retrieveAllUsers();
    User retrieveUserById(Integer id) throws SQLException, DAOException;
    User retrieveUserByLogin(String login);
    User retrieveUserByNameAndSurname (String name, String surname);
    void saveUser(User user) throws DAOException;
    void updateUser();
    void deleteUser();
}
