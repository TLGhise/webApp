package com.theatre.webapp.dto;

import com.theatre.webapp.domain.ShowReview;
import lombok.*;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowViewDto {

    private int id;
    private String show_name;
    private int date;
    private int hour;
    private String description;
    private Set<ShowReview> showReviewSet;


}
