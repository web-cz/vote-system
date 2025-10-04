package com.yangcz.votesystem.service.impl;

import com.yangcz.votesystem.dao.VoteItemDao;
import com.yangcz.votesystem.dao.VoteRecordDao;
import com.yangcz.votesystem.dto.VoteRecordRequest;
import com.yangcz.votesystem.exception.ConflictException;
import com.yangcz.votesystem.exception.ResourceNotFoundException;
import com.yangcz.votesystem.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteRecordDao voteRecordDao;

    @Autowired
    private VoteItemDao voteItemDao;


    /* 進行投票
       1.外來鍵限制投票的項目
       2.相同的人無法對相同項目重複投票(但可多選)
   */
    @Transactional
    @Override
    public void vote(Integer itemId, VoteRecordRequest voteRecoedRequest) {
        try {
            voteRecordDao.createVoteRecord(itemId, voteRecoedRequest);
            voteItemDao.incrementVoteTotal(itemId);
        } catch(DuplicateKeyException e){
            throw new ConflictException("該姓名已對此項目投過票");
        } catch (DataIntegrityViolationException e) {
            throw new ResourceNotFoundException("投票項目不存在");
        }
    }
}
