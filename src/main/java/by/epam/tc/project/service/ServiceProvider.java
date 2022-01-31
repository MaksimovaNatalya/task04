package by.epam.tc.project.service;

import by.epam.tc.project.service.impl.RequestServiceImpl;
import by.epam.tc.project.service.impl.RoomServiceImpl;
import by.epam.tc.project.service.impl.UserServiceImpl;

public final class ServiceProvider {

    private static final ServiceProvider instance = new ServiceProvider();


    private final UserService userService = new UserServiceImpl();
    private final RoomService roomService = new RoomServiceImpl();
    private final RequestService requestService = new RequestServiceImpl();

    public RequestService getRequestService() {
        return requestService;
    }

    public UserService getUserService() {
        return userService;
    }

    public RoomService getRoomService() {
        return roomService;
    }


    private ServiceProvider() {
    }

    public static ServiceProvider getInstance() {
        return instance;
    }
}
