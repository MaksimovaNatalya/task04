package by.epam.tc.project.dao.db;

public class TableAndColumnName {
    public static final String USER_TABLE = "users";
    public static final String USERS_ID = "id";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String E_MAIL = "email";
    public static final String COUNTRY = "country";
    public static final String TEL_NUMBER = "phone";
    public static final String USERSTABLE_ROLE_ID = "user_roles_id";

    public static final String ROLE_TABLE = "user_roles";
    public static final String USER_ROLES_ID = "id";
    public static final String USER_ROLES_ROLE_NAME = "role";

    public static final String ROOM_TABLE = "rooms";
    public static final String ROOM_ID = "id";
    public static final String ROOM_MAX_PERSONS = "max_persons";
    public static final String ROOM_CATEGORY = "category";
    public static final String ROOM_PRICE_PER_NIGHT = "price-per-night";
    public static final String ROOM_HAS_SEA_VIEW = "has-seaview";
    public static final String ROOM_BREAKFAST_INCLUDED = "breakfast-included";
    public static final String ROOM_IMAGE = "image";

    public static final String BOOKING_TABLE = "bookings";
    public static final String BOOKING_ID = "id";
    public static final String BOOKING_REAL_START_DATE = "real_start_date";
    public static final String BOOKING_REAL_END_DATE = "real_end_date";
    public static final String BOOKING_REQUESTED_ROOM_ID = "requested_rooms_id";

    public static final String REQUEST_TABLE = "requests";
    public static final String REQUEST_ID = "id";
    public static final String REQUEST_ROOM_CATEGORY = "category";
    public static final String REQUEST_MAX_PERSONS = "max_persons";
    public static final String REQUEST_START_DATE = "start_date";
    public static final String REQUEST_END_DATE = "end_date";
    public static final String REQUEST_STATUS = "status";
    public static final String REQUEST_USER_ID = "users_id";

    public static final String BILL_TABLE = "bills";
    public static final String BILL_ID = "id";
    public static final String BILL_TOTAL_AMOUNT = "total_amount";
    public static final String BILL_STATUS = "status";
    public static final String BILL_BOOKINGS_ID = "bookings_id";



}
