package com.yangcz.votesystem.dao;

import com.yangcz.votesystem.dto.VoteItemRequest;
import com.yangcz.votesystem.model.VoteItem;

import java.util.List;

public interface VoteItemDao {

    VoteItem getVoteItemById(Integer itemId);
    List<VoteItem> getAllVoteItems();
    Integer createVoteItem(VoteItemRequest voteItemRequest);
}
