package by.epam.tc.project.controller.impl;

import by.epam.tc.project.controller.Command;
import by.epam.tc.project.controller.constant.Constant;
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

public class ApproveRequestCommand implements Command {
    private static final ServiceProvider PROVIDER = ServiceProvider.getInstance();
    private static final RequestService REQUEST_SERVICE = PROVIDER.getRequestService();
    private static final String APPROVE = "approve";
    private static final String ALL_REQUESTS = "allRequests";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter(APPROVE));
        try {
            REQUEST_SERVICE.approveRequest(id);
            List<Request> allRequests = REQUEST_SERVICE.getAllRequests();

            if (allRequests != null) {
                request.setAttribute(ALL_REQUESTS, allRequests);
                RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.Forward.TO_ALL_REQUESTS_PAGE);
                dispatcher.forward(request, response);
            }
        } catch (ServiceException e) {
            response.sendRedirect(Constant.Redirect.TO_ERROR_PAGE);
        }
    }
}
