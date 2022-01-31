package by.epam.tc.project.entity;

import java.io.Serializable;
import java.util.Objects;

public class Room implements Serializable {
    private Integer id;
    private Integer maxPersons;
    private String category;
    private Integer pricePerNight;
    private String seaview;
    private String breakfast;
    private String image;

    public Room () {

    }
    public Room(Integer id, Integer max_persons, String category, Integer price_per_night, String has_sea_view, String breakfast_included, String image) {
        this.id = id;
        this.maxPersons = max_persons;
        this.category = category;
        this.pricePerNight = price_per_night;
        this.seaview = has_sea_view;
        this.breakfast = breakfast_included;
        this.image = image;
    }

    public Room(Integer max_persons, String category, Integer price_per_night, String has_sea_view, String breakfast_included, String image) {
        this.maxPersons = max_persons;
        this.category = category;
        this.pricePerNight = price_per_night;
        this.seaview = has_sea_view;
        this.breakfast = breakfast_included;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaxPersons() {
        return maxPersons;
    }

    public void setMaxPersons(Integer maxPersons) {
        this.maxPersons = maxPersons;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Integer pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getSeaview() {
        return seaview;
    }

    public void setSeaview(String seaview) {
        this.seaview = seaview;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id.equals(room.id) && Objects.equals(maxPersons, room.maxPersons) && Objects.equals(category, room.category) && Objects.equals(pricePerNight, room.pricePerNight) && Objects.equals(seaview, room.seaview) && Objects.equals(breakfast, room.breakfast) && Objects.equals(image, room.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maxPersons, category, pricePerNight, seaview, breakfast, image);
    }

    @Override
    public String toString() {
        return "Room: " +
                "id=" + id +
                ", max_persons=" + maxPersons +
                ", category='" + category + '\'' +
                ", price_per_night=" + pricePerNight +
                ", has_sea_view='" + seaview + '\'' +
                ", breakfast_included='" + breakfast + '\'' +
                ", image='" + image + '\'' +"\n";
    }
}
