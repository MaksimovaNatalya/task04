package entity;

import java.io.Serializable;
import java.util.Objects;

public class Room implements Serializable {
    private Integer id;
    private Integer max_persons;
    private String category;
    private Integer price_per_night;
    private String has_sea_view;
    private String breakfast_included;
    private String image;

    public Room () {

    }
    public Room(Integer id, Integer max_persons, String category, Integer price_per_night, String has_sea_view, String breakfast_included, String image) {
        this.id = id;
        this.max_persons = max_persons;
        this.category = category;
        this.price_per_night = price_per_night;
        this.has_sea_view = has_sea_view;
        this.breakfast_included = breakfast_included;
        this.image = image;
    }

    public Room(Integer max_persons, String category, Integer price_per_night, String has_sea_view, String breakfast_included, String image) {
        this.max_persons = max_persons;
        this.category = category;
        this.price_per_night = price_per_night;
        this.has_sea_view = has_sea_view;
        this.breakfast_included = breakfast_included;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMax_persons() {
        return max_persons;
    }

    public void setMax_persons(Integer max_persons) {
        this.max_persons = max_persons;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPrice_per_night() {
        return price_per_night;
    }

    public void setPrice_per_night(Integer price_per_night) {
        this.price_per_night = price_per_night;
    }

    public String getHas_sea_view() {
        return has_sea_view;
    }

    public void setHas_sea_view(String has_sea_view) {
        this.has_sea_view = has_sea_view;
    }

    public String getBreakfast_included() {
        return breakfast_included;
    }

    public void setBreakfast_included(String breakfast_included) {
        this.breakfast_included = breakfast_included;
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
        return id.equals(room.id) && Objects.equals(max_persons, room.max_persons) && Objects.equals(category, room.category) && Objects.equals(price_per_night, room.price_per_night) && Objects.equals(has_sea_view, room.has_sea_view) && Objects.equals(breakfast_included, room.breakfast_included) && Objects.equals(image, room.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, max_persons, category, price_per_night, has_sea_view, breakfast_included, image);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", max_persons=" + max_persons +
                ", category='" + category + '\'' +
                ", price_per_night=" + price_per_night +
                ", has_sea_view='" + has_sea_view + '\'' +
                ", breakfast_included='" + breakfast_included + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
