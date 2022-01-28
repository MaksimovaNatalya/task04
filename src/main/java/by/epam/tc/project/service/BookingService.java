package by.epam.tc.project.service;

import by.epam.tc.project.entity.Booking;
import by.epam.tc.project.entity.Request;
import by.epam.tc.project.entity.Room;

import java.util.Date;
import java.util.List;

public interface BookingService {

    List<Room> getAvailableRoomsForDate(Date startDate, Date endDate, int numberOfGuests);
    List<Booking> getAllStays();
}
