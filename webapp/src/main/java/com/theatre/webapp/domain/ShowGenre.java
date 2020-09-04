package com.theatre.webapp.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class ShowGenre {
    @Id
    @Column
    @Enumerated(value = EnumType.STRING)
    private Genre name;


}
