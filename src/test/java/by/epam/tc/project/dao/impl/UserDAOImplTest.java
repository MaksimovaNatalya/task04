package by.epam.tc.project.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import by.epam.tc.project.dao.DAOProvider;
import by.epam.tc.project.dao.UserDAO;
import by.epam.tc.project.dao.exception.DAOException;
import by.epam.tc.project.entity.User;
import org.junit.*;


public class UserDAOImplTest {

    private final static  DAOProvider DAO_PROVIDER = DAOProvider.getInstance();
    private final static  UserDAO USER_DAO = DAO_PROVIDER.getUserDAO();
    private static User user;

    @BeforeClass
    public static void initUserTest() {
        user = new User();
        user.setLogin("natasha1");
        user.setPassword("natasha");
        user.setName("natalya");
        user.setSurname("maksimova");
        user.setEmail("nata@mail.ru");
        user.setCountry("BY");
        user.setPhone("+375296214697");
        user.setRoleId(2);
    }

    @AfterClass
    public static void destroyUserTest() {

        try {
            USER_DAO.deleteUser(user.getLogin());
        } catch (DAOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void addUserTest() {
        try {
            USER_DAO.addUser(user);
            User userFromBase = USER_DAO.retrieveUserByLogin(user.getLogin());
            assertEquals(user, userFromBase);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}