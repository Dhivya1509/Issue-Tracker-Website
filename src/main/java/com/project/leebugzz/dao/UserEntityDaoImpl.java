package com.project.leebugzz.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.leebugzz.model.UserEntity;
import com.project.leebugzz.row.mapper.UserRowMapper;

@Repository
@Transactional
public class UserEntityDaoImpl implements UserEntityDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addUserEntity(UserEntity userEntity) {
		jdbcTemplate.update(
				"insert into user(firstName,lastName,email,dob,gender,category,contactNo,password,q1,q2,q3) values(?,?,?,?,?,?,?,?,?,?,?)",
				new Object[] { userEntity.getFirstName(), userEntity.getLastName(), userEntity.getEmail(),
						userEntity.getDob(), userEntity.getGender(), userEntity.getCategory(),
						userEntity.getContactNo(), userEntity.getPassword(), userEntity.getQ1(), userEntity.getQ2(),
						userEntity.getQ3() });
	}

	@Override
	public List<UserEntity> getUserEntitys() {
		List<UserEntity> userEntitys = jdbcTemplate.query("select * from user", new UserRowMapper());
		return userEntitys;
	}

	//// set logged in user in table

	@Override
	public void setLoggedUser(UserEntity userEntity) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("insert into loggeduser(email,password) values(?,?)",
				new Object[] { userEntity.getEmail(), userEntity.getPassword() });
		jdbcTemplate.update(
				"update loggeduser set userId=(select userId from user where loggeduser.email=user.email),firstName=(select firstName from user where loggeduser.email=user.email) ,lastName=(select lastName from user where loggeduser.email=user.email),category=(select user.category from user where loggeduser.email=user.email)");
	}

	@Override
	public void reset(UserEntity user) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("update user set password=? where email=? and q1=? and q2=? and q3=?",
				new Object[] { user.getPassword(), user.getEmail(), user.getQ1(), user.getQ2(), user.getQ3() });

	}
}
