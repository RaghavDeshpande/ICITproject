package model;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;



import dao.BranchDao;
import dao.ItemDao;
import listener.Factory;
import pojo.BranchPojo;
import pojo.ItemPojo;

public class ItemBean {
	private String itemId = null;
	private String itemDescriptor = null;
	private int vehicle = 0;
	private String itemGroupId = null;
	
	public ItemBean()
	{	}

	

	public ItemBean(String itemId, String itemDescriptor, int vehicle, String itemGroupId) {
		super();
		this.itemId = itemId;
		this.itemDescriptor = itemDescriptor;
		this.vehicle = vehicle;
		this.itemGroupId = itemGroupId;
	}



	
	public String getItemId() {
		return itemId;
	}



	public void setItemId(String itemId) {
		this.itemId = itemId;
	}



	public String getItemDescriptor() {
		return itemDescriptor;
	}



	public void setItemDescriptor(String itemDescriptor) {
		this.itemDescriptor = itemDescriptor;
	}



	public int getVehicle() {
		return vehicle;
	}



	public void setVehicle(int vehicle) {
		this.vehicle = vehicle;
	}



	public String getItemGroupId() {
		return itemGroupId;
	}



	public void setItemGroupId(String itemGroupId) {
		this.itemGroupId = itemGroupId;
	}



	public List<Object> getItems() throws SQLException{
		Properties properties = Factory.getContextProperties();
		ItemDao dao =new ItemDao(properties);
		List<Object> itemList = dao.select();
		dao.close();
		return itemList;
	}
	public int addItem()throws SQLException{
		Properties properties = Factory.getContextProperties();
		ItemDao itemDao = new ItemDao(properties);
		this.toString();
		ItemPojo itemPojo = new ItemPojo(this.itemId, this.itemDescriptor, this.vehicle, this.itemGroupId);
		int result = itemDao.insert(itemPojo);
		itemDao.close();
		return result;
	}
	public ItemBean getItem() throws SQLException{
		Properties properties = Factory.getContextProperties();
		ItemDao  dao = new ItemDao(properties);
		List<Object> itemList = dao.select();
		for(Object object: itemList){
			ItemPojo itemPojo = (ItemPojo) object;
			System.out.println("In forEach" + this.itemId +" "+ itemPojo.getItemId());
			
			if(this.itemId.trim().equals(itemPojo.getItemId().trim())){
				System.out.println("In bean");
				this.setItemDescriptor(itemPojo.getItemDescriptor());
				this.setVehicle(itemPojo.getVehicle());
				this.setItemGroupId(itemPojo.getItemGroupId());
			}
		}
		dao.close();
		return this;
	}
	public int updateItem() throws SQLException{
		Properties properties = Factory.getContextProperties();
		ItemDao  dao = new ItemDao(properties);
		ItemPojo pojo = new ItemPojo(itemId.trim(), itemDescriptor.trim(), vehicle, itemGroupId.trim() );
		int result = dao.update(pojo);
		dao.close();
		return result;
	}
	public int deleteItem() throws SQLException{
		Properties properties = Factory.getContextProperties();
		ItemDao  dao = new ItemDao(properties);
		ItemPojo pojo = new ItemPojo();
		System.out.println(this);
		pojo.setItemId(this.itemId.trim());
		return dao.delete(pojo);
		
	}
	@Override
	public String toString() {
		
		return String.format("%-20s %-20s %-20d %-12s",itemId, itemDescriptor , vehicle, itemGroupId);
	}
}
