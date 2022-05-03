package com.tenunft.api.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.text.SimpleDateFormat;

/**
 * @author : Kneotrino
 * @since : 02/05/2022
 **/
public class JsonUtil {

    private static ModelMapper modelMapper = null;
    private static SimpleDateFormat sdf = null;
    private static ObjectMapper objectMapper = null;

    public static ModelMapper GetDefaultModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        }
        return modelMapper;
    }


    public static SimpleDateFormat getSimpleDateFormat() {
        if (sdf == null) {
            sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        }
        return sdf;
    }


    public static ObjectMapper getDefaultModelMapper() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.setDateFormat(getSimpleDateFormat());
        }
        return objectMapper;
    }

    public static String toString(Object object) throws JsonProcessingException {
        return getDefaultModelMapper().writeValueAsString(object);
    }

}
