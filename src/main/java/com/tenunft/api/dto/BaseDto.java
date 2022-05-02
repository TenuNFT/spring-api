package com.tenunft.api.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.tenunft.api.helper.JsonUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Kneotrino
 * @since : 08/11/2021
 **/
public class BaseDto {
    @Override
    public String toString() {
        String value = null;
        try {
            value = JsonUtil.toString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return  value;
    }

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String key, Object value) {
        this.additionalProperties.put(key, value);
    }

    @JsonIgnore
    public void setLogs(Map<String, Object> logs) {
        setAdditionalProperty("logs", logs);
    }


}
