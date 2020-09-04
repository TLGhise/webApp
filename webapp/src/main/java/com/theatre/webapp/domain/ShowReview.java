package com.theatre.webapp.domain;

import com.theatre.webapp.dto.ShowViewDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "review")
public class ShowReview {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String reviewDetails;


}
