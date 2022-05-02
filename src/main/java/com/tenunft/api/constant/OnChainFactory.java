package com.tenunft.api.constant;

import com.github.javafaker.Faker;
import com.tenunft.api.model.OnChainDetails;

/**
 * @author : Kneotrino
 * @since : 02/05/2022
 **/
public class OnChainFactory {

    public static Faker faker = new Faker();

    public static OnChainDetails createBSChain() {
        OnChainDetails onChainDetails = new OnChainDetails();
        onChainDetails.setContract("0x".concat(faker.crypto().sha1()));
        onChainDetails.setTokenId(faker.number().digit());
        onChainDetails.setTokenStandard(EIPEnum.ERC1155.toString());
        onChainDetails.setBlockChain(PlatformEnum.BSC.toString());
        return onChainDetails;
    }

    public static OnChainDetails createBSChain(EIPEnum eipEnum) {
        OnChainDetails onChainDetails = OnChainFactory.createBSChain();
        onChainDetails.setTokenStandard(eipEnum.toString());
        return onChainDetails;
    }
}
