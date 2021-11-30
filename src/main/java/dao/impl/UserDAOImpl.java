package dao.impl;

import dao.UserDAO;
import dao.impl.builder.UserBuilder;
import entity.User;
import main.ConnectorDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class UserDAOImpl implements UserDAO {
    @Override
    public Set<User> retrieveAllUsers() {
        Set allUsers = new HashSet<User>();
        try {
            User user;
            Connection connection = ConnectorDB.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users");

            while (rs.next()){
                user = userBuilder.buildUser(rs);
                allUsers.add(user);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    private final UserBuilder userBuilder = new UserBuilder();

    @Override
    public User retrieveUserById(Integer id) throws SQLException {
        User user;
        try {
            Connection connection = ConnectorDB.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users WHERE id=" + id);

            user = userBuilder.buildUser(rs);

        } catch (SQLException    e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User retrieveUserByLogin(String login) {
        return null;
    }

    @Override
    public User retrieveUserByNameAndSurname(String name, String surname) {
        return null;
    }

    @Override
    public void saveUser() {

    }

    @Override
    public void updateUser() {

    }

    @Override
    public void deleteUser() {

    }
}
