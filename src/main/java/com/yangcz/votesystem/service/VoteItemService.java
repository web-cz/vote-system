package com.yangcz.votesystem.service;

import com.yangcz.votesystem.common.dto.VoteItemRequest;
import com.yangcz.votesystem.common.model.VoteItem;

import java.util.List;

public interface VoteItemService {
    VoteItem getVoteItemById(Integer itemId);
    List<VoteItem> getAllVoteItems();
    Integer createVoteItem(VoteItemRequest voteItemRequest);
    void updateVoteItem(Integer itemId, VoteItemRequest voteItemRequest);


}
