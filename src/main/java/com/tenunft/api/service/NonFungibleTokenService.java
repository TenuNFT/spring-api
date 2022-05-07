package com.tenunft.api.service;

import com.tenunft.api.dto.NftDto;
import com.tenunft.api.model.BaseModel;
import com.tenunft.api.model.entity.FileItemModel;
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
import java.util.stream.Collectors;

/**
 * @author : Kneotrino
 * @since : 02/05/2022
 **/
@Slf4j
@Service
public class NonFungibleTokenService implements BaseService<NftDto, NonFungibleTokenModel> {

    @Autowired
    NonFungibleTokenRepo repo;

    @Override
    public List<NftDto> fetchAll() {
        List<NftDto> collect = repo
                .findAll()
                .stream()
                .map(NftDto::constructDto)
                .collect(Collectors.toList());
        log.info("collect.size() = {}", collect.size());
        return collect;
    }

    @Override
    public Page<NftDto> fetchPageable(Pageable pageable) {
        Page<NftDto> collect = repo
                .findByEnabledTrue(pageable)
                .map(NftDto::constructDto);
        log.info("pageable = {}", pageable);
        return collect;
    }


    @Override
    public NftDto fetchById(Long id) {
        Optional<NonFungibleTokenModel> model = repo.findById(id);
        if (model.isPresent()) {
            log.info("Success fetch by id = {}", id);
            return NftDto.constructDto(model.get());
        } else {
            log.error("Failed fetch by id = {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data not found");
        }
    }

    @Override
    public NonFungibleTokenModel insertOne(NftDto nftDto) {
        NonFungibleTokenModel inserted =
                repo.save(nftDto.constructModel(NonFungibleTokenModel.class));
        log.info("Success inserted = {}", inserted);
        return inserted;
    }

    @Override
    public NonFungibleTokenModel updateOne(NftDto nftDto, Long id) {
        Optional<NonFungibleTokenModel> fromDb = repo.findById(id);
        if (fromDb.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Failed update, ID not found: " + id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not implemented, ID not found: " + id);
        }
    }

    @Override
    public NonFungibleTokenModel deleteOne(NftDto dto, Long id) {
        Optional<NonFungibleTokenModel> fromDb = repo.findById(id);
        if (fromDb.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Failed update, ID not found: " + id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not implemented, ID not found: " + id);
        }
    }

    @Override
    public Long countByEnabledTrue() {
        return repo.countByEnabledTrue();
    }

    private List<String> toResource(List<FileItemModel> list) {
        return list
                .stream()
                .map(BaseModel::getUuid)
                .collect(Collectors.toList());
    }

}
