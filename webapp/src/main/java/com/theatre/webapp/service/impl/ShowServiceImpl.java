package com.theatre.webapp.service.impl;


import com.theatre.webapp.domain.Show;
import com.theatre.webapp.domain.ShowReview;
import com.theatre.webapp.dto.ShowEditDto;
import com.theatre.webapp.dto.ShowInsertDto;
import com.theatre.webapp.dto.ShowViewDto;
import com.theatre.webapp.repository.PagingRepository;
import com.theatre.webapp.repository.ReviewRepository;
import com.theatre.webapp.repository.ShowRepository;
import com.theatre.webapp.service.ShowService;

import com.theatre.webapp.transformer.EditTransformer;
import com.theatre.webapp.transformer.InsertTransformer;
import com.theatre.webapp.transformer.ShowToShowViewDtoTransformer;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;
    private final ReviewRepository reviewRepository;
    private final PagingRepository pagingRepository;
    private final ShowToShowViewDtoTransformer transformer;
    private final InsertTransformer showInsertDtoTransformer;
    private final EditTransformer editTransformer;


    public ShowServiceImpl(ShowRepository showRepository,
                           ReviewRepository reviewRepository, PagingRepository pagingRepository,
                           ShowToShowViewDtoTransformer transformer,
                           InsertTransformer showInsertDtoTransformer,
                           EditTransformer editTransformer1) {
        this.showRepository = showRepository;
        this.reviewRepository = reviewRepository;
        this.pagingRepository = pagingRepository;
        this.transformer = transformer;
        this.showInsertDtoTransformer = showInsertDtoTransformer;
        this.editTransformer = editTransformer1;
    }


    @Override
    public List<ShowViewDto> getAll() {
        List<ShowViewDto> showViewList = new ArrayList<>();
        showRepository
                .findAll()
                .forEach(show -> showViewList.add(transformer.entityToDto(show)));
        return showViewList;
    }


    @Override
    public Show addShow(ShowInsertDto showInsertDto) {
        Show show = showInsertDtoTransformer.convertToEntity(showInsertDto);
        showRepository.save(show);
        return show;
    }

    @Override
    public ShowReview addShowReview(ShowInsertDto showInsertDto) {
        ShowReview showReview = showInsertDtoTransformer.convertToEntityReview(showInsertDto);
        reviewRepository.save(showReview);
        return showReview;
    }

    @Override
    public ShowReview addReview(ShowInsertDto showInsertDto) {
        ShowReview showReview = showInsertDtoTransformer.convertToEntityReview(showInsertDto);
        return showReview;
    }


    @Override
    public List<Show> search(Optional<String> show_name) {

        return showRepository.findAllByShow_name(show_name.orElse("_"));
    }

    @Override
    public ShowEditDto editShow(ShowEditDto showEditDto) {

        Show show = editTransformer.DtoToEntity(showEditDto);
        showRepository.save(show);
        return editTransformer.entityToDto(show);
    }

    @Override
    public ShowViewDto getShowByID(int id) {
        Show show = showRepository.findById(id).get();
        return transformer.entityToDto(show);
    }

    @Override
    public ShowViewDto getOne(int id) {
        Show show = showRepository.getOne(id);
        return transformer.entityToDto(show);
    }

    @Override
    public void delete(int id) {
        showRepository.deleteById(id);
    }


    @Override
    public Page<ShowViewDto> listAll(int i) {
        Pageable pageable = PageRequest.of(i - 1, 2);

        List<ShowViewDto> showViewList = new ArrayList<>();
        pagingRepository
                .findAll(pageable)
                .forEach(show -> showViewList.add(transformer.entityToDto(show)));
        return (Page<ShowViewDto>) showViewList;

    }


//    @Override
//    public Page<Show> findPage() {
//        List<Show> showList = new ArrayList<>();
//        Pageable pageable = PageRequest.of(0, 1);
//        return pagingRepository.findAll(pageable);
//    }


}
