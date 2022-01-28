package by.epam.tc.project.service.impl;

import by.epam.tc.project.dao.DAOProvider;
import by.epam.tc.project.dao.RoomDAO;
import by.epam.tc.project.dao.UserDAO;
import by.epam.tc.project.dao.exception.DAOException;
import by.epam.tc.project.entity.Room;
import by.epam.tc.project.service.RoomService;
import by.epam.tc.project.service.exception.ServiceException;

import java.sql.Date;
import java.util.List;

public class RoomServiceImpl implements RoomService {
    private static final DAOProvider provider = DAOProvider.getInstance();
    private static final RoomDAO roomDAO = provider.getRoomDAO();
    @Override
    public List<Room> findAvailableRooms(java.sql.Date startDate, Date endDate, int maxPersons) throws ServiceException {
        try {
            roomDAO.retrieveAvailableRoomsForDate(startDate,endDate, maxPersons);
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return null;
    }

    @Override
    public List<Room> showAllRooms() throws ServiceException {

        try {
            return  roomDAO.retrieveAllRooms();
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }
}
