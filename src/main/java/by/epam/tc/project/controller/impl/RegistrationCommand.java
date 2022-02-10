package by.epam.tc.project.controller.impl;

import by.epam.tc.project.controller.Command;
import by.epam.tc.project.controller.constant.Constant;
import by.epam.tc.project.entity.Role;
import by.epam.tc.project.entity.User;
import by.epam.tc.project.service.ServiceProvider;
import by.epam.tc.project.service.UserService;
import by.epam.tc.project.service.exception.ServiceException;
import by.epam.tc.project.service.validator.ValidatorException;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.epam.tc.project.controller.constant.Constant.Message.PARAM_MESSAGE;
import static by.epam.tc.project.controller.constant.Constant.Utility.URL;

public class RegistrationCommand implements Command {

    private static final ServiceProvider PROVIDER = ServiceProvider.getInstance();
    private static final UserService USER_SERVICE = PROVIDER.getUserService();
    private final static Logger LOG = LogManager.getLogger(RegistrationCommand.class);


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

            response.sendRedirect(Constant.Redirect.TO_AUTHORIZATION_PAGE + PARAM_MESSAGE +
                    Constant.Message.REGISTRATION_SUCCESS);
        }
        catch (ValidatorException e) {
            LOG.error(e);
            response.sendRedirect(Constant.Redirect.TO_REGISTRATION_PAGE + PARAM_MESSAGE + Constant.Message.INVALID_PARAMETERS);
        }
        catch (ServiceException e) {
            LOG.error(e);
            response.sendRedirect(Constant.Redirect.TO_REGISTRATION_PAGE + PARAM_MESSAGE + Constant.Message.EXISTING_USER);

        }


    }
}


