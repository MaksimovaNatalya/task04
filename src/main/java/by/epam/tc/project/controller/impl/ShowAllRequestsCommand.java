package by.epam.tc.project.controller.impl;

import by.epam.tc.project.controller.Command;
import by.epam.tc.project.controller.util.Util;
import by.epam.tc.project.entity.Request;
import by.epam.tc.project.service.RequestService;
import by.epam.tc.project.service.ServiceProvider;
import by.epam.tc.project.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowAllRequestsCommand implements Command {
    private static final ServiceProvider PROVIDER = ServiceProvider.getInstance();
    private static final RequestService REQUEST_SERVICE = PROVIDER.getRequestService();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {


            List<Request> allRequests = REQUEST_SERVICE.getAllRequests();

            if (allRequests != null) {
                request.setAttribute("allRequests", allRequests);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/allRequests.jsp");
                dispatcher.forward(request,response);
            } else {
                response.sendRedirect(Util.Redirect.TO_ACCOUNT_PAGE + Util.Message.PARAM_MESSAGE + Util.Message.NO_REQUESTS);
            }
        } catch (ServiceException e) {
            response.sendRedirect(Util.Redirect.TO_ERROR_PAGE);
        }

    }
}
