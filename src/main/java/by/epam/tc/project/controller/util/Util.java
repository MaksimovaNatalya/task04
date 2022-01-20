package by.epam.tc.project.controller.util;

public final class Util {
    public final class Forward{
        public final static String TO_ERROR_PAGE = "error.jsp";
        public final static String TO_BOOKINGS_PAGE = "/WEB-INF/jsp/bookings.jsp";
        public final static String TO_BOOK_ROOM_PAGE = "/WEB-INF/jsp/bookRoom.jsp";
        public final static String TO_LOGINATION_PAGE = "/WEB-INF/jsp/logination.jsp";
        public final static String TO_REGISTRATION_PAGE = "/WEB-INF/jsp/registration.jsp";
        public final static String TO_ACCOUNT_PAGE = "/WEB-INF/jsp/myAccount.jsp";
        public final static String TO_ROOMS_PAGE = "/WEB-INF/jsp/rooms.jsp";
        public final static String TO_STAYS_PAGE = "/WEB-INF/jsp/stays.jsp";
        public final static String TO_WELCOME_PAGE = "/WEB-INF/jsp/welcome.jsp";
        public final static String TO_CONTACTS_PAGE = "/WEB-INF/jsp/contacts.jsp";
        public final static String TO_CLIENTS_PAGE = "/WEB-INF/jsp/clients.jsp";
    }

    public final class Redirect{
        public final static String TO_ERROR_PAGE = "Controller?command=GO_TO_ERROR_PAGE";
        public final static String TO_AUTHORIZATION_PAGE = "Controller?command=GO_TO_AUTHORIZATION_PAGE";
        public final static String TO_BOOKINGS_PAGE = "Controller?command=GO_TO_BOOKINGS_PAGE";
        public final static String TO_STAYS_PAGE = "Controller?command=GO_TO_STAYS_PAGE";
        public final static String TO_ACCOUNT_PAGE = "Controller?command=GO_TO_ACCOUNT_PAGE";
        public final static String LOG_OUT = "Controller?command=GO_TO_WELCOME_PAGE&logOut=true";
        public final static String TO_CLIENTS_PAGE = "Controller?command=GO_TO_CLIENTS_PAGE";
    }

    public final class Command{
        public final static String EDIT_STAY = "EditStay";
        public final static String EDIT_STAY_CHECK = "EditStayCheck";
        public final static String ADD_BOOKING = "AddBooking";
        public final static String ADD_STAY = "AddStay";
        public final static String EDIT_BOOKING_CHECK = "EditBookingCheck";
        public final static String CHANGE_LANGUAGE = "ChangeLanguage";
    }

    public final class Utility{
        public final static String EMPTY = "";
        public final static String CLIENTS = "clients";
        public final static String BOOKINGS = "bookings";
        public final static String STAYS = "stays";
        public final static String BOOKING = "booking";
        public final static String STAY = "stay";
        public final static String ROLE = "role";
        public final static String LOGIN = "login";
        public final static String PASSWORD = "password";
        public final static String INITIAL_PASSWORD = "initialPassword";
        public final static String NEW_PASSWORD = "newPassword";
        public final static String ADMIN = "admin";
        public final static String CLIENT = "client";
        public final static String CREATE = "create";
        public final static String MIN_COST = "minCost";
        public final static String MAX_COST = "maxCost";
        public final static String MIN_CAPACITY = "minCapacity";
        public final static String MAX_CAPACITY = "maxCapacity";
        public final static String CURRENT_MIN_COST = "currentMinCost";
        public final static String CURRENT_MAX_COST = "currentMaxCost";
        public final static String CURRENT_MIN_CAPACITY = "currentMinCapacity";
        public final static String CURRENT_MAX_CAPACITY = "currentMaxCapacity";
        public final static String PRICE_LEFT = "price-left";
        public final static String PRICE_RIGHT = "price-right";
        public final static String CAPACITY_LEFT = "capacity-left";
        public final static String CAPACITY_RIGHT = "capacity-right";
        public final static String SEARCH_GENDER = "searchGender";
        public final static String CURRENT_GENDER = "currentGender";
        public final static String SEARCH_BATHROOM = "searchBathroom";
        public final static String CURRENT_IS_BATHROOM = "currentIsBathroom";
        public final static String SELECTED_ROOMS = "selected_rooms";
        public final static String LOG_OUT = "logOut";
        public final static String REQUEST_ENCODING = "requestEncoding";
        public final static String ERROR = "error";
        public final static String BOOKING_ID = "bookingId";
        public final static String STAY_ID = "stayId";
        public final static String COMMAND = "command";
        public final static String POPUP_VIEW = "popUpView";
        public final static String FROM_DATE = "fromDate";
        public final static String TO_DATE = "toDate";
        public final static String GUESTS_NUMBER = "guestsNumber";
        public final static String ROOM_NUMBER = "roomNumber";
        public final static String NOTES = "notes";
        public final static String EDITED_STAY_ID = "editedStayId";
        public final static String EDITED_BOOKING_ID = "editedBookingId";
        public final static String CHECK_RESULT = "checkResult";
        public final static String EDIT_BOOKING = "editBooking";
        public final static String NAME = "name";
        public final static String SURNAME = "surname";
        public final static String PASSPORT_ID = "passportId";
        public final static String DATE_OF_BIRTH = "dateOfBith";
        public final static String COUNTRY = "country";
        public final static String PHONE = "phone";
        public final static String EMAIL = "email";
        public final static String PHOTO = "photo";
        public final static String APPROVE = "approve";
        public final static String ROOM = "room";
        public final static String ALL_ROOMS = "allRooms";
        public final static String LANGUAGE = "language";
        public final static String URL = "url";
        public final static String CHECK_AMONG_ALL_ROOMS = "checkAmongAllRooms";
        public final static String AVAILABLE_ROOMS = "availableRooms";
        public final static String CHOSEN_BOOKING_ID = "chosenBookingId";
        public final static String CHOSEN_BOOKING_IS_APPROVED = "chosenBookingIsApproved";
        public final static String CHOSEN_BOOKING_IS_PAID = "chosenBookingIsPaid";
        public final static String CHOSEN_STAY_ID = "chosenStayId";
        public final static String OPTIONS = "options";
        public final static String NEW_STAY_FROM_DATE = "newStayFromDate";
        public final static String NEW_STAY_TO_DATE = "newStayToDate";
        public final static String NEW_STAY_ROOM_NUMBER = "newStayRoomNumber";
        public final static String NEW_STAY_GUESTS_NUMBER = "newStayGuestsNumber";
        public final static String CHOSEN_CLIENT_ID = "chosenClientId";
    }

    public final class Message{
        public final static String AUTHORIZATION_ERROR = "No such login or password. Please, check and try again.";
        public final static String WRONG_PASSWORD = "Wrong password. Please, check and try again.";
            public final static String AUTHORIZATION_SUCCESS = "You are successfully logged in.";
    }
}
