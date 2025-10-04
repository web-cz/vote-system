package com.yangcz.votesystem.service.impl;

import com.yangcz.votesystem.dao.VoteItemDao;
import com.yangcz.votesystem.common.dto.VoteItemRequest;
import com.yangcz.votesystem.common.exception.ConflictException;
import com.yangcz.votesystem.common.exception.ResourceNotFoundException;
import com.yangcz.votesystem.common.model.VoteItem;
import com.yangcz.votesystem.service.VoteItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VoteItemServiceImpl implements VoteItemService {

    @Autowired
    private VoteItemDao voteItemDao;

    //根據Id查詢單筆投票項目
    @Override
    public VoteItem getVoteItemById(Integer itemId) {
        return voteItemDao.getVoteItemById(itemId);
    }

    //查詢所有投票項目
    @Override
    public List<VoteItem> getAllVoteItems() {
        return voteItemDao.getAllVoteItems();
    }

    //新增一筆投票項目
    @Override
    public Integer createVoteItem(VoteItemRequest voteItemRequest) {
        return voteItemDao.createVoteItem(voteItemRequest);
    }

    /*  修改投票項目
        1.票數為0才可修改項目名稱
        2.修改時其他人無法投票
    */
    @Transactional
    @Override
    public void updateVoteItem(Integer itemId, VoteItemRequest voteItemRequest) {
        Integer total = voteItemDao.getTotalForUpdate(itemId);
        if(total == null)
            throw new ResourceNotFoundException("投票項目不存在");
        else if(total > 0)
            throw new ConflictException("該項目已有投票，不能修改");
        else
            voteItemDao.updateVoteItem(itemId, voteItemRequest);
    }
}
