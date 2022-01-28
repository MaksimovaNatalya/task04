package by.epam.tc.project.dao.impl;

import by.epam.tc.project.dao.connectionpool.ConnectionPoolException;
import by.epam.tc.project.dao.RoomDAO;
import by.epam.tc.project.dao.builder.RoomBuilder;
import by.epam.tc.project.dao.connectionpool.ConnectionPool;
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
    private final String RETRIEVE_ROOM_BY_MAXPERSONS_WITH_BREAKFAST = "SELECT * FROM rooms WHERE breakfast-included = %s AND max-persons = %s";
    private final String RETRIEVE_ROOM_BY_MAXPERSONS_WITH_SEAVIEW = "SELECT * FROM rooms WHERE has-sea-view = %s AND max-persons = %s";
    private final String RETRIEVE_ROOM_BY_MAXPERSONS_WITH_SEAVIEW_AND_BREAKFAST = "SELECT * FROM rooms WHERE has-sea-view = %s AND breakfast-included = %s AND max-persons = %s";
    private final String RETRIEVE_ROOMS_THAT_HAVE_REQUESTS = "SELECT * FROM rooms JOIN rooms_has_requests ON rooms.id=rooms_has_requests.rooms_id JOIN requests ON rooms_has_requests.requests_id=requests.id";
    private final String RETRIEVE_AVAILABLE_ROOMS_FOR_DATE = "SELECT rooms.* FROM rooms JOIN (SELECT * FROM requests WHERE " +
            "?<=requests.end_date AND ?>=requests.start_date) z ON rooms.id=z.room_id WHERE z.room_id IS NULL AND max_persons=?";

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
    public Room retrieveRoomById(Integer id) throws DAOException {
        Room room;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            connection = connectionPool.takeConnection();
            st = connection.createStatement();
            String sqlQuery = String.format(RETRIEVE_ROOM_BY_ID, id);
            rs = st.executeQuery(sqlQuery);
            rs.next();
            room = roomBuilder.buildRoom(rs);
        } catch (SQLException e) {
            throw new DAOException("SQLException in RoomDAOImpl.retrieveRoomById(Integer id)", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("ConnectionPoolException in RoomDAOImpl.retrieveRoomById(Integer id)", e);
        } finally {
            try {
                connectionPool.closeConnection(connection, st, rs);
            } catch (ConnectionPoolException e) {
                throw new DAOException("ConnectionPoolException in RoomDAOImpl.retrieveRoomById(Integer id)", e);
            }
        }

        return room;
    }

    @Override
    public List<Room> retrieveRoomByCategoryAndMaxPersons(String category, Integer maxPersons) throws DAOException {
        List<Room> allRooms = new ArrayList<>();
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Room room;
            connection = connectionPool.takeConnection();
            st = connection.createStatement();
            String sqlQuery = String.format(RETRIEVE_ROOM_BY_CATEGORY_AND_MAX_PERSONS, category, maxPersons);
            rs = st.executeQuery(sqlQuery);
            while (rs.next()) {
                room = roomBuilder.buildRoom(rs);
                allRooms.add(room);
            }
        } catch (SQLException e) {
            throw new DAOException("SQLException in RoomDAOImpl.retrieveRoomById(Integer id)", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("ConnectionPoolException in RoomDAOImpl.retrieveRoomById(Integer id)", e);
        } finally {
            try {
                connectionPool.closeConnection(connection, st, rs);
            } catch (ConnectionPoolException e) {
                throw new DAOException("ConnectionPoolException in RoomDAOImpl.retrieveRoomById(Integer id)", e);
            }
        }

        return allRooms;
    }

    @Override
    public List<Room> retrieveRoomByMaxPersonsWithBreakfast(Integer maxPersons, String breakfastIncluded) throws DAOException {
        return null;
    }

    @Override
    public List<Room> retrieveRoomByMaxPersonsWithSeaView(Integer maxPersons, String hasSeaView) throws DAOException {
        return null;
    }

    @Override
    public List<Room> retrieveRoomByMaxPersonsWithSeaViewAndBreakfast(Integer maxPersons, String hasSeaView, String breakfastIncluded) throws DAOException {
        return null;
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
            ps = connection.prepareStatement(RETRIEVE_AVAILABLE_ROOMS_FOR_DATE);
          ps.setDate(1,  startDate);
          ps.setDate(2,  endDate);
          ps.setInt(3,  maxPersons);

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
    public void updateRoomById(Integer id) throws DAOException {

    }

    @Override
    public List<Room> retrieveAllRoomsThatHaveRequests() throws DAOException {

        List<Room> allRooms = new ArrayList<>();
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Room room;
            connection = connectionPool.takeConnection();
            st = connection.createStatement();
            String sqlQuery = String.format(RETRIEVE_ROOMS_THAT_HAVE_REQUESTS);
            rs = st.executeQuery(sqlQuery);
            while (rs.next()) {
                room = roomBuilder.buildRoom(rs);
                allRooms.add(room);
            }
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
        return allRooms;
    }
}
