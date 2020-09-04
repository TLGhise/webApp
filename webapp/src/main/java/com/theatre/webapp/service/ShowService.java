package com.theatre.webapp.service;

import com.theatre.webapp.domain.Show;
import com.theatre.webapp.domain.ShowReview;
import com.theatre.webapp.dto.ShowEditDto;
import com.theatre.webapp.dto.ShowInsertDto;
import com.theatre.webapp.dto.ShowViewDto;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Validated
public interface ShowService {

    @Transactional(readOnly = true)
    List<ShowViewDto> getAll();

    public Show addShow(ShowInsertDto showInsertDto);

    public ShowReview addShowReview(ShowInsertDto showInsertDto);

    public ShowEditDto editShow(ShowEditDto showEditDto);

    public ShowViewDto getShowByID(int id);

    public ShowViewDto getOne(int id);

    public void delete(int id);

    public ShowReview addReview(ShowInsertDto showInsertDto);

    public Page<ShowViewDto> listAll(int i);

    public List<Show> search(Optional<String> show_name);


//
//    public Page<Show> findPage();
}
