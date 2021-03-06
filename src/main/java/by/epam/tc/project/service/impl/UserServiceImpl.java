package by.epam.tc.project.service.impl;

import by.epam.tc.project.dao.DAOProvider;
import by.epam.tc.project.dao.UserDAO;
import by.epam.tc.project.dao.exception.DAOException;
import by.epam.tc.project.entity.User;
import by.epam.tc.project.service.UserService;
import by.epam.tc.project.service.exception.ServiceException;
import by.epam.tc.project.service.validator.UserValidator;
import by.epam.tc.project.service.validator.ValidatorException;
import by.epam.tc.project.service.validator.ValidatorProvider;

public class UserServiceImpl implements UserService {
    private static final DAOProvider provider = DAOProvider.getInstance();
    private static final UserDAO userDAO = provider.getUserDAO();

    private static final ValidatorProvider VALIDATOR_PROVIDER = ValidatorProvider.getInstance();
    private static final UserValidator userValidator = VALIDATOR_PROVIDER.getUserValidator();

    @Override
    public User authorize(String login, String password) throws ServiceException {

        User user;
        try {

            user = userDAO.authorize(login, password);

            return user;
        } catch (DAOException e) {
            throw new ServiceException("Service exception in UserService.authorization", e);
        }

    }


    @Override
    public void register(User user) throws ServiceException, ValidatorException {
        try {
            userValidator.checkRegistrationInfo(user);
            userDAO.addUser(user);
        } catch (DAOException e) {
            throw new ServiceException("Service exception in register(User user)", e);
        }
    }


    @Override
    public User getUser(String login) throws ServiceException {
        User user;
        try {
            user = userDAO.retrieveUserByLogin(login);

            return user;

        } catch (DAOException e) {
            throw new ServiceException("Service exception in UserService.getUser", e);
        }
    }

    @Override
    public void updateUserInfo(String newLogin, String name, String surname, String email, String country, String phone, String login) throws ServiceException, ValidatorException {
        try {
            userValidator.checkRegistrationInfo(newLogin, name, surname, email, country, phone, login);
            userDAO.updateUserInfo(newLogin, name, surname, email, country, phone, login);
        } catch (DAOException e) {
            throw new ServiceException("Service exception in UserService.updateUserInfo", e);
        }
    }

}
