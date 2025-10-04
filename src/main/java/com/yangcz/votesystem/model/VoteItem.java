package com.yangcz.votesystem.model;

import java.util.Date;

public class VoteItem {
    private Integer itemId;
    private String itemName;
    private Integer itemTotal;
    private Date itemCreatedTime;
    private Date itemLastModifiedTime;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(Integer itemTotal) {
        this.itemTotal = itemTotal;
    }

    public Date getItemCreatedTime() {
        return itemCreatedTime;
    }

    public void setItemCreatedTime(Date itemCreatedTime) {
        this.itemCreatedTime = itemCreatedTime;
    }

    public Date getItemLastModifiedTime() {
        return itemLastModifiedTime;
    }

    public void setItemLastModifiedTime(Date itemLastModifiedTime) {
        this.itemLastModifiedTime = itemLastModifiedTime;
    }
}
