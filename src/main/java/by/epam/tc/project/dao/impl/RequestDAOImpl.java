package by.epam.tc.project.dao.impl;

import by.epam.tc.project.dao.RequestDAO;
import by.epam.tc.project.dao.builder.RequestBuilder;
import by.epam.tc.project.dao.connectionpool.ConnectionPool;
import by.epam.tc.project.dao.connectionpool.ConnectionPoolException;
import by.epam.tc.project.dao.exception.DAOException;
import by.epam.tc.project.entity.Request;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDAOImpl implements RequestDAO {
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private final RequestBuilder requestBuilder = new RequestBuilder();

    private final String RETRIEVE_ALL_REQUESTS = "SELECT * FROM requests order by status DESC";
    private final String RETRIEVE_REQUESTS_BY_LOGIN = "SELECT * FROM requests JOIN users ON requests.users_id=users.id WHERE login=? ORDER BY start_date";
    private final String DELETE_REQUEST_BY_ID = "UPDATE requests SET status = ? WHERE id=?";
    private final String ADD_REQUEST = "INSERT INTO requests (category, max_persons, start_date, end_date, status, users_id, " +
            "rooms_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String APPROVE_REQUEST = "UPDATE requests SET status = ? WHERE id = ?";
    private final String DECLINE_REQUEST = "UPDATE requests SET status = ? WHERE id = ?";

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
            rs = ps.executeQuery();

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
        List<Request> allRequests = new ArrayList<>();

        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Request request;
            connection = connectionPool.takeConnection();
            st = connection.createStatement();
            rs = st.executeQuery(RETRIEVE_ALL_REQUESTS);

            while (rs.next()) {
                request = requestBuilder.buildRequest(rs);
                allRequests.add(request);
            }
        } catch (SQLException e) {
            throw new DAOException("SQLException in RequestDAOImpl.retrieveAllRequests()", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("ConnectionPoolException in RequestDAOImpl.retrieveAllRequests()", e);
        } finally {
            try {
                connectionPool.closeConnection(connection, st, rs);
            } catch (ConnectionPoolException e) {
                throw new DAOException("ConnectionPoolException in RequestDAOImpl.retrieveAllRequests()", e);
            }
        }
        return allRequests;
    }


    @Override
    public void addRequest(Request request) throws DAOException {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = connectionPool.takeConnection();
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
                throw new DAOException("ConnectionPoolException in RequestDAOImpl.addRequest:", e);
            }
        }

    }

    @Override
    public void approveRequest(int requestId) throws DAOException {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = connectionPool.takeConnection();
            ps = connection.prepareStatement(APPROVE_REQUEST);
            ps.setString(1, "approved");
            ps.setInt(2, requestId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("SQLException in RequestDAOImpl.approveRequest:", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("ConnectionPoolException in RequestDAOImpl.approveRequest:", e);
        } finally {
            try {
                connectionPool.closeConnection(connection, ps);
            } catch (ConnectionPoolException e) {
                throw new DAOException("ConnectionPoolException in RequestDAOImpl.addRequest:", e);
            }
        }
    }

    @Override
    public void declineRequest(int id) throws DAOException {

        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = connectionPool.takeConnection();
            ps = connection.prepareStatement(DECLINE_REQUEST);
            ps.setString(1, "declined");
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("SQLException in RequestDAOImpl.approveRequest:", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("ConnectionPoolException in RequestDAOImpl.approveRequest:", e);
        } finally {
            try {
                connectionPool.closeConnection(connection, ps);
            } catch (ConnectionPoolException e) {
                throw new DAOException("ConnectionPoolException in RequestDAOImpl.addRequest:", e);
            }
        }
    }

    @Override
    public void cancelBooking(int id) throws DAOException {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = connectionPool.takeConnection();
            ps = connection.prepareStatement(DELETE_REQUEST_BY_ID);
            ps.setString(1, "cancelled");
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("SQLException in RequestDAOImpl.approveRequest:", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("ConnectionPoolException in RequestDAOImpl.approveRequest:", e);
        } finally {
            try {
                connectionPool.closeConnection(connection, ps);
            } catch (ConnectionPoolException e) {
                throw new DAOException("ConnectionPoolException in RequestDAOImpl.addRequest:", e);
            }
        }
    }
}

