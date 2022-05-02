package com.tenunft.api.model.entity;

import com.tenunft.api.model.BaseModel;
import com.tenunft.api.model.OnChainDetails;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author : Kneotrino
 * @since : 02/05/2022
 **/
@Getter
@Setter
@Entity
@Table(name = "non_fungible_token_model", schema = "tenunft")
public class NonFungibleTokenModel extends BaseModel {
    @Embedded
    private OnChainDetails onChainDetails;

    private BigDecimal latestPrice;

    @Column(nullable = false)
    private BigDecimal basePrice;

    @Column(nullable = false)
    private String description;

    @Column(length = 256, nullable = false)
    private String creator;

//    private List<String> tags;

}
