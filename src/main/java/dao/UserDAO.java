package dao;

import entity.User;

import java.sql.SQLException;
import java.util.Set;

public interface UserDAO {
    Set<User> retrieveAllUsers();
    User retrieveUserById(Integer id) throws SQLException;
    User retrieveUserByLogin(String login);
    User retrieveUserByNameAndSurname (String name, String surname);
    void saveUser();
    void updateUser();
    void deleteUser();
}
