package com.tenunft.api.repository;

import com.tenunft.api.helper.DummyService;
import com.tenunft.api.model.entity.FileItemModel;
import com.tenunft.api.model.entity.NonFungibleTokenModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author : Kneotrino
 * @since : 02/05/2022
 **/
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NonFungibleTokenRepoTest {

    @Autowired
    NonFungibleTokenRepo repo;

    @Autowired
    DummyService dummyService;

    @Test
    @Disabled
    void dummyTest() {

        for (int i = 0; i < 1; i++) {
            NonFungibleTokenModel dummyNft = dummyService.dummyNft();
            List<FileItemModel> list = dummyService.dummyListFile(3, dummyNft);
            dummyNft.setItems(list);
            log.info("dummyNft = {}", dummyNft);
            log.info("repo = {}", repo.save(dummyNft));
        }
    }
}