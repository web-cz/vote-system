package com.yangcz.votesystem.service;

import com.yangcz.votesystem.dto.VoteItemRequest;
import com.yangcz.votesystem.model.VoteItem;

import java.util.List;

public interface VoteItemService {
    VoteItem getVoteItemById(Integer itemId);
    List<VoteItem> getAllVoteItems();
    Integer createVoteItem(VoteItemRequest voteItemRequest);


}
