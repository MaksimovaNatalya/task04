package by.epam.tc.project.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Request implements Serializable {
    private Integer id;
    private String category;
    private Integer max_persons;
    private Date start_date;
    private Date end_date;
    private String status;
    private String users_id;

    public Request () {

    }
    public Request(Integer id, String category, Integer max_persons, Date start_date, Date end_date, String status, String users_id) {
        this.id = id;
        this.category = category;
        this.max_persons = max_persons;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
        this.users_id = users_id;
    }

    public Request(String category, Integer max_persons, Date start_date, Date end_date, String status, String users_id) {
        this.category = category;
        this.max_persons = max_persons;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
        this.users_id = users_id;
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

    public Integer getMax_persons() {
        return max_persons;
    }

    public void setMax_persons(Integer max_persons) {
        this.max_persons = max_persons;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsers_id() {
        return users_id;
    }

    public void setUsers_id(String users_id) {
        this.users_id = users_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return id.equals(request.id) && Objects.equals(category, request.category) && Objects.equals(max_persons, request.max_persons) && Objects.equals(start_date, request.start_date) && Objects.equals(end_date, request.end_date) && Objects.equals(status, request.status) && users_id.equals(request.users_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, max_persons, start_date, end_date, status, users_id);
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", max_persons=" + max_persons +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", status='" + status + '\'' +
                ", users_id='" + users_id + '\'' +
                '}';
    }
}
