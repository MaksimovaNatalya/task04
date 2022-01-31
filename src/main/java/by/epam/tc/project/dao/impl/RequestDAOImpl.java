package by.epam.tc.project.dao.impl;

import by.epam.tc.project.dao.RequestDAO;
import by.epam.tc.project.dao.builder.RequestBuilder;
import by.epam.tc.project.dao.builder.UserBuilder;
import by.epam.tc.project.dao.connectionpool.ConnectionPool;
import by.epam.tc.project.dao.connectionpool.ConnectionPoolException;
import by.epam.tc.project.dao.db.TableAndColumnName;
import by.epam.tc.project.dao.exception.DAOException;
import by.epam.tc.project.entity.Request;
import by.epam.tc.project.entity.Room;
import by.epam.tc.project.entity.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequestDAOImpl implements RequestDAO {
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private final RequestBuilder requestBuilder = new RequestBuilder();

    private final String RETRIEVE_REQUESTS_BY_LOGIN = "SELECT * FROM requests JOIN users ON requests.users_id=users.id WHERE login=?";
    private final String DELETE_REQUEST_BY_ID = "SELECT * FROM requests JOIN users ON requests.users_id=users.id WHERE login=?";
    private final String ADD_REQUEST = "INSERT INTO requests (category, max_persons, start_date, end_date, status, users_is, " +
            "rooms_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

    @Override
    public List<Request> retrieveRequestsByUserId(String login) throws DAOException {

        List<Request> allRequests = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            Request request;
            connection = connectionPool.takeConnection();

            ps = connection.prepareStatement(RETRIEVE_REQUESTS_BY_LOGIN);
            ps.setString(1, login);
            rs=ps.executeQuery();

            while (rs.next()) {
                request = requestBuilder.buildRequest(rs);
               allRequests.add(request);
            }
        } catch (ConnectionPoolException e) {
            throw new DAOException("ConnectionPoolException in RequestDAOImpl.retrieveRequestsByUserId:", e);
        } catch (SQLException e) {
            throw new DAOException("SQLException in RequestDAOImpl.retrieveRequestsByUserId:", e);
        } finally {
            try {
                connectionPool.closeConnection(connection, ps, rs);
            } catch (ConnectionPoolException e) {
                e.printStackTrace();
            }
        }
        return allRequests;
    }


    @Override
    public List<Request> retrieveAllRequests() throws DAOException {
        return null;
    }

    @Override
    public void deleteRequest(Integer id) throws DAOException {

    }

    @Override
    public List<Room> retrieveAllFreeRooms() throws DAOException {
        return null;
    }

    @Override
    public List<Room> retrieveFreeRoomsByMaxPersons() throws DAOException {
        return null;
    }

    @Override
    public List<Room> retrieveFreeRoomsByCategoryAndMaxPersons() throws DAOException {
        return null;
    }

    @Override
    public void addRequest(Request request) throws DAOException {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = connectionPool.takeConnection();
            if(true){
                throw new RuntimeException("IN DAO REQUEST");
            }
            ps = connection.prepareStatement(ADD_REQUEST);
            ps.setString(1, request.getCategory());
            ps.setInt(2, request.getMaxPersons());
            ps.setDate(3, request.getStartDate());
            ps.setDate(4, request.getEndDate());
            ps.setString(5, request.getStatus());
            ps.setInt(6, request.getUsersId());
            ps.setInt(7, request.getRoomsId());
            ps.executeUpdate();


        } catch (ConnectionPoolException e) {
            throw new DAOException("ConnectionPoolException in RequestDAOImpl.addRequest:", e);
        } catch (SQLException e) {
            throw new DAOException("SQLException in RequestDAOImpl.addRequest:", e);
        } finally {
            try {
                    connectionPool.closeConnection(connection, ps);
            } catch (ConnectionPoolException e) {
                e.printStackTrace();
            }
        }

    }

}

