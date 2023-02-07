package tms.com.domain;

import lombok.Data;

import java.sql.Date;

@Data
public class Game {
    private String type;
    private Date date;
}
