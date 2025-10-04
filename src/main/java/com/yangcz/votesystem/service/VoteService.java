package com.yangcz.votesystem.service;

import com.yangcz.votesystem.dto.VoteRecordRequest;

public interface VoteService {
    void vote(Integer itemId, VoteRecordRequest voteRecoedRequest);
}
