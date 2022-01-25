package by.epam.tc.project.service;

import by.epam.tc.project.entity.Room;
import by.epam.tc.project.service.exception.ServiceException;

import java.util.Date;
import java.util.List;

public interface RoomService {
    List<Room> findAvailableRooms(Date startDate, Date endDate, int maxPersons) throws ServiceException;
    List<Room> showAllRooms() throws ServiceException;


}
