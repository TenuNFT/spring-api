package com.tenunft.api.controller.rest;

import com.tenunft.api.controller.BaseRestController;
import com.tenunft.api.dto.NftDto;
import com.tenunft.api.response.GlobalResponse;
import com.tenunft.api.service.NonFungibleTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * @author : Kneotrino
 * @since : 02/05/2022
 **/
@CrossOrigin
@RestController
@RequestMapping("/api/nft")
public class NftController implements BaseRestController<NftDto> {

    @Autowired
    NonFungibleTokenService service;

    @Override
    public GlobalResponse<NftDto> getOneById(Long id) {
        return new GlobalResponse<>(service.fetchById(id));
    }

    @Override
    public GlobalResponse<NftDto> postOne(NftDto data) {
        NftDto dto = service.insertOne(data).constructDto(NftDto.class);
        return new GlobalResponse<>(dto);
    }

    @Override
    public GlobalResponse<NftDto> putOneById(NftDto data, Long id) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Method not implement");
    }

    @Override
    public GlobalResponse<List<NftDto>> getAll() {
        return new GlobalResponse<>(service.fetchAll());
    }

    @Override
    public GlobalResponse<Page<NftDto>> getAllPageable(Integer page, Integer size, String sort) {
        Page<NftDto> fetchPageable = service.fetchPageable(PageRequest.of(page, size, Sort.by(sort)));
        return new GlobalResponse<>(fetchPageable);
    }

    @Override
    public void deleteOneById(Long id) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Method not implement");
    }
}
