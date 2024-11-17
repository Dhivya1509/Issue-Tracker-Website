package com.project.leebugzz.row.mapper;

 

import java.sql.ResultSet;
import java.sql.SQLException;

 

import org.springframework.jdbc.core.RowMapper;

 

import com.project.leebugzz.model.MessageEntity;

 

public class MessageRowMapper implements RowMapper<MessageEntity> {

 

    @Override
    public MessageEntity mapRow(ResultSet rs, int row) throws SQLException {
        return new MessageEntity(rs.getInt("messageId"), rs.getInt("ticketId"), rs.getString("authorName"),
                rs.getString("recepientName"), rs.getString("text"), rs.getDate("createDate"));
    }
}