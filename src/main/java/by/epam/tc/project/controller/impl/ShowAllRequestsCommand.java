package by.epam.tc.project.controller.impl;

import by.epam.tc.project.controller.Command;
import by.epam.tc.project.controller.constant.Constant;
import by.epam.tc.project.entity.Request;
import by.epam.tc.project.service.RequestService;
import by.epam.tc.project.service.ServiceProvider;
import by.epam.tc.project.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowAllRequestsCommand implements Command {
    private static final ServiceProvider PROVIDER = ServiceProvider.getInstance();
    private static final RequestService REQUEST_SERVICE = PROVIDER.getRequestService();
    private final static Logger LOG = LogManager.getLogger(ShowAllRequestsCommand.class);

    private final String ALL_REQUESTS = "allRequests";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            List<Request> allRequests = REQUEST_SERVICE.getAllRequests();

            if (allRequests != null) {
                request.setAttribute(ALL_REQUESTS, allRequests);
                RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.Forward.TO_ALL_REQUESTS_PAGE);
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect(Constant.Redirect.TO_ACCOUNT_PAGE + Constant.Message.PARAM_MESSAGE + Constant.Message.NO_REQUESTS);
            }
        } catch (ServiceException e) {
            LOG.error(e);
            response.sendRedirect(Constant.Redirect.TO_ERROR_PAGE);
        }

    }
}
