package com.project.leebugzz.service;


import com.project.leebugzz.model.UserEntity;

import java.util.List;

public interface UserService {

    void addUser(UserEntity userEntity);

    List<UserEntity> getUsers();
    
    void loggedUser(UserEntity userEntity);

	void reset(UserEntity user);

    
}
