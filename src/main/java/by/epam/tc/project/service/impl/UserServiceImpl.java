package by.epam.tc.project.service.impl;

import by.epam.tc.project.dao.DAOProvider;
import by.epam.tc.project.dao.UserDAO;
import by.epam.tc.project.dao.exception.DAOException;
import by.epam.tc.project.entity.User;
import by.epam.tc.project.service.UserService;
import by.epam.tc.project.service.exception.ServiceException;

public class UserServiceImpl implements UserService {
    DAOProvider provider = DAOProvider.getInstance();
    UserDAO userDAO = provider.getUserDAO();
    @Override
    public User authorization(String login, String password) throws ServiceException {
        //1.. validation

        //2. realizations
        User user;
        try {
            user = userDAO.authorization(login, password);
        } catch (DAOException e) {
            throw new ServiceException("Service exception in UserService.authorization", e);
        }
        return user;
    }


    @Override
    public void registration(User user) throws ServiceException {
        try {
            userDAO.addUser(user);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(String login) throws ServiceException{
        return null;
    }

    @Override
    public void delete(User user) throws ServiceException{

    }
}
