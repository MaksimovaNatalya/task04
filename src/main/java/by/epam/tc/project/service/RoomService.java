package by.epam.tc.project.service;

import by.epam.tc.project.entity.Room;
import by.epam.tc.project.service.exception.ServiceException;

import java.sql.Date;
import java.util.List;

public interface RoomService {
    /**
     * Retrieve avalable room for such dates and number of guests
     * @param startDate is a check-in date
     * @param endDate is a check-out date
     * @param maxPersons is a number of guests
     * @return a list of available rooms
     * @throws ServiceException if there are no available rooms
     */
    List<Room> findAvailableRooms(java.sql.Date startDate, Date endDate, int maxPersons) throws ServiceException;

    /**
     * Retrieve all rooms
     * @return a list of all rooms
     */
    List<Room> showAllRooms() throws ServiceException;

    /**
     * Retrieve minimum price of an Economy room
     */
    int retrieveMinEconPrice() throws ServiceException;

    /**
     * Retrieve minimum price of a Standard room
     */
    int retrieveMinStandPrice() throws ServiceException;

    /**
     * Retrieve minimum price of a Lux room
     */
    int retrieveMinLuxPrice() throws ServiceException;
}
