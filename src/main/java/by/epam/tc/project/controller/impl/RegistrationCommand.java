package by.epam.tc.project.controller.impl;

import by.epam.tc.project.controller.Command;
import by.epam.tc.project.controller.util.Util;
import by.epam.tc.project.entity.Role;
import by.epam.tc.project.entity.User;
import by.epam.tc.project.service.ServiceProvider;
import by.epam.tc.project.service.UserService;
import by.epam.tc.project.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class RegistrationCommand implements Command {

    private static final ServiceProvider PROVIDER = ServiceProvider.getInstance();
    private static final UserService USER_SERVICE = PROVIDER.getUserService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter(Util.Utility.LOGIN);
        String name = request.getParameter(Util.Utility.NAME);
        String surname = request.getParameter(Util.Utility.SURNAME);
        String password = request.getParameter(Util.Utility.PASSWORD);
        String eMail = request.getParameter(Util.Utility.EMAIL);
        String country = request.getParameter(Util.Utility.COUNTRY);
        String telNumber = request.getParameter(Util.Utility.TELNUMBER);
        int roleId = Role.USER.getRoleId();

        try {
            USER_SERVICE.registration(new User(login, password, name, surname, eMail, country, telNumber, roleId));
            response.sendRedirect(Util.Redirect.TO_AUTHORIZATION_PAGE + Util.Message.PARAM_MESSAGE + Util.Message.REGISTRATION_SUCCESS);
        } catch (ServiceException e) {
//            String codeLogin = URLEncoder.encode(login, StandardCharsets.UTF_8);
//            String codeName = URLEncoder.encode(name, StandardCharsets.UTF_8);
//            String codeSurname = URLEncoder.encode(surname, StandardCharsets.UTF_8);
            response.sendRedirect(Util.Redirect.TO_AUTHORIZATION_PAGE + "&login=" + login + "&name=" + name
                    + "&surname=" + surname + "&email=" + eMail + "&country=" + country + "&telNumber" + telNumber
                    + Util.Message.PARAM_MESSAGE + Util.Message.EXISTING_USER);

        }


    }
}

