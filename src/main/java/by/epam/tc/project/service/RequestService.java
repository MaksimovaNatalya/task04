package by.epam.tc.project.service;

import by.epam.tc.project.entity.Request;
import by.epam.tc.project.service.exception.ServiceException;

import java.util.List;

public interface RequestService {
    /**
     * Retrieve all requests from database
     * @return a list of requests
     * @throws ServiceException if there are no requests
     */
    List<Request> getAllRequests() throws ServiceException;

    /**
     * Retrieve all requests of a user from database
     * @param login is user's login
     * @return a list of user's requests
     * @throws ServiceException if there are no requests
     */
    List<Request> getRequestsByLogin(String login) throws ServiceException;

    /**
     * Add a request into a database
     * @param request is a new request
     * @throws ServiceException if there are no available rooms for these dates
     */
    void addRequest(Request request) throws ServiceException;

    /**
     * Change status of the request to 'approved'
     * @param requestId is id of a request
     */
    void approveRequest(int requestId) throws ServiceException;

    /**
     * Change status of the request to 'declined'
     * @param id is id of a request
     */
    void declineRequest(int id) throws ServiceException;

    /**
     * Change status of the request to 'cancelled'
     * @param id is id of a request
     * @throws ServiceException if status is 'approved' or 'declined'
     */
    void cancelBooking(int id) throws ServiceException;
}
