package by.epam.tc.project.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Request implements Serializable {
    private Integer id;
    private String category;
    private Integer maxPersons;
    private Date startDate;
    private Date endDate;
    private String status;
    private String usersId;

    public Request () {

    }
    public Request(Integer id, String category, Integer maxPersons, Date startDate, Date endDate, String status, String usersId) {
        this.id = id;
        this.category = category;
        this.maxPersons = maxPersons;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.usersId = usersId;
    }

    public Request(String category, Integer maxPersons, Date startDate, Date endDate, String status, String usersId) {
        this.category = category;
        this.maxPersons = maxPersons;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.usersId = usersId;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
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

    public String getUsersId() {
        return usersId;
    }

    public void setUsersId(String usersId) {
        this.usersId = usersId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return id.equals(request.id) && Objects.equals(category, request.category) && Objects.equals(maxPersons, request.maxPersons) && Objects.equals(startDate, request.startDate) && Objects.equals(endDate, request.endDate) && Objects.equals(status, request.status) && usersId.equals(request.usersId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, maxPersons, startDate, endDate, status, usersId);
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", max_persons=" + maxPersons +
                ", start_date='" + startDate + '\'' +
                ", end_date='" + endDate + '\'' +
                ", status='" + status + '\'' +
                ", users_id='" + usersId + '\'' +
                '}';
    }
}
