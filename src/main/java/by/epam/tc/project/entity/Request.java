package by.epam.tc.project.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Request implements Serializable {
    private Integer id;
    private String category;
    private Integer maxPersons;
    private java.sql.Date startDate;
    private java.sql.Date endDate;
    private String status;
    private Integer usersId;
    private Integer roomsId;

    public  Request (){}

    public Request(Integer id, String category, Integer maxPersons, java.sql.Date startDate, java.sql.Date endDate, String status,
                   Integer usersId, Integer roomsId) {
        this.id = id;
        this.category = category;
        this.maxPersons = maxPersons;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.usersId = usersId;
        this.roomsId = roomsId;
    }
    public Request(String category, Integer maxPersons, java.sql.Date startDate, java.sql.Date endDate, String status,
                   Integer usersId, Integer roomsId) {
        this.category = category;
        this.maxPersons = maxPersons;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.usersId = usersId;
        this.roomsId = roomsId;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getMaxPersons() {
        return maxPersons;
    }

    public void setMaxPersons(Integer maxPersons) {
        this.maxPersons = maxPersons;
    }

    public java.sql.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.sql.Date startDate) {
        this.startDate = startDate;
    }

    public java.sql.Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public Integer getRoomsId() {
        return roomsId;
    }

    public void setRoomsId(Integer roomsId) {
        this.roomsId = roomsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return id.equals(request.id) && Objects.equals(category, request.category) && Objects.equals(maxPersons, request.maxPersons) && Objects.equals(startDate, request.startDate) && Objects.equals(endDate, request.endDate) && Objects.equals(status, request.status) && usersId.equals(request.usersId) && roomsId.equals(request.roomsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, maxPersons, startDate, endDate, status, usersId, roomsId);
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", maxPersons=" + maxPersons +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status='" + status + '\'' +
                ", usersId=" + usersId +
                ", roomsId=" + roomsId +
                '}';
    }
}
