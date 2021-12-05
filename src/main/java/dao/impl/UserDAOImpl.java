package dao.impl;

import dao.UserDAO;
import dao.exception.DAOException;
import dao.builder.UserBuilder;
import entity.User;
import main.ConnectorDB;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class UserDAOImpl implements UserDAO {

    private final UserBuilder userBuilder = new UserBuilder();

    @Override
    public Set<User> retrieveAllUsers() {
        Set<User> allUsers = new HashSet<>();
        try {
            User user;
            Connection connection = ConnectorDB.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                user = userBuilder.buildUser(rs);
                allUsers.add(user);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUsers;
    }


    @Override
    public User retrieveUserById(Integer id) throws DAOException {
        User user;
        try {
            Connection connection = ConnectorDB.getConnection();
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM users WHERE id = " + id);

            resultSet.next();
            user = userBuilder.buildUser(resultSet);

        } catch (SQLException e) {
            throw new DAOException("SQLException in UserDAOImpl.retrieveUserById()", e);
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
    public void addUser(User user) throws DAOException {

        try {
            Connection connection = ConnectorDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO users VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, user.getId());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getName());
            ps.setString(5, user.getSurname());
            ps.setString(6, user.getEMail());
            ps.setString(7, user.getCountry());
            ps.setString(8, user.getTelNumber());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("SQLException in UserDAOImpl.retrieveUserById()", e);
        }

    }

    @Override
    public void updateUser() {

    }

    @Override
    public void deleteUser() {

    }
}
