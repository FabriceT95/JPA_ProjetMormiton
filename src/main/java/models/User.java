package models;

import jakarta.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName;
    private String firstName;
    private String email;
    private String pwd;

    public User(Long id_user, String lastName, String firstName, String email) {
        this.id = id_user;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }

    public User(String lastName, String firstName, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }

    public User() {

    }

    public Long getId_user() {
        return id;
    }

    public void setId_user(Long id_user) {
        this.id = id_user;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
