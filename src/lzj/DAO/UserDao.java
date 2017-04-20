package lzj.DAO;

import java.util.ArrayList;

import lzj.entity.User;

public interface UserDao {
	public int addUser(User user);

	public int delUser(User user);

	public int updateUser(User user);

	public ArrayList<User> findUserByUid(int uid);

	public ArrayList<User> findUserByUserName(String userName);
	
	public ArrayList<User> findUserByPage(int page);
}
