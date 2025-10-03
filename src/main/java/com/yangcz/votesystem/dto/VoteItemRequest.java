package com.yangcz.votesystem.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class VoteItemRequest {

    @NotBlank
    private String itemName;


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
