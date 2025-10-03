package com.yangcz.votesystem.rowmapper;

import com.yangcz.votesystem.model.VoteItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VoteItemRowMapper implements RowMapper<VoteItem> {

    @Override
    public VoteItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        VoteItem voteItem = new VoteItem();
        voteItem.setItemId(rs.getInt("item_id"));
        voteItem.setItemName(rs.getString("item_name"));
        voteItem.setItemCreatedTime(rs.getTimestamp("item_created_time"));
        voteItem.setItemLastModifiedTime(rs.getTimestamp("item_last_modified_time"));

        return voteItem;
    }
}
