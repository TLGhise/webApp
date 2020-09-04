package com.theatre.webapp.repository;

import com.theatre.webapp.domain.Show;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface PagingRepository extends PagingAndSortingRepository<Show, Integer> {

 @Query("SELECT COUNT (s) from Show s") Long countShow();
}
