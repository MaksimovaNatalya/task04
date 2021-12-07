package dao;

import dao.exception.DAOException;
import entity.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomDAO {
    List <Room> retrieveAllURooms() throws DAOException;
    Room retrieveRoomById(Integer id) throws DAOException;
    List<Room> retrieveRoomByCategoryAndMaxPersons(String category, Integer maxPersons) throws DAOException;
    List<Room> retrieveRoomByMaxPersonsWithBreakfast (Integer maxPersons, String breakfastIncluded) throws DAOException;
    List<Room> retrieveRoomByMaxPersonsWithSeaView (Integer maxPersons, String hasSeaView) throws DAOException;
    List<Room> retrieveRoomByMaxPersonsWithSeaViewAndBreakfast (Integer maxPersons, String hasSeaView, String breakfastIncluded)
            throws DAOException;
    void updateRoomById(Integer id) throws DAOException;
}
