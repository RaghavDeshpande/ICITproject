package model;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import dao.Dao;
import dao.UserDao;
import listener.Factory;
import pojo.UserPojo;

public class UserBean {
	private String empId;
	private String userName;
	private String passWord;
	public UserBean()
	{	}
	public UserBean(String empId, String userName, String passWord){
		this.empId = empId;
		this.userName = userName;
		this.passWord = passWord;
	}
	public UserBean( String userName, String passWord){
		this.userName = userName;
		this.passWord = passWord;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public void registerNewUser()throws SQLException{
		Properties properties = Factory.getContextProperties();
		UserDao userDao = new UserDao(properties);
		UserPojo user = new UserPojo(empId, userName, passWord);
		userDao.insert(user);
		userDao.close();
	}
	public boolean authenticate()throws SQLException{
		boolean status = false;
			Properties properties = Factory.getContextProperties();
			UserDao userDao = new UserDao(properties);
			UserPojo temp = new UserPojo(userName, passWord);
			List<Object> tempList = userDao.select();
			for(Object object : tempList){
				UserPojo user = (UserPojo)object;
				if(user.equals(temp)){
					status = true;
					break;
				}
			}
			userDao.close();
			return status;
	}
}




































