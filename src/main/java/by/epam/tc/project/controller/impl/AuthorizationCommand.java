package by.epam.tc.project.controller.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.epam.tc.project.controller.Command;
import by.epam.tc.project.controller.constant.Constant;
import by.epam.tc.project.dao.db.TableAndColumnName;
import by.epam.tc.project.entity.Role;
import by.epam.tc.project.entity.User;
import by.epam.tc.project.service.ServiceProvider;
import by.epam.tc.project.service.UserService;
import by.epam.tc.project.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizationCommand implements Command {

    private static final ServiceProvider PROVIDER = ServiceProvider.getInstance();
    private static final UserService USER_SERVICE = PROVIDER.getUserService();

    private final static Logger LOG = LogManager.getLogger(AuthorizationCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String login = request.getParameter(TableAndColumnName.LOGIN);
        String password = request.getParameter(TableAndColumnName.PASSWORD);


        try {

            if (checkEmptyField(login) || checkEmptyField(password)) {
                response.sendRedirect(Constant.Redirect.TO_AUTHORIZATION_PAGE + Constant.Message.PARAM_MESSAGE + Constant.Message.LOGIN_OR_PASSWORD_EMPTY);
                return;
            }
            User user = USER_SERVICE.authorize(login, password);

            if (user != null) {
                request.getSession().setAttribute(TableAndColumnName.LOGIN, login);
                request.getSession().setAttribute(TableAndColumnName.USER_ROLES_ROLE_NAME, Role.getById(user.getRoleId()));
                response.sendRedirect(Constant.Redirect.TO_INDEX_PAGE + Constant.Message.PARAM_MESSAGE + Constant.Message.AUTHORIZATION_SUCCESS);
            } else {
                response.sendRedirect(Constant.Redirect.TO_AUTHORIZATION_PAGE + Constant.Message.PARAM_MESSAGE + Constant.Message.AUTHORIZATION_ERROR);
            }
        } catch (ServiceException e) {
            LOG.error(e);
            response.sendRedirect(Constant.Redirect.TO_ERROR_PAGE);
        }
    }

    private boolean checkEmptyField(String field) {
        return field == null || field.isEmpty();
    }

}

