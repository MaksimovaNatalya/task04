package dao.impl;

import dao.UserDAO;
import dao.builder.UserBuilder;
import dao.database.ConnectionPool;
import dao.database.ConnectionPoolException;
import dao.exception.DAOException;
import entity.User;
import main.ConnectorDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDAOImpl implements UserDAO {
    private ConnectionPool connectionPool;
    private final UserBuilder userBuilder = new UserBuilder();

    private final String RETRIEVE_ALL_USERS = "SELECT * FROM users";
    private final String RETRIEVE_USER_BY_ID = "SELECT * FROM users WHERE id = %d;";
    private final String ADD_NEW_USER = "INSERT INTO users VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String DELETE_USER_BY_ID = "DELETE FROM users WHERE id=?";

    public UserDAOImpl() throws DAOException {
        try {
            if (connectionPool == null) {
                connectionPool = ConnectionPool.getInstance();
            }
        } catch (ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<User> retrieveAllUsers() throws DAOException {
        List<User> allUsers = new ArrayList<>();

        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            User user;
            connection = connectionPool.takeConnection();
            st = connection.createStatement();
            rs = st.executeQuery(RETRIEVE_ALL_USERS);

            while (rs.next()) {
                user = userBuilder.buildUser(rs);
                allUsers.add(user);

            }


        } catch (SQLException e) {
            throw new DAOException("SQLException in UserDAOImpl.retrieveAllUsers()", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("ConnectionPoolException in UserDAOImpl.retrieveAllUsers()", e);
        } finally {
            try {
                connectionPool.closeConnection(connection, st, rs);

            } catch (ConnectionPoolException e) {
                throw new DAOException("ConnectionPoolException in UserDAOImpl.retrieveAllUsers()", e);
            }
        }
        return allUsers;
    }


    @Override
    public User retrieveUserById(Integer id) throws DAOException {
        User user;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            connection = connectionPool.takeConnection();
            st = connection.createStatement();
            String sqlQuery = String.format(RETRIEVE_USER_BY_ID, id);
            rs = st.executeQuery(sqlQuery);
            rs.next();
            user = userBuilder.buildUser(rs);
        } catch (SQLException e) {
            throw new DAOException("SQLException in UserDAOImpl.retrieveUserById()", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("ConnectionPoolException in UserDAOImpl.retrieveUserById()", e);
        } finally {
            try {
                connectionPool.closeConnection(connection, st, rs);

            } catch (ConnectionPoolException e) {
                throw new DAOException("ConnectionPoolException in UserDAOImpl.retrieveUserById()", e);
            }
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
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionPool.takeConnection();
            ps = connection.prepareStatement(ADD_NEW_USER);
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
        } catch (ConnectionPoolException e) {
            throw new DAOException("ConnectionPoolException in UserDAOImpl.addUser(User user)", e);
        } finally {
            try {

                connectionPool.closeConnection(connection, ps);

            } catch (ConnectionPoolException e) {
                throw new DAOException("ConnectionPoolException in UserDAOImpl.addUser(User user)", e);
            }
        }

    }

    @Override
    public void updateUser(User user) throws DAOException {
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            connection = connectionPool.takeConnection();
            st = connection.createStatement();
            PreparedStatement ps = connection.prepareStatement("UPDATE user SET  name=?, country=? WHERE id=?");
            ps.setString(1, user.getName());
            ps.setString(2, user.getCountry());
            ps.setInt(3, user.getId());
            ps.executeUpdate();


        } catch (SQLException e) {
            throw new DAOException("SQLException in UserDAOImpl.updateUserByLogin (String login)", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("ConnectionPoolException in UserDAOImpl.updateUserByLogin (String login)", e);
        }
    }

    @Override
    public void deleteUser(int id) throws DAOException {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionPool.takeConnection();
            ps = connection.prepareStatement(DELETE_USER_BY_ID);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("SQLException in UserDAOImpl.deleteUser(int id)", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("ConnectionPoolException in UserDAOImpl.deleteUser(int id)", e);
        } finally {
            try {

                connectionPool.closeConnection(connection, ps);

            } catch (ConnectionPoolException e) {
                throw new DAOException("ConnectionPoolException in UserDAOImpl.deleteUser(int id)", e);
            }
        }
    }
}
