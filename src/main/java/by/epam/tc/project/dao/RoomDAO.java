package by.epam.tc.project.dao;

import by.epam.tc.project.dao.exception.DAOException;
import by.epam.tc.project.entity.Room;

import java.sql.Date;
import java.util.List;

public interface RoomDAO {
    List<Room> retrieveAllRooms() throws DAOException;

    List<Room> retrieveAvailableRoomsForDate(java.sql.Date startDate, Date endDate, int maxPersons) throws DAOException;

    List<Room> retrieveAllRoomsThatHaveRequests () throws DAOException;

    int retrieveMinLuxPrice() throws DAOException;

    int retrieveMinStandPrice() throws DAOException;

    int retrieveMinEconPrice() throws DAOException;
}
