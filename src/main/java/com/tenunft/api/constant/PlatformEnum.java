package com.tenunft.api.constant;

/**
 * @author : Kneotrino
 * @since : 02/05/2022
 **/
public enum PlatformEnum {
    ETH("Ethereum"),
    BSC("Binance Smart Chain"),
    MATIC("Polygon Chain"),
    HT("Houbi ECO Chain"),
    AVAX("Avalanche Chain"),
    FTM("Fantom Opera Chain"),
    ONE("Harmony Chain");

    public final String blockchain;

    private PlatformEnum(String label) {
        this.blockchain = label;
    }

}
