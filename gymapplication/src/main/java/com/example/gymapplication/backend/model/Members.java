package com.example.gymapplication.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.Date;

@Entity
@Table(name = "members")
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate the ID
    private Long id;

    @Column(name = "first_name") // Map the Java field to the database column
    private String firstName;

    @Column(name = "last_name")  // Map the Java field to the database column
    private String lastName;

    @Column(name = "email")  // Map the Java field to the database column
    private String email;

    @Column(name = "phone")  // Map the Java field to the database column
    private String phone;

    @Column(name = "join_date")  // Map the Java field to the database column
    private Date joinDate;

    @Column(name = "age")  // Map the Java field to the database column
    private int age;

    @Column(name = "name")  // Map the Java field to the database column
    private String name;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getIdAsString() {
        return id != null ? id.toString() : null;
    }

    public void setId(Long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
