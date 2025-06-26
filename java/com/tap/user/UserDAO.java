package com.tap.user;

import java.util.List;

public interface UserDAO {

	List<User> fetchAll();

	int insert(User u);
	
	User fetchSpecific(int uid);
	
	User fetchOnEmail(String email);

	int update(User u);

	int delete(int uid);

}
