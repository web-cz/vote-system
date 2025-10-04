package com.yangcz.votesystem.dao;

import com.yangcz.votesystem.common.dto.VoteRecordRequest;

public interface VoteRecordDao {
    void createVoteRecord(Integer itemId, VoteRecordRequest voteRecordRequest);
}
