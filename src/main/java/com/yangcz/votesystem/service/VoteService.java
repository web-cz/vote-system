package com.yangcz.votesystem.service;

import com.yangcz.votesystem.common.dto.VoteRecordRequest;

public interface VoteService {
    void vote(Integer itemId, VoteRecordRequest voteRecoedRequest);
}
