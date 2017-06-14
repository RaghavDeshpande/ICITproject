package model;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import dao.BranchDao;
import dao.ItemRateDao;
import listener.Factory;
import pojo.BranchPojo;
import pojo.ItemRatePojo;

public class ItemRateBean {
	private String branchGroupId = null;
	private String itemId= null;
	private String itemRate=null;
	
	public ItemRateBean(){
		
	}

	public ItemRateBean(String branchGroupId, String itemId, String itemRate) {
		super();
		this.branchGroupId = branchGroupId;
		this.itemId = itemId;
		this.itemRate = itemRate;
	}

	public String getBranchGroupId() {
		return branchGroupId;
	}

	public void setBranchGroupId(String branchGroupId) {
		this.branchGroupId = branchGroupId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemRate() {
		return itemRate;
	}

	public void setItemRate(String itemRate) {
		this.itemRate = itemRate;
	}
	
	public List<Object> getItemRates() throws SQLException{
		Properties properties = Factory.getContextProperties();
		ItemRateDao dao =new ItemRateDao(properties);
		List<Object> itemRateList = dao.select();
		dao.close();
		return itemRateList;
	}
	public int addItemRate()throws SQLException{
		Properties properties = Factory.getContextProperties();
		ItemRateDao itemRateDao = new ItemRateDao(properties);
		this.toString();
		ItemRatePojo itemRatePojo = new ItemRatePojo(this.branchGroupId, this.itemId, this.itemRate);
		int result = itemRateDao.insert(itemRatePojo);
		itemRateDao.close();
		return result;
	}
	public ItemRateBean getItem_Rate() throws SQLException{
		Properties properties = Factory.getContextProperties();
		ItemRateDao  dao = new ItemRateDao(properties);
		List<Object> itemRateList = dao.select();
		for(Object object: itemRateList){
			ItemRatePojo itemRatePojo = (ItemRatePojo) object;
			System.out.println("In forEach" + " "+ itemRatePojo.getBranchGroupId());
			
			if(this.branchGroupId.trim().equals(itemRatePojo.getBranchGroupId().trim())){
				System.out.println("In bean");
				this.setItemId(itemRatePojo.getItemId());
				this.setItemRate(itemRatePojo.getItemRate());
		
			}
		}
		dao.close();
		return this;
	}
	public int updateItemRate() throws SQLException{
		Properties properties = Factory.getContextProperties();
		ItemRateDao  dao = new ItemRateDao(properties);
		ItemRatePojo pojo = new ItemRatePojo(branchGroupId.trim(), itemId.trim(), itemRate.trim() );
		int result = dao.update(pojo);
		dao.close();
		return result;
	}
	public int deleteItemRate() throws SQLException{
		Properties properties = Factory.getContextProperties();
		ItemRateDao  dao = new ItemRateDao(properties);
		ItemRatePojo pojo = new ItemRatePojo();
		System.out.println(this);
		pojo.setBranchGroupId(this.branchGroupId.trim());
		return dao.delete(pojo);
		
	}
}
