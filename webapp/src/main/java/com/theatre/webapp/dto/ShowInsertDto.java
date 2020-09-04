package com.theatre.webapp.dto;

import com.theatre.webapp.domain.ShowReview;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ShowInsertDto {

    private int id;
    private String show_name;
    private int date;
    private int hour;
    private String description;
    private Set<ShowReview> showReviewSet;


//    private GenreDto genre;
}