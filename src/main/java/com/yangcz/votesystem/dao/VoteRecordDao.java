package com.yangcz.votesystem.dao;

import com.yangcz.votesystem.dto.VoteRecordRequest;

public interface VoteRecordDao {
    void createVoteRecord(Integer itemId, VoteRecordRequest voteRecordRequest);
}
