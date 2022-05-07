package com.tenunft.api.helper;

import com.github.javafaker.Faker;
import com.tenunft.api.constant.AppEnum;
import com.tenunft.api.constant.OnChainFactory;
import com.tenunft.api.model.entity.FileItemModel;
import com.tenunft.api.model.entity.NonFungibleTokenModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Kneotrino
 * @since : 07/05/2022
 **/
@Service
@Slf4j
public class DummyService {

    final static String IMAGE_SOURCE = "https://picsum.photos";
    final static Faker faker = new Faker();

    public NonFungibleTokenModel dummyNft() {
        NonFungibleTokenModel model = new NonFungibleTokenModel();
        model.setOnChainDetails(OnChainFactory.createBSChain());
        model.setBasePrice(BigDecimal.ONE);
        model.setLatestPrice(BigDecimal.valueOf(faker.number().randomDouble(2, 0, 10)));
        model.setDescription(faker.lorem().paragraph());
        model.setCreator(faker.funnyName().name());
        model.setCreatorWallet("0x".concat(faker.crypto().sha1()));
        model.setOwnerWallet("0x".concat(faker.crypto().sha1()));
        return model;
    }

    public FileItemModel dummyLocalFile() {
        String image = String.format("%s/%s/%s", IMAGE_SOURCE, 300, 300);
        FileItemModel model = new FileItemModel();
        model.setType(AppEnum.TYPE.MAIN);
        model.setSource(AppEnum.SOURCE.LOCAL);
        model.setName(faker.name().username().concat(".png"));
        model.setDescription(faker.lorem().sentence());
        File tempFile;
        try (InputStream in = new URL(image).openStream()) {
            tempFile = File.createTempFile(faker.internet().domainWord(), ".png");
            tempFile.delete();
            Files.copy(in, tempFile.toPath());
            log.info("tempFile = {}", tempFile.getPath());
            model.setPath(tempFile.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return model;
    }

    public List<FileItemModel> dummyListFile(int length, NonFungibleTokenModel dummyNft) {
        List<FileItemModel> sets = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            FileItemModel temp = dummyLocalFile();
            temp.setNft(dummyNft);
            sets.add(temp);
        }

        return sets;
    }

}
