package com.tenunft.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tenunft.api.constant.AppEnum;
import com.tenunft.api.model.entity.FileItemModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;

/**
 * @author : Kneotrino
 * @since : 03/05/2022
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class FileItemDto extends BaseDto<FileItemModel> {

    private String path;
    private AppEnum.TYPE type;
    private AppEnum.SOURCE source;
    //Optional
    private String name;
    private String description;
    private String uuid;
    private Long id;

    @JsonIgnore
    public File getFile() {
        File temp = null;
        if (this.getSource().equals(AppEnum.SOURCE.LOCAL)) {
            temp = new File(getPath());
        }
        return temp;
    }

    public String getUrl() {
        return ServletUriComponentsBuilder.fromCurrentServletMapping()
                .path("resource/")
                .path(getUuid())
                .toUriString();
    }
}
