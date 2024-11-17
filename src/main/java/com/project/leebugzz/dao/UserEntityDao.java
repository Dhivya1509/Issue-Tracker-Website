package com.project.leebugzz.dao;

import java.util.List;

import com.project.leebugzz.model.UserEntity;

public interface UserEntityDao {

	void setLoggedUser(UserEntity userEntity);

	void reset(UserEntity user);

	List<UserEntity> getUserEntitys();

	void addUserEntity(UserEntity userEntity);

}
