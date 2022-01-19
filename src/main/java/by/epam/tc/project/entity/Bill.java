package by.epam.tc.project.entity;

import java.io.Serializable;
import java.util.Objects;

public class Bill implements Serializable {
    private Integer id;
    private Integer total_amount;
    private String status;
    private Integer bookings_id;

    public Bill() {
    }

    public Bill(Integer id, Integer total_amount, String status, Integer bookings_id) {
        this.id = id;
        this.total_amount = total_amount;
        this.status = status;
        this.bookings_id = bookings_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Integer total_amount) {
        this.total_amount = total_amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getBookings_id() {
        return bookings_id;
    }

    public void setBookings_id(Integer bookings_id) {
        this.bookings_id = bookings_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return id.equals(bill.id) && Objects.equals(total_amount, bill.total_amount) && Objects.equals(status, bill.status) && bookings_id.equals(bill.bookings_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total_amount, status, bookings_id);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", total_amount=" + total_amount +
                ", status='" + status + '\'' +
                ", bookings_id=" + bookings_id +
                '}';
    }
}
