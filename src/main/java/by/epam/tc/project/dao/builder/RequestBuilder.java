package by.epam.tc.project.dao.builder;

import by.epam.tc.project.dao.db.TableAndColumnName;
import by.epam.tc.project.dao.exception.DAOException;
import by.epam.tc.project.entity.Request;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestBuilder {
    public Request buildRequest (ResultSet rs) throws DAOException {

        Request request = new Request();

        try {
            request.setId(rs.getInt(TableAndColumnName.REQUEST_ID));
            request.setCategory(rs.getString(TableAndColumnName.REQUEST_ROOM_CATEGORY));
            request.setMaxPersons(rs.getInt(TableAndColumnName.REQUEST_MAX_PERSONS));
            request.setStartDate(rs.getDate(TableAndColumnName.REQUEST_START_DATE));
            request.setEndDate(rs.getDate(TableAndColumnName.REQUEST_END_DATE));
            request.setStatus(rs.getString(TableAndColumnName.REQUEST_STATUS));
            request.setUsersId(rs.getInt(TableAndColumnName.REQUEST_USER_ID));
            request.setRoomsId(rs.getInt(TableAndColumnName.REQUEST_ROOM_ID));

        } catch (SQLException e) {
            throw new DAOException("SQLException in RequestBuilder.buildRequest (ResultSet rs)"+e);
        }

        return request;
    }
}
