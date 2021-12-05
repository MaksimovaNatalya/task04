package dao.builder;

import dao.column_name.Column;
import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBuilder {

    public User buildUser(ResultSet rs) throws SQLException {
//        rs.next();
//        int id = rs.getInt("id");
//        String login = rs.getString("login");
//        String password = rs.getString("password");
//        String name = rs.getString("name");
//        String surname = rs.getString("surname");
//        String eMail = rs.getString("e-mail");
//        String country = rs.getString("country");
//        String telNumber = rs.getString("telephone-number");
//        return new User (id,login, password,name,surname, eMail, country, telNumber);

        User user = new User();

        user.setId(rs.getInt(Column.USERS_ID));
        user.setLogin(rs.getString(Column.LOGIN));
        user.setPassword(rs.getString(Column.PASSWORD));
        user.setName(rs.getString(Column.NAME));
        user.setSurname(rs.getString(Column.SURNAME));
        user.setEMail(rs.getString(Column.E_MAIL));
        user.setCountry(rs.getString(Column.COUNTRY));
        user.setTelNumber(rs.getString(Column.TEL_NUMBER));

        return user;
    }
}
