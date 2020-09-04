package com.theatre.webapp.transformer;

import com.theatre.webapp.domain.Show;
import com.theatre.webapp.dto.ShowEditDto;
import com.theatre.webapp.dto.ShowInsertDto;
import com.theatre.webapp.dto.ShowViewDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowToShowViewDtoTransformer {

    public ShowViewDto entityToDto(Show show) {
        ModelMapper modelMapper = new ModelMapper();
        ShowViewDto showViewDto = new ShowViewDto();
        modelMapper.map(show, showViewDto);
        return showViewDto;
    }

    public Show convertToEntity(ShowViewDto showViewDto) {
        ModelMapper modelMapper = new ModelMapper();
        Show show = new Show();
        modelMapper.map(showViewDto, show);
        return show;
    }

    public ShowViewDto entityToDtoSearch(String show) {
        ModelMapper modelMapper = new ModelMapper();
        ShowViewDto showViewDto = new ShowViewDto();
        modelMapper.map(show, showViewDto);
        return showViewDto;
    }

    public ShowViewDto keywordDto(String keyword) {
        ModelMapper modelMapper = new ModelMapper();
        ShowViewDto showViewDto = new ShowViewDto();
        Show show = new Show();
        modelMapper.map(keyword, showViewDto);
        modelMapper.map(show, showViewDto);
        showViewDto.setShow_name(show.getShow_name());
        return showViewDto;
    }

}
