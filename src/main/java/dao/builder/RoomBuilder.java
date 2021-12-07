package dao.builder;

import dao.column_name.Column;
import dao.exception.DAOException;
import entity.Room;
import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomBuilder {
    public Room buildRoom (ResultSet rs) throws DAOException {

        Room room = new Room();

        try {
            room.setId(rs.getInt(Column.ROOM_ID));
            room.setMaxPersons(rs.getInt(Column.ROOM_MAX_PERSONS));
            room.setCategory(rs.getString(Column.ROOM_CATEGORY));
            room.setPricePerNight(rs.getInt(Column.ROOM_PRICE_PER_NIGHT));
            room.setHasSeaView(rs.getString(Column.ROOM_HAS_SEA_VIEW));
            room.setBreakfastIncluded(rs.getString(Column.ROOM_BREAKFAST_INCLUDED));
            room.setImage(rs.getString(Column.ROOM_IMAGE));

        } catch (SQLException e) {
            throw new DAOException("SQLException in RoomBuilder.buildRoom (ResultSet rs)"+e);
        }

        return room;
    }
}
