package by.epam.tc.project.entity;

import java.io.Serializable;
import java.util.Objects;

public class Booking implements Serializable {
    private Integer id;
    private String real_start_date;
    private String real_end_date;
    private Integer requested_rooms_id;

    public Booking() {
    }

    public Booking(Integer id, String real_start_date, String real_end_date, Integer requested_rooms_id) {
        this.id = id;
        this.real_start_date = real_start_date;
        this.real_end_date = real_end_date;
        this.requested_rooms_id = requested_rooms_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReal_start_date() {
        return real_start_date;
    }

    public void setReal_start_date(String real_start_date) {
        this.real_start_date = real_start_date;
    }

    public String getReal_end_date() {
        return real_end_date;
    }

    public void setReal_end_date(String real_end_date) {
        this.real_end_date = real_end_date;
    }

    public Integer getRequested_rooms_id() {
        return requested_rooms_id;
    }

    public void setRequested_rooms_id(Integer requested_rooms_id) {
        this.requested_rooms_id = requested_rooms_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id.equals(booking.id) && Objects.equals(real_start_date, booking.real_start_date) && Objects.equals(real_end_date, booking.real_end_date) && requested_rooms_id.equals(booking.requested_rooms_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, real_start_date, real_end_date, requested_rooms_id);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", real_start_date='" + real_start_date + '\'' +
                ", real_end_date='" + real_end_date + '\'' +
                ", requested_rooms_id=" + requested_rooms_id +
                '}';
    }
}
