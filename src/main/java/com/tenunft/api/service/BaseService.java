package com.tenunft.api.service;

import com.tenunft.api.dto.BaseDto;
import com.tenunft.api.model.BaseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author : Kneotrino
 * @since : 02/05/2022
 **/
public interface BaseService<DTO extends BaseDto, ENTITY extends BaseModel> {
    List<DTO> fetchAll();

    Page<DTO> fetchPageable(Pageable pageable);

    DTO fetchById(Long id);

    ENTITY insertOne(DTO dto);

    ENTITY updateOne(DTO dto, Long id);

    Long countByEnabledTrue();

}
