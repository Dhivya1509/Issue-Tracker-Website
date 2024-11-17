package com.project.leebugzz.row.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.leebugzz.model.UserEntity;

public class UserRowMapper implements RowMapper<UserEntity> {

	@Override
	public UserEntity mapRow(ResultSet rs, int row) throws SQLException {
		return new UserEntity(rs.getInt("userId"), rs.getString("firstName"), rs.getString("lastName"),rs.getString("email"),rs.getDate("dob"),
				rs.getString("gender"),rs.getString("category"),rs.getLong("contactNo"),rs.getString("password"),rs.getString("repCategory"),rs.getString("q1"),rs.getString("q2"),rs.getString("q3"));
	}

} 