package com.tenunft.api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tenunft.api.model.BaseModel;
import com.tenunft.api.model.OnChainDetails;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

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

    @Column(length = 256, nullable = false)
    private String ownerWallet;

    @Column(length = 256)
    private String creatorWallet;

    @Column(length = 256)
    private String data;

    @JsonIgnore
    @OneToMany(mappedBy = "nft", cascade = CascadeType.ALL)
    private List<FileItemModel> items;
//    private List<String> tags;

}
