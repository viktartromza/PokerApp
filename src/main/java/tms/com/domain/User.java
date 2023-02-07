package tms.com.domain;

import jdk.jfr.DataAmount;
import lombok.Data;

import java.sql.Date;

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
}
