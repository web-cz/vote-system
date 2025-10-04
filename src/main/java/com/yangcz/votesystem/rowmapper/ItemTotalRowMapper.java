package com.yangcz.votesystem.rowmapper;

import com.yangcz.votesystem.model.VoteItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemTotalRowMapper implements RowMapper<VoteItem> {
    @Override
    public VoteItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        VoteItem voteItem = new VoteItem();

        voteItem.setItemTotal(rs.getInt("item_total"));
        return voteItem;
    }
}
