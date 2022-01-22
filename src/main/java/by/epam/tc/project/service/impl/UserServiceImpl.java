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
    public User authorization(String login, String password) throws ServiceException {
        //1.. validation

        //2. realizations
        User user;
        try {
            user = userDAO.authorization(login, password);
            return user;
        } catch (DAOException e) {
            throw new ServiceException("Service exception in UserService.authorization", e);
        }

    }


    @Override
    public void registration(User user) throws ServiceException {
        try {
     //       userValidator.checkRegistrationInfo(user);
            userDAO.addUser(user);
        } catch (DAOException e) {
            e.printStackTrace();}
//        } catch (ValidatorException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public User getUser(String login) throws ServiceException {
        return null;
    }

    @Override
    public void delete(User user) throws ServiceException {

    }
}
