package com.onlinesShopingBackend.D;

import java.util.List;

import com.onlinesShopingBackend.model.User;

public interface Userdao {
 public boolean addUser(User user);
 public boolean updateUser(User user);
 public boolean deleteUser(User user);
 public User getUser(int userID);
 public List<User> listUsers();
}
