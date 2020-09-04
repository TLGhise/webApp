package com.theatre.webapp.repository;

import com.theatre.webapp.domain.ShowReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ShowReview, Integer> {

//    List<ShowReview> findByShowId(Integer showId);
}
