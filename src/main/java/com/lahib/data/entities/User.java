package com.lahib.data.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Adil on 3/14/2017.
 */
@Entity
@Table(name = "finances_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(name = "EMAIL_ADDRESS")
    private String email;

    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdatedate;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @OneToOne(mappedBy = "user")
    private Credential credential;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private List<Account> accounts = new ArrayList<Account>();

    public User() {
    }

    public User(int userId, String firstName, String lastName, Date birthDate, String email, Date lastUpdatedate, Date createdDate, String createdBy) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.lastUpdatedate = lastUpdatedate;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastUpdatedate() {
        return lastUpdatedate;
    }

    public void setLastUpdatedate(Date lastUpdatedate) {
        this.lastUpdatedate = lastUpdatedate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @PrePersist
    private void prePersist(){
        System.out.print("user with id : " + userId + " , name : " + firstName+" " +lastName);
        System.out.println(" is about to be saved");
    }


    @PostPersist
    private void afterPersist(){
        System.out.print("user with id : " + userId + " , name : " + firstName+" " +lastName);
        System.out.println(" was successfully saved");
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }
}
