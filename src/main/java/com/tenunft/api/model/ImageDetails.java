package com.tenunft.api.model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.util.List;

/**
 * @author : Kneotrino
 * @since : 03/05/2022
 **/
@Embeddable
@Data
public class ImageDetails {

    private String serverImage;
    private String ipfsImage;
    private List<String> images;

}
