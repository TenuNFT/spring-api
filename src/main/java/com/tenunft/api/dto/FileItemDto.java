package com.tenunft.api.dto;

import com.tenunft.api.model.entity.FileItemModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Kneotrino
 * @since : 03/05/2022
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class FileItemDto extends BaseDto<FileItemModel> {

    private String filePath;
    private String name;
    private String description;
    private String ipfsId;
    private String uuid;
    private Long id;


}
