package com.theatre.webapp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;


@Setter
@Getter
@Entity
@Table(name = "shows", uniqueConstraints = @UniqueConstraint(columnNames = {"hour"}))
public class Show {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, unique = true)
    private String show_name;


    @Column(nullable = false)
    private int date;

    @Column(nullable = false)
    private int hour;

    @Column
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name ="show_to_show_genre",
            joinColumns = {@JoinColumn(name = "show_id")},
            inverseJoinColumns = {@JoinColumn(name = "show_genre_id")})
    private Set<ShowGenre> showGenre;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name ="show_to_review",
            joinColumns = {@JoinColumn(name = "show_id")},
            inverseJoinColumns = {@JoinColumn(name = "review_id")})
    private Set<ShowReview> showReviewSet;


//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="show_id")
//    private Set<ShowReview> bookReviewSet;



}
