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
import pojo.ItemGroupPojo;
import pojo.UserPojo;

public class ItemGroupDao implements Dao {
	private Connection connection;
	private CallableStatement insertStatement;
	private CallableStatement updateStatement;
	private CallableStatement deleteStatement;
	private CallableStatement selectStatement;
	
	public ItemGroupDao(Properties properties) throws SQLException {
		this.open(properties);
		this.insertStatement = this.connection.prepareCall("{call sp_insert_itemGroup(?,?)}");
		this.updateStatement = this.connection.prepareCall("{call sp_update_itemGroup(?,?)}");
		this.deleteStatement = this.connection.prepareCall("{call sp_delete_itemGroup(?)}");
		this.selectStatement = this.connection.prepareCall("{call sp_select_itemGroup()}");
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
			ItemGroupPojo itemGroupPojo = (ItemGroupPojo) object;
			
			this.insertStatement.setString(1, itemGroupPojo.getItemGroupId());
			this.insertStatement.setString(2, itemGroupPojo.getDescription());
			
			this.insertStatement.execute();
			return this.insertStatement.getUpdateCount();
		}
		return 0;
	}

	@Override
	public int update(Object object) throws SQLException {
		if(object != null){
			ItemGroupPojo itemGroupPojo = (ItemGroupPojo) object;
			System.out.println(itemGroupPojo);
			this.updateStatement.setString(1, itemGroupPojo.getItemGroupId());
			this.updateStatement.setString(2, itemGroupPojo.getDescription());
			
			this.updateStatement.execute();
			return this.updateStatement.getUpdateCount();
			
		}
		return 0;
	}

	@Override
	public int delete(Object object) throws SQLException {
		if(object != null){
			ItemGroupPojo itemGroupPojo = (ItemGroupPojo) object;
			this.deleteStatement.setString(1, itemGroupPojo.getItemGroupId());
			this.deleteStatement.execute();
			return this.deleteStatement.getUpdateCount();
		}
		return 0;
	}

	@Override
	public List<Object> select() throws SQLException {
		if(this.selectStatement.execute()){
			ResultSet set = this.selectStatement.getResultSet();
			List<Object> itemGroupList = new ArrayList<>();
			while(set.next()){
				ItemGroupPojo itemGroupPojo =new ItemGroupPojo(set.getString(1), set.getString(2));
				itemGroupList.add(itemGroupPojo);
			}
			return itemGroupList;
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
