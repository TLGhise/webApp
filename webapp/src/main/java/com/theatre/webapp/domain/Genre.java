package com.theatre.webapp.domain;

public enum Genre {
    COMEDIE("Comedie"),
    PANTOMIMA("Pantomima"),
    ROMANTA("Romanta"),
    TRAGEDIE("Tragedie"),
    TRAGICOMEDIE("Tragicomedie"),
    DRAMA("Drama");


    private final String option;

    Genre(String option) {
        this.option = option;
    }

}
