package com.project.leebugzz.row.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.leebugzz.model.CategoryEntity;

public class CategoryRowMapper implements RowMapper<CategoryEntity> {

	@Override
	public CategoryEntity mapRow(ResultSet rs, int row) throws SQLException {
		// TODO Auto-generated method stub
		return new CategoryEntity(rs.getInt("categoryId"),rs.getString("categoryName"));
	}


}
