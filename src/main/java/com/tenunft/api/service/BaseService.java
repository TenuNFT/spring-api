package com.tenunft.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author : Kneotrino
 * @since : 02/05/2022
 **/
public interface BaseService<DTO> {
    List<DTO> fetchAll();

    Page<DTO> fetchPageable(Pageable pageable);

    DTO fetchById(Long id);

    DTO insertOne(DTO dto);

    DTO updateOne(DTO dto, Long id);

    Long countByEnabledTrue();

}
