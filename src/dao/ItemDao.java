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
import pojo.ItemPojo;
import pojo.UserPojo;

public class ItemDao implements Dao {
	private Connection connection;
	private CallableStatement insertStatement;
	private CallableStatement updateStatement;
	private CallableStatement deleteStatement;
	private CallableStatement selectStatement;
	
	public ItemDao(Properties properties) throws SQLException {
		this.open(properties);
		this.insertStatement = this.connection.prepareCall("{call sp_insert_item(?,?,?,?)}");
		this.updateStatement = this.connection.prepareCall("{call sp_update_item(?,?,?,?)}");
		this.deleteStatement = this.connection.prepareCall("{call sp_delete_item(?)}");
		this.selectStatement = this.connection.prepareCall("{call sp_select_item()}");
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
			ItemPojo itemPojo = (ItemPojo) object;
			
			this.insertStatement.setString(1, itemPojo.getItemId());
			this.insertStatement.setString(2, itemPojo.getItemDescriptor());
			this.insertStatement.setInt(3, itemPojo.getVehicle());
			this.insertStatement.setString(4, itemPojo.getItemGroupId());
			this.insertStatement.execute();
			return this.insertStatement.getUpdateCount();
		}
		return 0;
	}

	@Override
	public int update(Object object) throws SQLException {
		if(object != null){
			ItemPojo itemPojo = (ItemPojo) object;
			System.out.println(itemPojo);
			this.updateStatement.setString(1, itemPojo.getItemId());
			this.updateStatement.setString(2, itemPojo.getItemDescriptor());
			this.updateStatement.setInt(3, itemPojo.getVehicle());
			this.updateStatement.setString(4, itemPojo.getItemGroupId());
			this.updateStatement.execute();
			return this.updateStatement.getUpdateCount();
			
		}
		return 0;
	}

	@Override
	public int delete(Object object) throws SQLException {
		if(object != null){
			ItemPojo itemPojo = (ItemPojo) object;
			this.deleteStatement.setString(1, itemPojo.getItemId());
			this.deleteStatement.execute();
			return this.deleteStatement.getUpdateCount();
		}
		return 0;
	}

	@Override
	public List<Object> select() throws SQLException {
		if(this.selectStatement.execute()){
			ResultSet set = this.selectStatement.getResultSet();
			List<Object> itemList = new ArrayList<>();
			while(set.next()){
				ItemPojo itemPojo =new ItemPojo(set.getString(1), set.getString(2), set.getInt(3), set.getString(4));
				itemList.add(itemPojo);
			}
			return itemList;
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
