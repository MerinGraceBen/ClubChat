package com.niit.ClubChatBackEnd.DaoImplementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ClubChatBackEnd.Dao.UserDAO;
import com.niit.ClubChatBackEnd.Models.User;

@Repository("userDao")
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SessionFactory sF;
	@Autowired
	public UserDAOImpl(SessionFactory sF) {
		this.sF = sF;
	}
	
	@Transactional
//@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		try{
			sF.getCurrentSession().save(user);
			return true;
		}catch(Exception e){
		return false;
		}
	}
	
	@Transactional
//@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		try{
			sF.getCurrentSession().update(user);
			return true;
		}catch(Exception e){
		return false;
		}
	}
	
	@Transactional
//@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		try{
			sF.getCurrentSession().delete(user);
			return true;
		}catch(Exception e){
		return false;
		}
	}
	
	@Transactional
//@Override
	public boolean updateStatus(User user) {
		// TODO Auto-generated method stub
		try{
			user.setStatus("Online");
			sF.getCurrentSession().update(user);
		}catch(Exception e){
		return false;
		}
		return false;
	}
//@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
//@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
