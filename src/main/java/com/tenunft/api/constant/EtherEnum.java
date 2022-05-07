package com.tenunft.api.constant;

/**
 * @author : Kneotrino
 * @since : 02/05/2022
 **/
public enum EtherEnum {
    ERC20("Token Standard"),
    ERC721("Non-Fungible Token Standard"),
    ERC1155("Multi Token Standard"),
    ERC1559("Fee market change for ETH 1.0 chain");

    public final String blockchain;

    private EtherEnum(String label) {
        this.blockchain = label;
    }

}
