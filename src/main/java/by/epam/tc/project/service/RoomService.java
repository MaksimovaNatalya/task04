package by.epam.tc.project.service;

import by.epam.tc.project.entity.Room;
import by.epam.tc.project.service.exception.ServiceException;

import java.sql.Date;
import java.util.List;

public interface RoomService {
    List<Room> findAvailableRooms(java.sql.Date startDate, Date endDate, int maxPersons) throws ServiceException;

    List<Room> showAllRooms() throws ServiceException;

    int retrieveMinEconPrice() throws ServiceException;

    int retrieveMinStandPrice() throws ServiceException;

    int retrieveMinLuxPrice() throws ServiceException;
}
