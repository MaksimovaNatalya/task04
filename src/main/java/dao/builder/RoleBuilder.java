package dao.builder;

import dao.exception.DAOException;
import entity.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

import static dao.column_name.Column.USER_ROLES_ROLE_NAME;

public class RoleBuilder {
    public Role buildRole(ResultSet resultSet) throws DAOException {
        try {
            return Role.valueOf(resultSet.getString(USER_ROLES_ROLE_NAME).toUpperCase());
        } catch (SQLException e) {
            throw new DAOException("Exception in RoleBuilder", e);
        }
    }
}
