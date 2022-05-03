package com.tenunft.api.model.entity;

import com.tenunft.api.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author : Kneotrino
 * @since : 03/05/2022
 **/
@Getter
@Setter
@Entity
@Table(name = "image_model", schema = "tenunft")
public class FileItemModel extends BaseModel {

    @Column(nullable = false)
    private String filePath;
    @Column(nullable = false)
    private String ipfsId;

    private String name;
    private String description;

}
