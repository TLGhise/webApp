package com.theatre.webapp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class ShowEditDto {

    private int id;
    private String show_name;
    private int date;
    private int hour;
    private String description;

}
