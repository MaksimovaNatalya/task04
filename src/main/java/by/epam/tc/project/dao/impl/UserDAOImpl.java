package by.epam.tc.project.dao.impl;

import by.epam.tc.project.dao.UserDAO;
import by.epam.tc.project.dao.builder.UserBuilder;
import by.epam.tc.project.dao.connectionpool.ConnectionPool;
import by.epam.tc.project.dao.connectionpool.ConnectionPoolException;
import by.epam.tc.project.dao.exception.DAOException;
import by.epam.tc.project.entity.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private final UserBuilder userBuilder = new UserBuilder();


    private static final String ID = "id";
    private static final String PASSWORD = "password";
    private static final String PASSWORD_SALT = "$2a$10$7Xtwz2dUaNW2055I9dhhv.";

    private final String AUTHORIZATION = "SELECT id, password FROM users WHERE login=?";
    private final String ADD_NEW_USER = "INSERT INTO users (login, password, name, surname, email, country, " +
            "phone, user_roles_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    private final String RETRIEVE_ALL_USERS = "SELECT * FROM users JOIN user_roles ON users.user_roles_id=user_roles.id";
    private final String RETRIEVE_USER_BY_ID = "SELECT * FROM users WHERE id = %d;";
    private final String RETRIEVE_USER_BY_LOGIN = "SELECT * FROM users WHERE login= ?";
    private final String UPDATE_USER = "UPDATE users SET login = ?, name = ?, surname = ?, email = ?, country = ?, " +
            "phone = ? WHERE login = ?";
    private final String DELETE_USER = "DELETE FROM users WHERE login = ?";

    @Override
    public User authorize(String login, String password) throws DAOException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User userFromBD = null;

        try {
            connection = connectionPool.takeConnection();
            ps = connection.prepareStatement(AUTHORIZATION);
            ps.setString(1, login);
            rs = ps.executeQuery();


            while (rs.next()) {
                String storedPassword = rs.getString(PASSWORD);
                if (BCrypt.checkpw(password, storedPassword)) {
                    userFromBD = retrieveUserById(rs.getInt(ID));
                }
            }

            return userFromBD;
        } catch (ConnectionPoolException e) {
            throw new DAOException("ConnectionPoolException in UserDAOImpl.authorization:", e);
        } catch (SQLException e) {
            throw new DAOException("SQLException in UserDAOImpl.authorization:", e);
        } finally {
            try {
                connectionPool.closeConnection(connection, ps, rs);
            } catch (ConnectionPoolException e) {
                throw new DAOException("ConnectionPoolException in UserDAOImpl.authorize", e);
            }

        }

    }

    @Override
    public void addUser(User user) throws DAOException {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionPool.takeConnection();
            ps = connection.prepareStatement(ADD_NEW_USER);

            ps.setString(1, user.getLogin());

            String salt = PASSWORD_SALT;
            String password_hash = BCrypt.hashpw(user.getPassword(), salt);

            ps.setString(2, password_hash);
            ps.setString(3, user.getName());
            ps.setString(4, user.getSurname());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getCountry());
            ps.setString(7, user.getPhone());
            ps.setInt(8, user.getRoleId());
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
    public void updateUserInfo(String newLogin, String name, String surname, String email, String country, String phone, String login) throws DAOException {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionPool.takeConnection();
            ps = connection.prepareStatement(UPDATE_USER);
            ps.setString(1, newLogin);
            ps.setString(2, name);
            ps.setString(3, surname);
            ps.setString(4, email);
            ps.setString(5, country);
            ps.setString(6, phone);
            ps.setString(7, login);

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
    public void deleteUser(String login) throws DAOException {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = connectionPool.takeConnection();
            ps = connection.prepareStatement(DELETE_USER);

            ps.setString(1, login);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e);
        } catch (ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            try {
                connectionPool.closeConnection(connection, ps);
            } catch (ConnectionPoolException e) {
                throw new DAOException("ConnectionPoolException in UserDAOImpl.deleteUser(String login)", e);
            }
        }
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
        User user;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = connectionPool.takeConnection();
            ps = connection.prepareStatement(RETRIEVE_USER_BY_LOGIN);
            ps.setString(1, login);
            rs = ps.executeQuery();


            rs.next();

            user = userBuilder.buildUser(rs);

        } catch (SQLException e) {
            throw new DAOException("SQLException in UserDAOImpl.retrieveUserByLogin()", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("ConnectionPoolException in UserDAOImpl.retrieveUserByLogin()", e);
        } finally {
            try {
                if (rs != null) {
                    connectionPool.closeConnection(connection, ps, rs);
                }

            } catch (ConnectionPoolException e) {
                throw new DAOException("ConnectionPoolException in UserDAOImpl.retrieveUserByLogin()", e);
            }
        }

        return user;
    }


}


