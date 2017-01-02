package com.mvcapp.dao.contract;

import com.mvcapp.model.User;

public interface UserDAO {

	public void saveUser(User user);
	public User getUser(User user);
	
}
