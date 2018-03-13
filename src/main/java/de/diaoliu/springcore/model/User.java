package de.diaoliu.springcore.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private int id;
    private String email;
    private Date createdAt;

}
