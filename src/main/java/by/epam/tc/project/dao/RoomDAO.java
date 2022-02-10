package by.epam.tc.project.dao;

import by.epam.tc.project.dao.exception.DAOException;
import by.epam.tc.project.entity.Room;

import java.sql.Date;
import java.util.List;

public interface RoomDAO {
    /**
     * Retrieve all rooms
     * @return a list of all rooms
     */
    List<Room> retrieveAllRooms() throws DAOException;

    /**
     * Retrieve avalable room for such dates and number of guests
     * @param startDate is a check-in date
     * @param endDate is a check-out date
     * @param maxPersons is a number of guests
     * @return a list of available rooms
     * @throws DAOException if there are no available rooms
     */
    List<Room> retrieveAvailableRoomsForDate(java.sql.Date startDate, Date endDate, int maxPersons) throws DAOException;

    /**
     * Retrieve minimum price of a Lux room
     */
    int retrieveMinLuxPrice() throws DAOException;

    /**
     * Retrieve minimum price of a Standard room
     */
    int retrieveMinStandPrice() throws DAOException;

    /**
     * Retrieve minimum price of an Economy room
     */
    int retrieveMinEconPrice() throws DAOException;
}
