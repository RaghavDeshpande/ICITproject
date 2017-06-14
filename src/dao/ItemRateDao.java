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
import pojo.ItemRatePojo;
import pojo.UserPojo;

public class ItemRateDao implements Dao {
	private Connection connection;
	private CallableStatement insertStatement;
	private CallableStatement updateStatement;
	private CallableStatement deleteStatement;
	private CallableStatement selectStatement;
	
	public ItemRateDao(Properties properties) throws SQLException {
		this.open(properties);
		this.insertStatement = this.connection.prepareCall("{call sp_insert_itemRate(?,?,?)}");
		this.updateStatement = this.connection.prepareCall("{call sp_update_itemRate(?,?,?)}");
		this.deleteStatement = this.connection.prepareCall("{call sp_delete_itemRate(?)}");
		this.selectStatement = this.connection.prepareCall("{call sp_select_itemRate()}");
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
			ItemRatePojo itemRatePojo = (ItemRatePojo) object;
			
			this.insertStatement.setString(1, itemRatePojo.getBranchGroupId());
			this.insertStatement.setString(2, itemRatePojo.getItemId());
			this.insertStatement.setString(3, itemRatePojo.getItemRate());
			this.insertStatement.execute();
			return this.insertStatement.getUpdateCount();
		}
		return 0;
	}

	@Override
	public int update(Object object) throws SQLException {
		if(object != null){
			ItemRatePojo itemRatePojo = (ItemRatePojo) object;
			System.out.println(itemRatePojo);
			this.updateStatement.setString(1, itemRatePojo.getBranchGroupId());
			this.updateStatement.setString(2, itemRatePojo.getItemId());
			this.updateStatement.setString(3, itemRatePojo.getItemRate());
			this.updateStatement.execute();
			return this.updateStatement.getUpdateCount();
			
		}
		return 0;
	}

	@Override
	public int delete(Object object) throws SQLException {
		if(object != null){
			ItemRatePojo itemRatePojo = (ItemRatePojo) object;
			this.deleteStatement.setString(1, itemRatePojo.getBranchGroupId());
			this.deleteStatement.execute();
			return this.deleteStatement.getUpdateCount();
		}
		return 0;
	}

	@Override
	public List<Object> select() throws SQLException {
		if(this.selectStatement.execute()){
			ResultSet set = this.selectStatement.getResultSet();
			List<Object> itemRateList = new ArrayList<>();
			while(set.next()){
				ItemRatePojo itemRatePojo =new ItemRatePojo(set.getString(1), set.getString(2), set.getString(3));
				itemRateList.add(itemRatePojo);
			}
			return itemRateList;
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
