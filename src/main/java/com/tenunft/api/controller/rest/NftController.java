package com.tenunft.api.controller.rest;

import com.tenunft.api.controller.BaseRestController;
import com.tenunft.api.model.entity.NonFungibleTokenModel;
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
public class NftController implements BaseRestController<NonFungibleTokenModel> {

    @Autowired
    NonFungibleTokenService service;

    @Override
    public GlobalResponse<NonFungibleTokenModel> getOneById(Long id) {
        return new GlobalResponse<>(service.fetchById(id));
    }

    @Override
    public GlobalResponse<NonFungibleTokenModel> postOne(NonFungibleTokenModel data) {
        return new GlobalResponse<>(service.insertOne(data));
    }

    @Override
    public GlobalResponse<NonFungibleTokenModel> putOneById(NonFungibleTokenModel data, Long id) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Method not implement");
    }

    @Override
    public GlobalResponse<List<NonFungibleTokenModel>> getAll() {
        return new GlobalResponse<>(service.fetchAll());
    }

    @Override
    public GlobalResponse<Page<NonFungibleTokenModel>> getAllPageable(Integer page, Integer size, String sort) {
        Page<NonFungibleTokenModel> fetchPageable = service.fetchPageable(PageRequest.of(page, size, Sort.by(sort)));
        return new GlobalResponse<>(fetchPageable);
    }

    @Override
    public void deleteOneById(Long id) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Method not implement");
    }
}
