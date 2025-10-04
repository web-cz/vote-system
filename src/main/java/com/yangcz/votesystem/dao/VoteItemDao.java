package com.yangcz.votesystem.dao;

import com.yangcz.votesystem.dto.VoteItemRequest;
import com.yangcz.votesystem.model.VoteItem;

import java.util.List;

public interface VoteItemDao {

    VoteItem getVoteItemById(Integer itemId);
    List<VoteItem> getAllVoteItems();
    Integer getTotalForUpdate(Integer itemId);
    Integer createVoteItem(VoteItemRequest voteItemRequest);
    void updateVoteItem(Integer itemId, VoteItemRequest voteItemRequest);
    void incrementVoteTotal(Integer itemId);



}
