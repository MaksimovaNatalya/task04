package by.epam.tc.project.entity;

import java.io.Serializable;
import java.util.Objects;

public class RequestedRoom implements Serializable {
    private Integer id;
    private String status;
    private Integer rooms_id;
    private Integer requests_id;

    public RequestedRoom() {

    }
    public RequestedRoom(Integer id, String status, Integer rooms_id, Integer requests_id) {
        this.id = id;
        this.status = status;
        this.rooms_id = rooms_id;
        this.requests_id = requests_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRooms_id() {
        return rooms_id;
    }

    public void setRooms_id(Integer rooms_id) {
        this.rooms_id = rooms_id;
    }

    public Integer getRequests_id() {
        return requests_id;
    }

    public void setRequests_id(Integer requests_id) {
        this.requests_id = requests_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestedRoom that = (RequestedRoom) o;
        return id.equals(that.id) && Objects.equals(status, that.status) && rooms_id.equals(that.rooms_id) && requests_id.equals(that.requests_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, rooms_id, requests_id);
    }

    @Override
    public String toString() {
        return "RequestedRoom{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", rooms_id=" + rooms_id +
                ", requests_id=" + requests_id +
                '}';
    }
}
