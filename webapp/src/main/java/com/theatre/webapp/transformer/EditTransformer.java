package com.theatre.webapp.transformer;

import com.theatre.webapp.domain.Show;
import com.theatre.webapp.dto.ShowEditDto;
import com.theatre.webapp.dto.ShowViewDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EditTransformer {

    public Show DtoToEntity(ShowEditDto showEditDto ){
        ModelMapper modelMapper = new ModelMapper();
        Show show = new Show();
        modelMapper.map(showEditDto, show);
        return show;
    }

    public ShowEditDto entityToDto(Show show) {
        ModelMapper modelMapper = new ModelMapper();
        ShowEditDto showEditDto = new ShowEditDto();
        modelMapper.map(show, showEditDto);
        return showEditDto;
    }
}
