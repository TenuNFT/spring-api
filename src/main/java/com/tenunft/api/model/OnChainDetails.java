package com.tenunft.api.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tenunft.api.helper.JsonUtil;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author : Kneotrino
 * @since : 02/05/2022
 **/
@Embeddable
@Data
public class OnChainDetails {

    @Column(length = 128, nullable = false)
    private String contract;
    @Column(length = 128, nullable = false)
    private String tokenId;
    @Column(length = 128, nullable = false)
    private String tokenStandard;
    @Column(length = 128, nullable = false)
    private String blockChain;

    @Override
    public String toString() {
        String value = null;
        try {
            value = JsonUtil.toString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return value;
    }
}
