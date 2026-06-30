package com.fashionStore.dao;

import java.util.List;
import com.fashionStore.model.User;

public interface UserDAO {

	int addUser(User user);

	User getUser(int userId);

	List<User> getAllUsers();

	int updateUser(User user);

	int deleteUser(int userId);

	User getUserByEmail(String email);
}