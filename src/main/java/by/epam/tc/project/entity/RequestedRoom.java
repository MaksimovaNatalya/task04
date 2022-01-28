package by.epam.tc.project.entity;

import java.io.Serializable;
import java.util.Objects;

public class RequestedRoom implements Serializable {
    private Integer id;
    private String status;
    private Integer roomsId;
    private Integer requestsId;

    public RequestedRoom() {

    }
    public RequestedRoom(Integer id, String status, Integer roomsId, Integer requestsId) {
        this.id = id;
        this.status = status;
        this.roomsId = roomsId;
        this.requestsId = requestsId;
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

    public Integer getRoomsId() {
        return roomsId;
    }

    public void setRoomsId(Integer roomsId) {
        this.roomsId = roomsId;
    }

    public Integer getRequestsId() {
        return requestsId;
    }

    public void setRequestsId(Integer requestsId) {
        this.requestsId = requestsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestedRoom that = (RequestedRoom) o;
        return id.equals(that.id) && Objects.equals(status, that.status) && roomsId.equals(that.roomsId) && requestsId.equals(that.requestsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, roomsId, requestsId);
    }

    @Override
    public String toString() {
        return "RequestedRoom{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", rooms_id=" + roomsId +
                ", requests_id=" + requestsId +
                '}';
    }
}
