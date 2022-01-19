package by.epam.tc.project.dao.builder;

import by.epam.tc.project.dao.exception.DAOException;
import by.epam.tc.project.entity.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

import static by.epam.tc.project.dao.db.TableAndColumnName.USER_ROLES_ROLE_NAME;

public class RoleBuilder {
    public Role buildRole(ResultSet resultSet) throws DAOException {
        try {
            return Role.valueOf(resultSet.getString(USER_ROLES_ROLE_NAME).toUpperCase());
        } catch (SQLException e) {
            throw new DAOException("Exception in RoleBuilder", e);
        }
    }
}
