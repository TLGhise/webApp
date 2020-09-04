package com.theatre.webapp.transformer;

import com.theatre.webapp.domain.Show;
import com.theatre.webapp.dto.ShowViewDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ShowViewDtoToShowTransformer {

    public Show convertToEntity(Show showViewDto){
        ModelMapper modelMapper = new ModelMapper();

        Show show = new Show();

        modelMapper.map(showViewDto, show);

        return show;
    }

}
