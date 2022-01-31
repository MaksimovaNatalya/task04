package by.epam.tc.project.dao.builder;

import by.epam.tc.project.dao.db.TableAndColumnName;
import by.epam.tc.project.dao.exception.DAOException;
import by.epam.tc.project.entity.Room;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomBuilder {
    public Room buildRoom(ResultSet rs) throws DAOException {

        Room room = new Room();

        try {

            room.setId(rs.getInt(TableAndColumnName.ROOM_ID));
            room.setMaxPersons(rs.getInt(TableAndColumnName.ROOM_MAX_PERSONS));
            room.setCategory(rs.getString(TableAndColumnName.ROOM_CATEGORY));
            room.setPricePerNight(rs.getInt(TableAndColumnName.ROOM_PRICE_PER_NIGHT));
            room.setSeaview(rs.getString(TableAndColumnName.ROOM_HAS_SEA_VIEW));
            room.setBreakfast(rs.getString(TableAndColumnName.ROOM_BREAKFAST_INCLUDED));
            room.setImage(rs.getString(TableAndColumnName.ROOM_IMAGE));

        } catch (SQLException e) {
            throw new DAOException("SQLException in RoomBuilder.buildRoom (ResultSet rs)" + e);
        }

        return room;
    }
}
