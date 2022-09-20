package com.example.libsys.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Table
public class Users {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long userID;
    private String name;
    private String email;
    private String address;
    private String status;
    private String membership;
    private Date validFrom;
    private Date validTo;
    @Transient //Will calculate it & not get it/store to DB TODO
    private Integer age;

    public Users() {

    }

    public Users(String name, String email, String address, String status, String membership, Date validFrom, Date validTo, Integer age) {
        //this.userID = userID;
        this.name = name;
        this.email = email;
        this.address = address;
        this.status = status;
        this.membership = membership;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public Integer getAge() {
        return Period.between(validFrom.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}