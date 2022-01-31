package by.epam.tc.project.controller;

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

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("Approve"));

        try {
            REQUEST_SERVICE.approveRequest(id);
            List<Request> allRequests = REQUEST_SERVICE.getAllRequests();

            if (allRequests != null) {
                request.setAttribute("allRequests", allRequests);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/allRequests.jsp");
                dispatcher.forward(request, response);

            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
