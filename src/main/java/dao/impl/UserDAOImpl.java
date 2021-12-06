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

    private final String RETRIEVE_ALL_USERS = "SELECT * FROM users";
    private final String RETRIEVE_USER_BY_ID = "SELECT * FROM users WHERE id = %d;";
    private final String ADD_NEW_USER = "INSERT INTO users VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String DELETE_USER_BY_ID = "DELETE FROM users WHERE id=?";


    @Override
    public Set<User> retrieveAllUsers() throws DAOException {
        Set<User> allUsers = new HashSet<>();
        try {
            User user;
            Connection connection = ConnectorDB.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(RETRIEVE_ALL_USERS);

            while (rs.next()) {
                user = userBuilder.buildUser(rs);
                allUsers.add(user);
            }


        } catch (SQLException e) {
            throw new DAOException("SQLException in UserDAOImpl.retrieveAllUsers()", e);
        }
        return allUsers;
    }


    @Override
    public User retrieveUserById(Integer id) throws DAOException {
        User user;
        try {
            Connection connection = ConnectorDB.getConnection();
            Statement st = connection.createStatement();
            String sqlQuery = String.format(RETRIEVE_USER_BY_ID, id);
            ResultSet resultSet = st.executeQuery(sqlQuery);
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
            PreparedStatement ps = connection.prepareStatement(ADD_NEW_USER);
            ps.setInt(1, user.getId());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getName());
            ps.setString(5, user.getSurname());
            ps.setString(6, user.getEMail());
            ps.setString(7, user.getCountry());
            ps.setString(8, user.getTelNumber());
            ps.setInt(9, user.getRole().getRoleId());
            ps.executeUpdate();


        } catch (SQLException e) {
            throw new DAOException("SQLException in UserDAOImpl.addUser(User user)", e);
        }

    }

    @Override
    public void updateUser(User user) throws DAOException {
        try {
            Connection connection = ConnectorDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE user SET  name=?, country=? WHERE id=?");
            ps.setString(1, user.getName());
            ps.setString(2, user.getCountry());
            ps.setInt(3, user.getId());
            ps.executeUpdate();


        } catch (SQLException e) {
            throw new DAOException("SQLException in UserDAOImpl.updateUser(User user)", e);
        }
    }

    @Override
    public void deleteUser(int id) throws DAOException {
        try {
            Connection connection = ConnectorDB.getConnection();
            PreparedStatement ps = connection.prepareStatement(DELETE_USER_BY_ID);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("SQLException in UserDAOImpl.deleteUser(int id)", e);
        }
    }
}
