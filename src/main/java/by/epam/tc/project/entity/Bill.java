package by.epam.tc.project.entity;

import java.io.Serializable;
import java.util.Objects;

public class Bill implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer totalAmount;
    private String status;
    private Integer bookingsId;

    public Bill() {
    }

    public Bill(Integer id, Integer totalAmount, String status, Integer bookingsId) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.status = status;
        this.bookingsId = bookingsId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getBookingsId() {
        return bookingsId;
    }

    public void setBookingsId(Integer bookingsId) {
        this.bookingsId = bookingsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return id.equals(bill.id) && Objects.equals(totalAmount, bill.totalAmount) && Objects.equals(status, bill.status) && bookingsId.equals(bill.bookingsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalAmount, status, bookingsId);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", total_amount=" + totalAmount +
                ", status='" + status + '\'' +
                ", bookings_id=" + bookingsId +
                '}';
    }
}
