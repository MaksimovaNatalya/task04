package by.epam.tc.project.service.impl;

import by.epam.tc.project.entity.Booking;
import by.epam.tc.project.entity.Request;
import by.epam.tc.project.entity.Room;
import by.epam.tc.project.service.BookingService;

import java.util.Date;
import java.util.List;

public class BookingServiceImpl implements BookingService {

    @Override
    public List<Room> getAvailableRoomsForDate(Date startDate, Date endDate, int numberOfGuests) {
        return null;
    }

    @Override
    public List<Booking> getAllStays() {
        return null;
    }


}
