package com.project.leebugzz.row.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.leebugzz.model.TicketEntity;

public class TicketRowMapper implements RowMapper<TicketEntity>{

	@Override
	public TicketEntity mapRow(ResultSet rs, int row) throws SQLException {
		return new TicketEntity(rs.getInt("ticketId"), rs.getString("title"), rs.getString("createrName"),rs.getString("holderName"),rs.getDate("createDate"),
				rs.getString("status"));
	}
}
