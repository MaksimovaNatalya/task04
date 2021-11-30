package entity;

import java.util.Objects;

public class User {
    private Integer id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String eMail;
    private String country;
    private String telNumber;

    public User() {
    }

    public User(Integer id, String login, String password, String name, String surname, String eMail, String country, String telNumber) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.eMail = eMail;
        this.country = country;
        this.telNumber = telNumber;
    }

    public User(String login, String password, String name, String surname, String eMail, String country, String telNumber) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.eMail = eMail;
        this.country = country;
        this.telNumber = telNumber;
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

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(eMail, user.eMail) && Objects.equals(country, user.country) && Objects.equals(telNumber, user.telNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, name, surname, eMail, country, telNumber);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", eMail='" + eMail + '\'' +
                ", country='" + country + '\'' +
                ", telNumber='" + telNumber + '\'' +
                '}';
    }
}
