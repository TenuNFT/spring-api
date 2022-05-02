package com.tenunft.api.rest;

import com.tenunft.api.response.GlobalResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Kneotrino
 * @since : 02/05/2022
 **/
@CrossOrigin
@RestController
public class baseController {

    @GetMapping("/ping")
    public GlobalResponse<String> generateAllEmail() {
        return new GlobalResponse<>("Hello, World!");
    }

}
