package by.epam.tc.project.service.impl;

import by.epam.tc.project.dao.DAOProvider;
import by.epam.tc.project.dao.RequestDAO;
import by.epam.tc.project.dao.exception.DAOException;
import by.epam.tc.project.entity.Request;
import by.epam.tc.project.service.RequestService;
import by.epam.tc.project.service.exception.ServiceException;

import java.util.List;

public class RequestServiceImpl implements RequestService {
    private static final DAOProvider provider = DAOProvider.getInstance();
    private static final RequestDAO requestDAO = provider.getRequestDAO();

    @Override
    public List<Request> getAllRequests() throws ServiceException {
        List<Request> allRequests;
        try {
            allRequests = requestDAO.retrieveAllRequests();

        } catch (DAOException e) {
            throw new ServiceException();
        }
        return allRequests;
    }

    @Override
    public List<Request> getRequestsByLogin(String login) throws ServiceException {
        List<Request> allRequests;
        try {
            allRequests = requestDAO.retrieveRequestsByUserId(login);

        } catch (DAOException e) {
            throw new ServiceException();
        }
        return allRequests;
    }

    @Override
    public void addRequest(Request request) throws ServiceException {
        try {

            requestDAO.addRequest(request);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void approveRequest(int requestId) throws ServiceException {
        try {
            requestDAO.approveRequest(requestId);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void declineRequest(int id) throws ServiceException {
        try {
            requestDAO.declineRequest(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void cancelBooking(int id) throws ServiceException {
        try {
            requestDAO.cancelBooking(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }
}
