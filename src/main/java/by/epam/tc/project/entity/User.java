package by.epam.tc.project.entity;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private Integer id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String eMail;
    private String country;
    private String telNumber;
    private Integer roleId;

    public User() {
    }

    public User(Integer id, String login, String password, String name, String surname, String eMail, String country, String telNumber, Integer roleId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.eMail = eMail;
        this.country = country;
        this.telNumber = telNumber;
        this.roleId=roleId;
    }

    public User(String login, String password, String name, String surname, String eMail, String country, String telNumber, Integer roleId) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.eMail = eMail;
        this.country = country;
        this.telNumber = telNumber;
        this.roleId=roleId;
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

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
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
        return id.equals(user.id) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(eMail, user.eMail) && Objects.equals(country, user.country) && Objects.equals(telNumber, user.telNumber) && roleId == user.roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, name, surname, eMail, country, telNumber, roleId);
    }

    @Override
    public String toString() {
        return "User: " +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", eMail='" + eMail + '\'' +
                ", country='" + country + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", role=" + roleId +"\n";
    }
}
