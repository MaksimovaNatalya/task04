package dao.impl.builder;

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
        User user = new User();

        user.setId(rs.getInt("id"));
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
        user.setName(rs.getString("name"));
        user.setSurname(rs.getString("surname"));
        user.setEMail(rs.getString("e-mail"));
        user.setCountry(rs.getString("country"));
        user.setTelNumber(rs.getString("telephone-number"));

        return user;
  //      return new User (id,login, password,name,surname, eMail, country, telNumber);
    }
}
