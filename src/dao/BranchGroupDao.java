package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import pojo.BranchGroupPojo;
import pojo.BranchPojo;
import pojo.UserPojo;

public class BranchGroupDao implements Dao {
	private Connection connection;
	private CallableStatement insertStatement;
	private CallableStatement updateStatement;
	private CallableStatement deleteStatement;
	private CallableStatement selectStatement;
	
	public BranchGroupDao(Properties properties) throws SQLException {
		this.open(properties);
		this.insertStatement = this.connection.prepareCall("{call sp_insert_branchGroup(?,?,?,?)}");
		this.updateStatement = this.connection.prepareCall("{call sp_update_branchGroup(?,?,?,?)}");
		this.deleteStatement = this.connection.prepareCall("{call sp_delete_branchGroup(?)}");
		this.selectStatement = this.connection.prepareCall("{call sp_select_branchGroup()}");
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
			BranchGroupPojo branchGroupPojo = (BranchGroupPojo) object;
			
			this.insertStatement.setString(1, branchGroupPojo.getBranchGroupId());
			this.insertStatement.setString(2, branchGroupPojo.getBranchId1());
			this.insertStatement.setString(3, branchGroupPojo.getBranchId2());
			this.insertStatement.setString(4, branchGroupPojo.getSplFerryTime());
			this.insertStatement.execute();
			return this.insertStatement.getUpdateCount();
		}
		return 0;
	}

	@Override
	public int update(Object object) throws SQLException {
		if(object != null){
			BranchGroupPojo branchGroupPojo = (BranchGroupPojo) object;
			System.out.println(branchGroupPojo);
			this.updateStatement.setString(1, branchGroupPojo.getBranchGroupId());
			this.updateStatement.setString(2, branchGroupPojo.getBranchId1());
			this.updateStatement.setString(3, branchGroupPojo.getBranchId2());
			this.updateStatement.setString(4, branchGroupPojo.getSplFerryTime());
			this.updateStatement.execute();
			return this.updateStatement.getUpdateCount();
			
		}
		return 0;
	}

	@Override
	public int delete(Object object) throws SQLException {
		if(object != null){
			BranchGroupPojo branchGroupPojo = (BranchGroupPojo) object;
			this.deleteStatement.setString(1, branchGroupPojo.getBranchGroupId());
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
				BranchGroupPojo branchGroupPojo =new BranchGroupPojo(set.getString(1), set.getString(2), set.getString(3), set.getString(4));
				branchList.add(branchGroupPojo);
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
