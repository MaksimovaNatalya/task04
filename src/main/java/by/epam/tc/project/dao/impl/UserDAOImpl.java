package by.epam.tc.project.dao.impl;

import by.epam.tc.project.dao.UserDAO;
import by.epam.tc.project.dao.builder.UserBuilder;
import by.epam.tc.project.dao.connectionpool.ConnectionPool;
import by.epam.tc.project.dao.connectionpool.ConnectionPoolException;
import by.epam.tc.project.dao.db.TableAndColumnName;
import by.epam.tc.project.dao.exception.DAOException;
import by.epam.tc.project.entity.Role;
import by.epam.tc.project.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

public class UserDAOImpl implements UserDAO {
    private ConnectionPool connectionPool;
    private final UserBuilder userBuilder = new UserBuilder();


    private static final String LOGIN = "login";
    private static final String ROLE = "role";
    private static final String PASSWORD = "password";

    private final String AUTHORIZATION = "SELECT * FROM users JOIN user_roles WHERE login=? AND password=?";
    private final String RETRIEVE_ALL_USERS = "SELECT * FROM users JOIN user_roles ON users.user_roles_id=user_roles.id";
    private final String RETRIEVE_ALL_ADMINS = "SELECT * FROM users JOIN user_roles ON users.user_roles_id=user_roles.id " +
            "WHERE user_roles.role-name=admin";
    private final String RETRIEVE_ALL_MANAGERS = "SELECT * FROM users JOIN user_roles ON users.user_roles_id=user_roles.id" +
            "WHERE user_roles.role-name=manager";
    private final String RETRIEVE_ALL_GUESTS = "SELECT * FROM users JOIN user_roles ON users.user_roles_id=user_roles.id" +
            "WHERE user_roles.role-name=guest";
    private final String RETRIEVE_USER_BY_ID = "SELECT * FROM users WHERE id = %d;";
    private final String ADD_NEW_USER = "INSERT INTO users VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String DELETE_USER_BY_ID = "DELETE FROM users WHERE id=?";

    @Override
    public User authorization (String login, String password) throws DAOException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User userFromBD = null;

        try {
            connection = connectionPool.takeConnection();
            ps = connection.prepareStatement(AUTHORIZATION);
            ps.setString(1, LOGIN);
            ps.setString(2, PASSWORD);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (BCrypt.checkpw(password, rs.getString(PASSWORD))) {
                    String roleName = rs.getString(TableAndColumnName.USER_ROLES_ROLE_NAME);
                    Role role = Role.valueOf(roleName.toUpperCase());
                    userFromBD = new User(LOGIN, role);
                }
            }
        } catch (ConnectionPoolException e) {
          throw new DAOException("ConnectionPoolException in UserDAOImpl.authorization:", e);
        } catch (SQLException e) {
          throw new DAOException("SQLException in UserDAOImpl.authorization:", e);
        } finally {
            try {
                connectionPool.closeConnection(connection,ps,rs);
            } catch (ConnectionPoolException e) {
                throw new DAOException("ConnectionPoolException in UserDAOImpl.authorization:", e);
            }
        }
        return userFromBD;
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
    public List<User> retrieveAllAdmins() throws DAOException {
        List<User> allAdmins = new ArrayList<>();

        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            User user;
            connection = connectionPool.takeConnection();
            st = connection.createStatement();
            rs = st.executeQuery(RETRIEVE_ALL_ADMINS);

            while (rs.next()) {
                user = userBuilder.buildUser(rs);
                allAdmins.add(user);

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
        return allAdmins;
    }

    @Override
    public List<User> retrieveAllManagers() throws DAOException {
        List<User> allManagers = new ArrayList<>();

        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            User user;
            connection = connectionPool.takeConnection();
            st = connection.createStatement();
            rs = st.executeQuery(RETRIEVE_ALL_MANAGERS);

            while (rs.next()) {
                user = userBuilder.buildUser(rs);
                allManagers.add(user);

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
        return allManagers;
    }

    @Override
    public List<User> retrieveAllGuests() throws DAOException {
        List<User> allGuests = new ArrayList<>();

        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            User user;
            connection = connectionPool.takeConnection();
            st = connection.createStatement();
            rs = st.executeQuery(RETRIEVE_ALL_GUESTS);

            while (rs.next()) {
                user = userBuilder.buildUser(rs);
                allGuests.add(user);

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
        return allGuests;
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
    public User retrieveUserByLogin(String login) throws DAOException {
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
            //      ps.setInt(9, user.getRole().getRoleId());
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
