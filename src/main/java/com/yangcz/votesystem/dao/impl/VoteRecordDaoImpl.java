package com.yangcz.votesystem.dao.impl;

import com.yangcz.votesystem.dao.VoteRecordDao;
import com.yangcz.votesystem.dto.VoteItemRequest;
import com.yangcz.votesystem.dto.VoteRecordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class VoteRecordDaoImpl implements VoteRecordDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void createVoteRecord(Integer itemId, VoteRecordRequest voteRecordRequest) {
        String sql = "CALL insert_vote_record(:voterName, :itemId, :voteTime)";

        Map<String, Object> map = new HashMap<>();
        map.put("voterName", voteRecordRequest.getVoterName());
        map.put("itemId", itemId);

        Date now = new Date();
        map.put("voteTime", now);

        namedParameterJdbcTemplate.update(sql, map);
    }

}
