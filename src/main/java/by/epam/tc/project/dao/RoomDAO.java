package by.epam.tc.project.dao;

import by.epam.tc.project.dao.exception.DAOException;
import by.epam.tc.project.entity.Room;

import java.util.List;

public interface RoomDAO {
    List<Room> retrieveAllURooms() throws DAOException;

    Room retrieveRoomById(Integer id) throws DAOException;

    List<Room> retrieveRoomByCategoryAndMaxPersons(String category, Integer maxPersons) throws DAOException;

    List<Room> retrieveRoomByMaxPersonsWithBreakfast(Integer maxPersons, String breakfastIncluded) throws DAOException;

    List<Room> retrieveRoomByMaxPersonsWithSeaView(Integer maxPersons, String hasSeaView) throws DAOException;

    List<Room> retrieveRoomByMaxPersonsWithSeaViewAndBreakfast(Integer maxPersons, String hasSeaView, String breakfastIncluded)
            throws DAOException;

    void updateRoomById(Integer id) throws DAOException;

    List<Room> retrieveAllRoomsThatHaveRequests () throws DAOException;
}
