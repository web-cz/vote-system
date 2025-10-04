package com.yangcz.votesystem.dao.impl;

import com.yangcz.votesystem.dao.VoteItemDao;
import com.yangcz.votesystem.dto.VoteItemRequest;
import com.yangcz.votesystem.model.VoteItem;
import com.yangcz.votesystem.rowmapper.VoteItemRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.Date;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class VoteItemDaoImpl implements VoteItemDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public VoteItem getVoteItemById(Integer itemId) {
        String sql = "CALL get_vote_item(:itemId)";

        Map<String, Object> map = new HashMap<>();
        map.put("itemId", itemId);

        List<VoteItem> voteItemList = namedParameterJdbcTemplate.query(sql, map, new VoteItemRowMapper());

        if(voteItemList.size() > 0)
            return voteItemList.get(0);
        else
            return null;
    }

    @Override
    public List<VoteItem> getAllVoteItems() {
        String sql = "CALL get_all_vote_items()";
        return namedParameterJdbcTemplate.query(sql, Collections.emptyMap(), new VoteItemRowMapper());
    }

    @Override
    public Integer getTotalForUpdate(Integer itemId) {
        String sql = "CALL get_vote_item_for_update(:itemId)";
        Map<String, Object> map = new HashMap<>();
        map.put("itemId", itemId);

        List<VoteItem> voteItemList = namedParameterJdbcTemplate.query(sql, map, new VoteItemRowMapper());

        if(voteItemList.size() > 0)
            return voteItemList.get(0).getItemTotal();
        else
            return null;
    }

    @Override
    public Integer createVoteItem(VoteItemRequest voteItemRequest) {

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("insert_vote_item")
                .declareParameters(
                        new SqlParameter("p_item_name", Types.VARCHAR),
                        new SqlParameter("p_item_created_time", Types.TIMESTAMP),
                        new SqlParameter("p_item_last_modified_time", Types.TIMESTAMP),
                        new SqlOutParameter("p_item_id", Types.INTEGER)
                );

        Map<String, Object> map = new HashMap<>();
        map.put("p_item_name", voteItemRequest.getItemName());
        Date now = new Date();
        map.put("p_item_created_time", now);
        map.put("p_item_last_modified_time", now);

        Map<String, Object> result = jdbcCall.execute(map);
        Integer itemId = (Integer) result.get("p_item_id");

        return itemId;
    }

    @Override
    public void updateVoteItem(Integer itemId, VoteItemRequest voteItemRequest) {
        String sql = "CALL update_vote_item(:itemId, :itemName, :itemLastModifiedTime)";

        Map<String, Object> map = new HashMap<>();
        map.put("itemId", itemId);
        map.put("itemName", voteItemRequest.getItemName());
        Date now = new Date();
        map.put("itemLastModifiedTime", now);

        namedParameterJdbcTemplate.update(sql, map);
    }
}
