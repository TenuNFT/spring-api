package com.tenunft.api.response;

import com.fasterxml.jackson.annotation.*;
import com.tenunft.api.constant.AppConstant;
import com.tenunft.api.dto.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author : Kneotrino
 * @since : 29/07/2021
 **/
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class GlobalResponse<T> extends BaseDto {

    private int result = AppConstant.SUCCESS;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date dateTime;
    private String message;
    private T content;

    public GlobalResponse(T content) {
        setDateTime(new Date());
        setContent(content);
    }

    public GlobalResponse(T content, String message) {
        setDateTime(new Date());
        setContent(content);
        setMessage(message);
    }

    public GlobalResponse() {
        setDateTime(new Date());
    }


}
