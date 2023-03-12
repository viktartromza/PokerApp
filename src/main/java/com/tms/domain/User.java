package com.tms.domain;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
@Component
@Data
public class User {
    private int id;
    private String login;
    private String password;
    private Date regDate;
    private String email;
    private int score;

    private String firstName;
    private String lastName;
    private Date birthDay;
    private String telephone;
    private double balance;


    private Wallet wallet;


    public User(Wallet wallet) {
        this.wallet = wallet;
    }
    @Autowired
    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
