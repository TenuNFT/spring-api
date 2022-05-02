package com.tenunft.api.controller;

//import org.springframework.data.domain.Page;

import com.tenunft.api.response.GlobalResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BaseRestController<DTO> {

  @GetMapping("/{id}")
  GlobalResponse<DTO> getOneById(@PathVariable Long id);

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("")
  GlobalResponse<DTO> postOne(@RequestBody DTO data);

  @PutMapping("/{id}")
  GlobalResponse<DTO> putOneById(@RequestBody DTO data, @PathVariable Long id);

  @GetMapping("/all")
  GlobalResponse<List<DTO>> getAll();

  @GetMapping("/page")
  GlobalResponse<Page<DTO>> getAllPageable(@RequestParam(defaultValue = "0") Integer page,
                                           @RequestParam(defaultValue = "100") Integer size,
                                           @RequestParam(defaultValue = "id") String sort);

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  void deleteOneById(@PathVariable Long id);

}
