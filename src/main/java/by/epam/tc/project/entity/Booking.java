package by.epam.tc.project.entity;

import java.io.Serializable;
import java.util.Objects;

public class Booking implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String realStartDate;
    private String realEndDate;
    private Integer requestedRoomsId;

    public Booking() {
    }

    public Booking(Integer id, String realStartDate, String realEndDate, Integer requestedRoomsId) {
        this.id = id;
        this.realStartDate = realStartDate;
        this.realEndDate = realEndDate;
        this.requestedRoomsId = requestedRoomsId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealStartDate() {
        return realStartDate;
    }

    public void setRealStartDate(String realStartDate) {
        this.realStartDate = realStartDate;
    }

    public String getRealEndDate() {
        return realEndDate;
    }

    public void setRealEndDate(String realEndDate) {
        this.realEndDate = realEndDate;
    }

    public Integer getRequestedRoomsId() {
        return requestedRoomsId;
    }

    public void setRequestedRoomsId(Integer requestedRoomsId) {
        this.requestedRoomsId = requestedRoomsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id.equals(booking.id) && Objects.equals(realStartDate, booking.realStartDate) && Objects.equals(realEndDate, booking.realEndDate) && requestedRoomsId.equals(booking.requestedRoomsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, realStartDate, realEndDate, requestedRoomsId);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", real_start_date='" + realStartDate + '\'' +
                ", real_end_date='" + realEndDate + '\'' +
                ", requested_rooms_id=" + requestedRoomsId +
                '}';
    }
}
