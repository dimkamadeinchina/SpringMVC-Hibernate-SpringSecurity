package com.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "history")
public class Record implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="username", insertable = false, updatable = false)
    private User user;

    @Column(name = "phone_number", nullable = false, length = 40)
    private String phoneNumber;

    @Column(name = "amount")
    private Integer amount;

    /*HERE  ???????????????????????????????????????????????????????*/
    @Column(name = "username")
    private String username;

    @Column(name = "id_company")
    private Integer id_company;
    /*HERE  ???????????????????????????????????????????????????????*/

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id", insertable = false, updatable = false)
    private Company company;

    @Column(name = "amount_date")
    @Temporal(value=TemporalType.DATE)
    private Date date;

    public Record(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId_company(Integer id_company) {
        this.id_company = id_company;
    }
}
