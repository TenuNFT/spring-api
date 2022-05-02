package com.tenunft.api.repository;

import com.github.javafaker.Faker;
import com.tenunft.api.constant.OnChainFactory;
import com.tenunft.api.model.entity.NonFungibleTokenModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * @author : Kneotrino
 * @since : 02/05/2022
 **/
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NonFungibleTokenRepoTest {

    @Autowired
    NonFungibleTokenRepo repo;

    @Test
    void InitDatabase() {
        Faker faker = new Faker();

        for (int i = 0; i < 100; i++) {
            NonFungibleTokenModel nonFungibleToken = new NonFungibleTokenModel();
            nonFungibleToken.setOnChainDetails(OnChainFactory.createBSChain());
            nonFungibleToken.setBasePrice(BigDecimal.ONE);
            nonFungibleToken.setLatestPrice(BigDecimal.valueOf(faker.number().randomDouble(2, 0, 10)));
            nonFungibleToken.setDescription(faker.lorem().paragraph());
            nonFungibleToken.setCreator(faker.funnyName().name());
            NonFungibleTokenModel save = repo.save(nonFungibleToken);
            log.info("save = {}", save);
//            log.info("nonFungibleToken = {}", nonFungibleToken);
        }
    }
}