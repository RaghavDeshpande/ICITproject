package model;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import dao.BranchDao;
import dao.ItemGroupDao;
import listener.Factory;
import pojo.BranchPojo;
import pojo.ItemGroupPojo;

public class ItemGroupBean {
	private String itemGroupId=null;
	private String description=null;
	public ItemGroupBean() 
	{	}
	public ItemGroupBean(String itemGroupId, String description) {
		super();
		this.itemGroupId = itemGroupId;
		this.description = description;
	}
	public String getItemGroupId() {
		return itemGroupId;
	}
	public void setItemGroupId(String itemGroupId) {
		this.itemGroupId = itemGroupId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Object> getItemGroups() throws SQLException{
		Properties properties = Factory.getContextProperties();
		ItemGroupDao dao =new ItemGroupDao(properties);
		List<Object> itemGroupList = dao.select();
		dao.close();
		return itemGroupList;
	}
	public int addItemGroup()throws SQLException{
		Properties properties = Factory.getContextProperties();
		ItemGroupDao itemGroupDao = new ItemGroupDao(properties);
		this.toString();
		ItemGroupPojo itemGroupPojo = new ItemGroupPojo(this.itemGroupId,this.description);
		int result = itemGroupDao.insert(itemGroupPojo);
		itemGroupDao.close();
		return result;
	}
	public ItemGroupBean getItemGroup() throws SQLException{
		Properties properties = Factory.getContextProperties();
		ItemGroupDao  dao = new ItemGroupDao(properties);
		List<Object> itemGroupList = dao.select();
		for(Object object: itemGroupList){
			ItemGroupPojo itemGroupPojo = (ItemGroupPojo) object;
			System.out.println("In forEach" + itemGroupPojo.getItemGroupId());
			
			if(this.itemGroupId.trim().equals(itemGroupPojo.getItemGroupId().trim())){
				System.out.println("In bean");
				this.setDescription(itemGroupPojo.getDescription());
				}
		}
		dao.close();
		return this;
	}
	public int updateItemGroup() throws SQLException{
		Properties properties = Factory.getContextProperties();
		ItemGroupDao  dao = new ItemGroupDao(properties);
		System.out.println(description +"is null");
		ItemGroupPojo pojo = new ItemGroupPojo(itemGroupId.trim(),description.trim() );
		int result = dao.update(pojo);
		dao.close();
		return result;
	}
	public int deleteItemGroup() throws SQLException{
		Properties properties = Factory.getContextProperties();
		ItemGroupDao  dao = new ItemGroupDao(properties);
		ItemGroupPojo pojo = new ItemGroupPojo();
		System.out.println(this);
		pojo.setItemGroupId(this.itemGroupId.trim());
		return dao.delete(pojo);
		
	}
}
