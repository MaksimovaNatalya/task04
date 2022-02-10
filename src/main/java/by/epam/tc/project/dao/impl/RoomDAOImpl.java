package by.epam.tc.project.dao.impl;

import by.epam.tc.project.dao.RoomDAO;
import by.epam.tc.project.dao.builder.RoomBuilder;
import by.epam.tc.project.dao.connectionpool.ConnectionPool;
import by.epam.tc.project.dao.connectionpool.ConnectionPoolException;
import by.epam.tc.project.dao.exception.DAOException;
import by.epam.tc.project.entity.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    RoomBuilder roomBuilder = new RoomBuilder();

    private final String RETRIEVE_ALL_ROOMS = "SELECT * FROM rooms";
    private final String RETRIEVE_ROOM_BY_ID = "SELECT * FROM rooms WHERE id = %d";
    private final String RETRIEVE_ROOM_BY_CATEGORY_AND_MAX_PERSONS = "SELECT * FROM rooms WHERE category = %s AND max-persons = %s";
    private final String RETRIEVE_ROOMS_THAT_HAVE_REQUESTS = "SELECT * FROM rooms JOIN rooms_has_requests ON rooms.id=rooms_has_requests.rooms_id JOIN requests ON rooms_has_requests.requests_id=requests.id";
    private final String RETRIEVE_AVAILABLE_ROOMS = "SELECT * FROM rooms RO " +
            "JOIN requests RE ON RE.rooms_id = RO.id " +
            "WHERE RO.max_persons>=? " +
            "AND (RE.start_date NOT between ? AND ?) " +
            "AND (RE.end_date NOT between ? AND ?)";

    private final String RETRIEVE_MIN_LUX_PRICE = "SELECT MIN(price_per_night) FROM rooms WHERE category = 'lux'";
    private final String RETRIEVE_MIN_STANDARD_PRICE = "SELECT MIN(price_per_night) FROM rooms WHERE category = 'standard'";
    private final String RETRIEVE_MIN_ECONOMY_PRICE = "SELECT MIN(price_per_night) FROM rooms WHERE category = 'economy'";

    @Override
    public List<Room> retrieveAllRooms() throws DAOException {
        List<Room> allRooms = new ArrayList<>();

        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Room room;
            connection = connectionPool.takeConnection();
            st = connection.createStatement();
            rs = st.executeQuery(RETRIEVE_ALL_ROOMS);

            while (rs.next()) {
                room = roomBuilder.buildRoom(rs);
                allRooms.add(room);
            }

        } catch (SQLException e) {
            throw new DAOException("SQLException in RoomDAOImpl.retrieveAllRooms()", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("ConnectionPoolException in RoomDAOImpl.retrieveAllRooms()", e);
        } finally {
            try {
                connectionPool.closeConnection(connection, st, rs);
            } catch (ConnectionPoolException e) {
                throw new DAOException("ConnectionPoolException in RoomDAOImpl.retrieveAllRooms()", e);
            }
        }
        return allRooms;
    }


    @Override
    public List<Room> retrieveAvailableRoomsForDate(java.sql.Date startDate, Date endDate, int maxPersons) throws DAOException {
        List<Room> availableRooms = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            Room room;
            connection = connectionPool.takeConnection();
            ps = connection.prepareStatement(RETRIEVE_AVAILABLE_ROOMS);

            ps.setInt(1, maxPersons);
            ps.setDate(2, startDate);
            ps.setDate(3, endDate);
            ps.setDate(4, startDate);
            ps.setDate(5, endDate);

            rs = ps.executeQuery();

            while (rs.next()) {

                room = roomBuilder.buildRoom(rs);

                availableRooms.add(room);
            }

        } catch (SQLException e) {
            throw new DAOException("SQLException in RoomDAOImpl.retrieveAllRoomsThatHaveRequests()", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("ConnectionPoolException in RoomDAOImpl.retrieveAllRoomsThatHaveRequests()", e);
        } finally {
            try {
                if (rs != null) {
                    connectionPool.closeConnection(connection, ps, rs);
                }
            } catch (ConnectionPoolException e) {
                throw new DAOException("ConnectionPoolException in RoomDAOImpl.retrieveAllRoomsThatHaveRequests()", e);
            }
        }
        return availableRooms;
    }


    @Override
    public int retrieveMinLuxPrice() throws DAOException {
        int luxPrice;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            connection = connectionPool.takeConnection();
            st = connection.createStatement();
            String sqlQuery = String.format(RETRIEVE_MIN_LUX_PRICE);
            rs = st.executeQuery(sqlQuery);

            luxPrice = rs.getInt("price_per_night");
        } catch (SQLException e) {
            throw new DAOException("SQLException in RoomDAOImpl.retrieveAllRoomsThatHaveRequests()", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("ConnectionPoolException in RoomDAOImpl.retrieveAllRoomsThatHaveRequests()", e);
        } finally {
            try {
                if (rs != null) {
                    connectionPool.closeConnection(connection, st, rs);
                }
            } catch (ConnectionPoolException e) {
                throw new DAOException("ConnectionPoolException in RoomDAOImpl.retrieveAllRoomsThatHaveRequests()", e);
            }
        }
        return luxPrice;
    }

    @Override
    public int retrieveMinStandPrice() throws DAOException {
        int standardPrice;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            connection = connectionPool.takeConnection();
            st = connection.createStatement();
            String sqlQuery = String.format(RETRIEVE_MIN_STANDARD_PRICE);
            rs = st.executeQuery(sqlQuery);
            standardPrice = Integer.parseInt(rs.toString());
        } catch (SQLException e) {
            throw new DAOException("SQLException in RoomDAOImpl.retrieveAllRoomsThatHaveRequests()", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("ConnectionPoolException in RoomDAOImpl.retrieveAllRoomsThatHaveRequests()", e);
        } finally {
            try {
                if (rs != null) {
                    connectionPool.closeConnection(connection, st, rs);
                }
            } catch (ConnectionPoolException e) {
                throw new DAOException("ConnectionPoolException in RoomDAOImpl.retrieveAllRoomsThatHaveRequests()", e);
            }
        }
        return standardPrice;
    }

    @Override
    public int retrieveMinEconPrice() throws DAOException {
        int economyPrice;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            connection = connectionPool.takeConnection();
            st = connection.createStatement();
            String sqlQuery = String.format(RETRIEVE_MIN_ECONOMY_PRICE);
            rs = st.executeQuery(sqlQuery);
            economyPrice = Integer.parseInt(rs.toString());
        } catch (SQLException e) {
            throw new DAOException("SQLException in RoomDAOImpl.retrieveAllRoomsThatHaveRequests()", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("ConnectionPoolException in RoomDAOImpl.retrieveAllRoomsThatHaveRequests()", e);
        } finally {
            try {
                if (rs != null) {
                    connectionPool.closeConnection(connection, st, rs);
                }
            } catch (ConnectionPoolException e) {
                throw new DAOException("ConnectionPoolException in RoomDAOImpl.retrieveAllRoomsThatHaveRequests()", e);
            }
        }
        return economyPrice;
    }
}
