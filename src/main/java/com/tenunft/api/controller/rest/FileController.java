package com.tenunft.api.controller.rest;

import com.tenunft.api.controller.BaseRestController;
import com.tenunft.api.dto.FileItemDto;
import com.tenunft.api.response.GlobalResponse;
import com.tenunft.api.service.FileItemService;
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
@RequestMapping("/api/file")
public class FileController implements BaseRestController<FileItemDto> {

    @Autowired
    FileItemService service;

    @Override
    public GlobalResponse<FileItemDto> getOneById(Long id) {
        return new GlobalResponse<>(service.fetchById(id));
    }

    @Override
    public GlobalResponse<FileItemDto> postOne(FileItemDto data) {
        FileItemDto dto = service.insertOne(data).constructDto(FileItemDto.class);
        return new GlobalResponse<>(dto);
    }

    @Override
    public GlobalResponse<FileItemDto> putOneById(FileItemDto data, Long id) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Method not implement");
    }

    @Override
    public GlobalResponse<List<FileItemDto>> getAll() {
        return new GlobalResponse<>(service.fetchAll());
    }

    @Override
    public GlobalResponse<Page<FileItemDto>> getAllPageable(Integer page, Integer size, String sort) {
        Page<FileItemDto> fetchPageable = service.fetchPageable(PageRequest.of(page, size, Sort.by(sort)));
        return new GlobalResponse<>(fetchPageable);
    }

    @Override
    public void deleteOneById(Long id) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Method not implement");
    }
}
