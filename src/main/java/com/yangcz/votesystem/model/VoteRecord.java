package com.yangcz.votesystem.model;

import java.util.Date;

public class VoteRecord {
    private Integer recordId;
    private String voterName;
    private String voterNameNorm;
    private Integer itemId;
    private Date voteTime;

    public String getVoterNameNorm() {
        return voterNameNorm;
    }

    public void setVoterNameNorm(String voterNameNorm) {
        this.voterNameNorm = voterNameNorm;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Date getVoteTime() {
        return voteTime;
    }

    public void setVoteTime(Date voteTime) {
        this.voteTime = voteTime;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getVoterName() {
        return voterName;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }
}
