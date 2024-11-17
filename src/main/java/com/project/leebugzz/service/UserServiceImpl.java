package com.project.leebugzz.service;

import com.project.leebugzz.dao.UserEntityDao;
import com.project.leebugzz.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserEntityDao userDao;

	@Override
	public void addUser(UserEntity userEntity) {
		userDao.addUserEntity(userEntity);
	}

	@Override
	public List<UserEntity> getUsers() {

		return userDao.getUserEntitys();
	}

	@Override
	public void loggedUser(UserEntity userEntity) {
		// TODO Auto-generated method stub
		userDao.setLoggedUser(userEntity);
		
	}

	@Override
	public void reset(UserEntity user) {
		// TODO Auto-generated method stub
		userDao.reset(user);
		
	}
	
	
}
