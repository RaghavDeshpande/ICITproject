package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import pojo.UserPojo;

public class UserDao implements Dao{
	private Connection connection;
	private CallableStatement insertStatement;
	private CallableStatement updateStatement;
	private CallableStatement deleteStatement;
	private CallableStatement selectStatement;
	//private CallableStatement distinctStatement;

	public UserDao(Properties properties) throws SQLException {
		this.open(properties);
		this.insertStatement = this.connection.prepareCall("{call sp_insert_user(?,?,?)}");
		this.updateStatement = this.connection.prepareCall("{call sp_update_user(?,?,?)}");
		this.deleteStatement = this.connection.prepareCall("{call sp_delete_user(?)}");
		this.selectStatement = this.connection.prepareCall("{call sp_select_user()}");
	}
	@Override
	public void open(Properties properties) throws SQLException {
		try{
			Class.forName(properties.getProperty("DRIVER"));
			if(this.connection == null){
				this.connection = DriverManager.getConnection(properties.getProperty("URL"), properties.getProperty("USER"), properties.getProperty("PASSWORD"));
			}
				
		}catch(ClassNotFoundException e){
			throw new SQLException(e);	
		}
	}

	@Override
	public int insert(Object object) throws SQLException {
		if(object != null){
			UserPojo userPojo = (UserPojo) object;
			this.selectStatement.setString(1, userPojo.getEmpId());
			this.selectStatement.setString(2, userPojo.getUserName());
			this.selectStatement.setString(3, userPojo.getPassWord());
			
			if(this.selectStatement.execute()){
				return this.selectStatement.getUpdateCount();
			}
			else
				return 0;
		}
		else 
			return -1;
	}

	@Override
	public int update(Object object) throws SQLException {
		if(object != null){
			UserPojo userPojo = (UserPojo) object;
			this.updateStatement.setString(1, userPojo.getUserName());
			this.updateStatement.setString(2, userPojo.getPassWord());
			this.updateStatement.setString(3, userPojo.getEmpId());
			if(this.updateStatement.execute())
				return this.updateStatement.getUpdateCount();
			else 
				return 0;
		}
		else
			return -1;
	}

	@Override
	public int delete(Object object) throws SQLException {
		if(object != null){
			UserPojo userPojo = (UserPojo) object;
			this.deleteStatement.setString(1, userPojo.getUserName());
			if(this.deleteStatement.execute()){
				return this.deleteStatement.getUpdateCount();
			}
			else 
				return 0;
		}
		else
			return -1;
	}

	@Override
	public List<Object> select() throws SQLException {
		if(this.selectStatement.execute()){
			ResultSet set = this.selectStatement.getResultSet();
			List<Object> userList = new ArrayList<>();
			while(set.next()){
				UserPojo userPojo = new UserPojo(set.getString(1), set.getString(2), set.getString(3));
				userList.add(userPojo);
			}
			return userList;
		}
		return null;
	}

	@Override
	public void close() throws SQLException {
		this.insertStatement.close();
		this.updateStatement.close();
		this.selectStatement.close();
		this.deleteStatement.close();
		this.connection.close();
		
	}

}
