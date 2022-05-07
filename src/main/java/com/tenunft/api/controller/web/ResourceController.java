package com.tenunft.api.controller.web;

import com.tenunft.api.dto.FileItemDto;
import com.tenunft.api.service.FileItemService;
import org.apache.commons.io.IOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author : Kneotrino
 * @since : 07/05/2022
 **/
@CrossOrigin
@Controller
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    FileItemService service;

    @GetMapping(
            value = "/{uuid}",
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
    )
    public ResponseEntity<Resource> getImage(@PathVariable String uuid) throws IOException {
        FileItemDto itemDto = service.fetchByUuid(uuid);
        Resource resource = new UrlResource(itemDto.getFile().toURI());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
