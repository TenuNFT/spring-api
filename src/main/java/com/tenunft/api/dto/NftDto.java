package com.tenunft.api.dto;

import com.tenunft.api.model.OnChainDetails;
import com.tenunft.api.model.entity.NonFungibleTokenModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

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
    private String data;
    private String uuid;
    private Long id;
    private List<String> resources;

    public static NftDto constructDto(NonFungibleTokenModel model) {
        NftDto dto = model.constructDto(NftDto.class);
        List<String> collect = model.getItems().stream()
                .map(fileItemModel -> ServletUriComponentsBuilder.fromCurrentServletMapping()
                        .path("resource/")
                        .path(fileItemModel.getUuid())
                        .toUriString()).collect(Collectors.toList());

        dto.setResources(collect);
        return dto;
    }

}
