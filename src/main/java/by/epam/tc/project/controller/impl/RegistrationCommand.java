package by.epam.tc.project.controller.impl;

import by.epam.tc.project.controller.Command;
import by.epam.tc.project.controller.constant.Constant;
import by.epam.tc.project.entity.Role;
import by.epam.tc.project.entity.User;
import by.epam.tc.project.service.ServiceProvider;
import by.epam.tc.project.service.UserService;
import by.epam.tc.project.service.exception.ServiceException;
import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationCommand implements Command {

    private static final ServiceProvider PROVIDER = ServiceProvider.getInstance();
    private static final UserService USER_SERVICE = PROVIDER.getUserService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter(Constant.Utility.LOGIN);
        String name = StringEscapeUtils.unescapeHtml4(request.getParameter(Constant.Utility.NAME));
        String surname = StringEscapeUtils.unescapeHtml4(request.getParameter(Constant.Utility.SURNAME));
        String password = request.getParameter(Constant.Utility.PASSWORD);
        String eMail = request.getParameter(Constant.Utility.EMAIL);
        String country = request.getParameter(Constant.Utility.COUNTRY);
        String telNumber = request.getParameter(Constant.Utility.TELNUMBER);
        int roleId = Role.USER.getRoleId();

        try {
            USER_SERVICE.register(new User(login, password, name, surname, eMail, country, telNumber, roleId));
            response.sendRedirect(Constant.Redirect.TO_AUTHORIZATION_PAGE + Constant.Message.PARAM_MESSAGE +
                    Constant.Message.REGISTRATION_SUCCESS);
        } catch (ServiceException e) {
            response.sendRedirect(Constant.Redirect.TO_AUTHORIZATION_PAGE + "&login=" + login + "&name=" + name
                    + "&surname=" + surname + "&email=" + eMail + "&country=" + country + "&telNumber" + telNumber
                    + Constant.Message.PARAM_MESSAGE + Constant.Message.EXISTING_USER);

        }


    }
}


