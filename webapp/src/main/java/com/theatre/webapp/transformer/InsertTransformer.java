package com.theatre.webapp.transformer;

import com.theatre.webapp.domain.ShowReview;
import com.theatre.webapp.dto.ShowViewDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import com.theatre.webapp.domain.Show;
import com.theatre.webapp.dto.ShowInsertDto;
import org.springframework.stereotype.Component;

@Component
public class InsertTransformer {

    public ShowInsertDto convertToDto(Show show) {
        ShowInsertDto showInsertDto = new ShowInsertDto();
        BeanUtils.copyProperties(show, showInsertDto);
        return showInsertDto;
    }

    public Show convertToEntity(ShowInsertDto showInsertDto ){
        ModelMapper modelMapper = new ModelMapper();
        Show show = new Show();
        modelMapper.map(showInsertDto, show);
        return show;
    }

    public ShowReview convertToEntityReview(ShowInsertDto showInsertDto ){
        ModelMapper modelMapper = new ModelMapper();
        ShowReview showReview = new ShowReview();
        modelMapper.map(showInsertDto, showReview);
        return showReview;
    }

}