package dao.builder;

import dao.column_name.Column;
import dao.exception.DAOException;
import entity.Role;
import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBuilder {

    public User buildUser(ResultSet rs) throws DAOException {

        User user = new User();
RoleBuilder roleBuilder = new RoleBuilder();
        try {
            user.setId(rs.getInt(Column.USERS_ID));
            user.setLogin(rs.getString(Column.LOGIN));
            user.setPassword(rs.getString(Column.PASSWORD));
            user.setName(rs.getString(Column.NAME));
            user.setSurname(rs.getString(Column.SURNAME));
            user.setEMail(rs.getString(Column.E_MAIL));
            user.setCountry(rs.getString(Column.COUNTRY));
            user.setTelNumber(rs.getString(Column.TEL_NUMBER));
            user.setRoleId(
                    roleBuilder.buildRole(rs));

        } catch (SQLException e) {
            throw new DAOException("SQLException in UserBuilder.buildUser(ResultSet rs)"+e);
        }


        return user;
    }
}
