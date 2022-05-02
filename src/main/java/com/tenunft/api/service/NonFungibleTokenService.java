package com.tenunft.api.service;

import com.tenunft.api.model.entity.NonFungibleTokenModel;
import com.tenunft.api.repository.NonFungibleTokenRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * @author : Kneotrino
 * @since : 02/05/2022
 **/
@Slf4j
@Service
public class NonFungibleTokenService implements BaseService<NonFungibleTokenModel> {

    @Autowired
    NonFungibleTokenRepo repo;

    @Override
    public List<NonFungibleTokenModel> fetchAll() {
        return repo.findAllByEnabledTrue();
    }

    @Override
    public Page<NonFungibleTokenModel> fetchPageable(Pageable pageable) {
        log.info("fetch pageable = {}", pageable);
        return repo.findByEnabledTrue(pageable);
    }

    @Override
    public NonFungibleTokenModel fetchById(Long id) {
        Optional<NonFungibleTokenModel> model = repo.findById(id);
        if (model.isPresent()) {
            log.info("Success fetch by id = {}", id);
            return model.get();
        } else {
            log.error("Failed fetch by id = {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data not found");
        }
    }

    @Override
    public NonFungibleTokenModel insertOne(NonFungibleTokenModel nonFungibleTokenModel) {
        try {
            NonFungibleTokenModel result = repo.save(nonFungibleTokenModel);
            log.info("Success insert = {}", result);
            return result;
        } catch (Exception exception) {
            log.info("Failed to insert", exception);
            return null;
        }

    }

    @Override
    public NonFungibleTokenModel updateOne(NonFungibleTokenModel nonFungibleTokenModel, Long id) {
        return null;
    }

    @Override
    public Long countByEnabledTrue() {
        return repo.countByEnabledTrue();
    }

}
