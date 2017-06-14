package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import pojo.BranchPojo;
import pojo.UserPojo;

public class BranchDao implements Dao {
	private Connection connection;
	private CallableStatement insertStatement;
	private CallableStatement updateStatement;
	private CallableStatement deleteStatement;
	private CallableStatement selectStatement;
	
	public BranchDao(Properties properties) throws SQLException {
		this.open(properties);
		this.insertStatement = this.connection.prepareCall("{call sp_insert_branch(?,?,?,?)}");
		this.updateStatement = this.connection.prepareCall("{call sp_update_branch(?,?,?,?)}");
		this.deleteStatement = this.connection.prepareCall("{call sp_delete_branch(?)}");
		this.selectStatement = this.connection.prepareCall("{call sp_select_branch()}");
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
		if(object!=null){
			BranchPojo branchPojo = (BranchPojo) object;
			
			this.insertStatement.setString(1, branchPojo.getBranchId());
			this.insertStatement.setString(2, branchPojo.getBranchName());
			this.insertStatement.setString(3, branchPojo.getBranchAddress());
			this.insertStatement.setInt(4, branchPojo.getBranchPhone());
			this.insertStatement.execute();
			return this.insertStatement.getUpdateCount();
		}
		return 0;
	}

	@Override
	public int update(Object object) throws SQLException {
		if(object != null){
			BranchPojo branchPojo = (BranchPojo) object;
			System.out.println(branchPojo);
			this.updateStatement.setString(1, branchPojo.getBranchName());
			this.updateStatement.setString(2, branchPojo.getBranchAddress());
			this.updateStatement.setInt(3, branchPojo.getBranchPhone());
			this.updateStatement.setString(4, branchPojo.getBranchId());
			this.updateStatement.execute();
			return this.updateStatement.getUpdateCount();
			
		}
		return 0;
	}

	@Override
	public int delete(Object object) throws SQLException {
		if(object != null){
			BranchPojo branchPojo = (BranchPojo) object;
			this.deleteStatement.setString(1, branchPojo.getBranchId());
			this.deleteStatement.execute();
			return this.deleteStatement.getUpdateCount();
		}
		return 0;
	}

	@Override
	public List<Object> select() throws SQLException {
		if(this.selectStatement.execute()){
			ResultSet set = this.selectStatement.getResultSet();
			List<Object> branchList = new ArrayList<>();
			while(set.next()){
				BranchPojo branchPojo =new BranchPojo(set.getString(1), set.getString(2), set.getString(3), set.getInt(4));
				branchList.add(branchPojo);
			}
			return branchList;
		}
		return null;
	}

	@Override
	public void close() throws SQLException {
		this.deleteStatement.close();
		this.insertStatement.close();
		this.selectStatement.close();
		this.updateStatement.close();
		this.connection.close();
	}
	
}
