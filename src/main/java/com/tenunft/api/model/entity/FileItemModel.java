package com.tenunft.api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tenunft.api.constant.AppEnum;
import com.tenunft.api.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author : Kneotrino
 * @since : 03/05/2022
 **/
@Getter
@Setter
@Entity
@Table(name = "file_item", schema = "tenunft")
public class FileItemModel extends BaseModel {

    @Column(nullable = false)
    private String path;
    @Column(nullable = false)
    private AppEnum.TYPE type;
    @Column(nullable = false)
    private AppEnum.SOURCE source;

    //Optional
    private String name;
    private String description;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nft_id", nullable = false)
    private NonFungibleTokenModel nft;
}
