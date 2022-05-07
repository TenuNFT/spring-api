package com.tenunft.api.service;

import com.tenunft.api.dto.FileItemDto;
import com.tenunft.api.model.entity.FileItemModel;
import com.tenunft.api.repository.FileItemRepo;
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
public class FileItemService implements BaseService<FileItemDto, FileItemModel> {

    @Autowired
    FileItemRepo repo;

    @Override
    public List<FileItemDto> fetchAll() {
        List<FileItemDto> collect = repo
                .findAll()
                .stream()
                .map(model -> model.constructDto(FileItemDto.class))
                .collect(Collectors.toList());
        log.info("collect.size() = {}", collect.size());
        return collect;
    }

    @Override
    public Page<FileItemDto> fetchPageable(Pageable pageable) {
        Page<FileItemDto> collect = repo
                .findByEnabledTrue(pageable)
                .map(model -> model.constructDto(FileItemDto.class));
        log.info("pageable = {}", pageable);
        return collect;
    }

    @Override
    public FileItemDto fetchById(Long id) {
        Optional<FileItemModel> model = repo.findById(id);
        if (model.isPresent()) {
            log.info("Success fetch by id = {}", id);
            return model.get().constructDto(FileItemDto.class);
        } else {
            log.error("Failed fetch by id = {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data not found");
        }
    }
    public FileItemDto fetchByUuid(String uuid) {
        Optional<FileItemModel> model = repo.findByUuid(uuid);
        if (model.isPresent()) {
            log.info("Success fetch by uuid = {}", uuid);
            return model.get().constructDto(FileItemDto.class);
        } else {
            log.error("Failed fetch by uuid = {}", uuid);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data not found");
        }
    }

    @Override
    public FileItemModel insertOne(FileItemDto FileItemDto) {
        FileItemModel inserted =
                repo.save(FileItemDto.constructModel(FileItemModel.class));
        log.info("Success inserted = {}", inserted);
        return inserted;
    }

    @Override
    public FileItemModel updateOne(FileItemDto FileItemDto, Long id) {
        Optional<FileItemModel> fromDb = repo.findById(id);
        if (fromDb.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Failed update, ID not found: " + id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not implemented, ID not found: " + id);
        }
    }

    @Override
    public FileItemModel deleteOne(FileItemDto dto, Long id) {
        Optional<FileItemModel> fromDb = repo.findById(id);
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

}
