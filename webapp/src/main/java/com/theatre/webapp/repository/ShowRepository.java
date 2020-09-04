package com.theatre.webapp.repository;

import com.theatre.webapp.domain.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {

//    @Query(value = "SELECT show_name FROM Show WHERE show_name LIKE '%keyword%' ")
//    List<Show> search(@Param("keyword") String keyword);

    @Query(value = "SELECT show_name FROM Show WHERE show_name LIKE '%keyword%' ")
    List<Show>findAllByShow_name(String show_name);


}
