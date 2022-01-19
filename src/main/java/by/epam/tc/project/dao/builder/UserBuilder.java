package by.epam.tc.project.dao.builder;

import by.epam.tc.project.dao.db.TableAndColumnName;
import by.epam.tc.project.dao.exception.DAOException;
import by.epam.tc.project.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBuilder {

    public User buildUser(ResultSet rs) throws DAOException {

        User user = new User();
RoleBuilder roleBuilder = new RoleBuilder();
        try {
            user.setId(rs.getInt(TableAndColumnName.USERS_ID));
            user.setLogin(rs.getString(TableAndColumnName.LOGIN));
            user.setPassword(rs.getString(TableAndColumnName.PASSWORD));
            user.setName(rs.getString(TableAndColumnName.NAME));
            user.setSurname(rs.getString(TableAndColumnName.SURNAME));
            user.setEMail(rs.getString(TableAndColumnName.E_MAIL));
            user.setCountry(rs.getString(TableAndColumnName.COUNTRY));
            user.setTelNumber(rs.getString(TableAndColumnName.TEL_NUMBER));
      //      user.setRoleId(
        //            roleBuilder.buildRole(rs));

        } catch (SQLException e) {
            throw new DAOException("SQLException in UserBuilder.buildUser(ResultSet rs)"+e);
        }


        return user;
    }
}
