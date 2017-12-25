package jdev.server.dao;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "ID")
    int id;

    @Column(name = "FIRST_NAME", nullable = false)
    String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    String lastName;

    @Column(name = "PATRONYMIC")
    String patronymic;

    @Column(name = "DATE_OF_BIRTH", nullable = false)
    String dateOfBirth;

    @Column(name = "DRIVERS_LICENSE", length = 10, nullable = false)
    Long driversLicense;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Role.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "ROLE")
    Role role;



    public User() {
    }

    public User(Integer id, String firstName, String lastName, String patronymic, String dateOfBirth,
                Long driversLicense, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.driversLicense = driversLicense;
        this.role = role;
    }


    public String toString() {
        return "User{ id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", patronymic=" + patronymic
                + ", dateOfBirth=" + dateOfBirth + ", " + "driversLicense=" + driversLicense + ", role=" + role + " }";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(Long driversLicense) {
        this.driversLicense = driversLicense;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
