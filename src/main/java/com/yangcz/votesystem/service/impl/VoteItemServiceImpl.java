package com.yangcz.votesystem.service.impl;

import com.yangcz.votesystem.dao.VoteItemDao;
import com.yangcz.votesystem.dto.VoteItemRequest;
import com.yangcz.votesystem.model.VoteItem;
import com.yangcz.votesystem.service.VoteItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteItemServiceImpl implements VoteItemService {

    @Autowired
    private VoteItemDao voteItemDao;

    @Override
    public VoteItem getVoteItemById(Integer itemId) {
        return voteItemDao.getVoteItemById(itemId);
    }

    @Override
    public List<VoteItem> getAllVoteItems() {
        return voteItemDao.getAllVoteItems();
    }

    @Override
    public Integer createVoteItem(VoteItemRequest voteItemRequest) {
        return voteItemDao.createVoteItem(voteItemRequest);
    }
}
