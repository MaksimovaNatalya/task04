package by.epam.tc.project.dao.builder;

import by.epam.tc.project.dao.db.TableAndColumnName;
import by.epam.tc.project.dao.exception.DAOException;
import by.epam.tc.project.entity.Request;
import by.epam.tc.project.entity.Room;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestBuilder {
    public Request buildRequest (ResultSet rs) throws DAOException {

        Request request = new Request();

        try {
            request.setId(rs.getInt(TableAndColumnName.REQUEST_ID));
            request.setCategory(rs.getString(TableAndColumnName.REQUEST_ROOM_CATEGORY));
            request.setMax_persons(rs.getInt(TableAndColumnName.REQUEST_MAX_PERSONS));
            request.setStart_date(rs.getDate(TableAndColumnName.REQUEST_START_DATE));
            request.setEnd_date(rs.getDate(TableAndColumnName.REQUEST_END_DATE));
            request.setStatus(rs.getString(TableAndColumnName.REQUEST_STATUS));
            request.setUsers_id(rs.getString(TableAndColumnName.REQUEST_USER_ID));

        } catch (SQLException e) {
            throw new DAOException("SQLException in RequestBuilder.buildRequest (ResultSet rs)"+e);
        }

        return request;
    }
}
