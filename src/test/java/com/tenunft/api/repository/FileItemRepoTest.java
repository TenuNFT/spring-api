package com.tenunft.api.repository;

import com.github.javafaker.Faker;
import com.tenunft.api.model.entity.FileItemModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;

/**
 * @author : Kneotrino
 * @since : 03/05/2022
 **/
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FileItemRepoTest {

    @Autowired
    FileItemRepo repo;

    @Test
//    @Disabled
    void InitItemModel() {
        Faker faker = new Faker();
        String image = String.format("https://picsum.photos/%s/%s", 300, 300);
        FileItemModel itemModel = new FileItemModel();
        itemModel.setIpfsId("");
        itemModel.setName(faker.name().username());
        itemModel.setDescription(faker.lorem().sentence());
        File tempFile;
        try (InputStream in = new URL(image).openStream()) {
            tempFile = File.createTempFile(faker.internet().domainWord(), ".png");
            tempFile.delete();
            Files.copy(in, tempFile.toPath());
            log.info("tempFile = {}", tempFile.getPath());
            itemModel.setFilePath(tempFile.getPath());
            itemModel.setIpfsId(faker.crypto().sha1());
            repo.save(itemModel);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}