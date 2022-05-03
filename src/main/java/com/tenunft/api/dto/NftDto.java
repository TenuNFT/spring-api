package com.tenunft.api.dto;

import com.tenunft.api.model.OnChainDetails;
import com.tenunft.api.model.entity.NonFungibleTokenModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @author : Kneotrino
 * @since : 02/05/2022
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class NftDto extends BaseDto<NonFungibleTokenModel> {
    private OnChainDetails onChainDetails;
    private BigDecimal latestPrice;
    private BigDecimal basePrice;
    private String creatorWallet;
    private String ownerWallet;
    private String description;
    private String creator;
    private String uuid;
    private Long id;

//    private List<String> tags;

}
