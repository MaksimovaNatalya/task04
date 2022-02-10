package by.epam.tc.project.entity;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String country;
    private String phone;
    private Integer roleId;

    public User() {
    }

    public User(Integer id, String login, String password, String name, String surname, String email, String country, String telNumber, Integer roleId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.country = country;
        this.phone = telNumber;
        this.roleId = roleId;
    }

    public User(String login, String password, String name, String surname, String email, String country, String telNumber, Integer roleId) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.country = country;
        this.phone = telNumber;
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) && Objects.equals(email, user.email) &&
                Objects.equals(country, user.country) && Objects.equals(phone, user.phone) && roleId == user.roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, name, surname, email, country, phone, roleId);
    }

    @Override
    public String toString() {
        return "User: " +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", telNumber='" + phone + '\'' +
                ", role=" + roleId + "\n";
    }
}
