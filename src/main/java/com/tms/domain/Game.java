package com.tms.domain;

import lombok.Data;

import java.sql.Date;

@Data
public class Game {
    private int id;
    private String type;
    private Date date;
}
