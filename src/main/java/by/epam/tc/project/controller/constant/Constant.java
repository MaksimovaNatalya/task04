package by.epam.tc.project.controller.constant;

public final class Constant {
    public final class Forward {
        public final static String TO_AUTHORIZATION_PAGE = "/WEB-INF/jsp/authorization.jsp";
        public final static String TO_ACCOUNT_PAGE = "/WEB-INF/jsp/account.jsp";
        public final static String TO_AVAILABLE_ROOMS_PAGE = "/WEB-INF/jsp/availableRooms.jsp";
        public final static String TO_ALL_REQUESTS_PAGE = "/WEB-INF/jsp/allRequests.jsp";
        public final static String TO_MAIN_PAGE = "/WEB-INF/jsp/mainPage.jsp";
        public final static String TO_MY_BOOKINGS_PAGE = "/WEB-INF/jsp/myBookings.jsp";
        public final static String TO_REGISTRATION_PAGE = "/WEB-INF/jsp/registration.jsp";
        public final static String TO_REQUEST_PAGE = "/WEB-INF/jsp/request.jsp";
        public final static String TO_REQUEST_CONFIRMATION_PAGE = "/WEB-INF/jsp/requestConfirmation.jsp";
        public final static String TO_ROOMS_PAGE = "/WEB-INF/jsp/rooms.jsp";
        public final static String TO_ERROR_PAGE = "/WEB-INF/jsp/error.jsp";
    }

    public final class Redirect {
        public final static String TO_ERROR_PAGE = "Controller?command=GO_TO_ERROR_PAGE";
        public final static String TO_AUTHORIZATION_PAGE = "Controller?command=GO_TO_AUTHORIZATION_PAGE";
        public final static String TO_ACCOUNT_PAGE = "Controller?command=GO_TO_ACCOUNT_PAGE";
        public final static String LOG_OUT = "Controller?command=GO_TO_INDEX_PAGE&logOut=true";
        public final static String TO_REQUEST_PAGE = "Controller?command=GO_TO_REQUEST_PAGE";
        public final static String TO_INDEX_PAGE = "Controller?command=GO_TO_INDEX_PAGE";
    }

    public final class Utility {
        public final static String LOGIN = "login";
        public final static String PASSWORD = "password";
        public final static String NAME = "name";
        public final static String SURNAME = "surname";
        public final static String EMAIL = "email";
        public final static String COUNTRY = "country";
        public final static String TELNUMBER = "phone";
        public final static String GUESTS_NUMBER = "guestsNumber";
        public final static String LANGUAGE = "language";
        public final static String URL = "url";
        public final static String AVAILABLE_ROOMS = "availableRooms";
    }

    public final class Message {
        public static final String PARAM_MESSAGE = "&message=";
        public static final String AUTHORIZATION_ERROR = "No such login or password. Please, check and try again.";
        public static final String LOGIN_OR_PASSWORD_EMPTY = "Please fill your login and password in.";
        public static final String AUTHORIZATION_SUCCESS = "You are successfully logged in.";
        public static final String REGISTRATION_SUCCESS = "Registration is completed. Please, sign in.";
        public static final String EXISTING_USER = "User with such credentials already exists.";
        public static final String NO_REQUESTS = "You have no requests yet";
        public static final String NO_AVAILABLE_ROOMS = "No available rooms for these dates. Choose another date.";
        public static final String AUTHORIZATION_OBLIGATORY = "To book a room you should be authorized in the system. Please, sign in.";
        public static final String INFO_UPDATED = "Your personal information has been successfully updated.";
    }
}
