package model;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import dao.BranchDao;
import dao.BranchGroupDao;
import listener.Factory;
import pojo.BranchGroupPojo;
import pojo.BranchPojo;

public class BranchGroupBean {
	private String branchGroupId=null;
	private String branchId1=null;
	private String branchId2=null;
	private String splFerryTime=null;

	public BranchGroupBean() 
	{	}

	public BranchGroupBean(String branchGroupId, String branchId1, String branchId2, String splFerryTime) {
		super();
		this.branchGroupId = branchGroupId;
		this.branchId1 = branchId1;
		this.branchId2 = branchId2;
		this.splFerryTime = splFerryTime;
	}

	public String getBranchGroupId() {
		return branchGroupId;
	}

	public void setBranchGroupId(String branchGroupId) {
		this.branchGroupId = branchGroupId;
	}

	public String getBranchId1() {
		return branchId1;
	}

	public void setBranchId1(String branchId1) {
		this.branchId1 = branchId1;
	}

	public String getBranchId2() {
		return branchId2;
	}

	public void setBranchId2(String branchId2) {
		this.branchId2 = branchId2;
	}

	public String getSplFerryTime() {
		return splFerryTime;
	}

	public void setSplFerryTime(String splFerryTime) {
		this.splFerryTime = splFerryTime;
	}

	public List<Object> getBranchGroups() throws SQLException{
		Properties properties = Factory.getContextProperties();
		BranchGroupDao dao =new BranchGroupDao(properties);
		List<Object> branchgroupList = dao.select();
		dao.close();
		return branchgroupList;
	}
	public int addBranchGroup()throws SQLException{
		Properties properties = Factory.getContextProperties();
		BranchGroupDao branchGroupDao = new BranchGroupDao(properties);
		this.toString();
		BranchGroupPojo branchGroupPojo = new BranchGroupPojo(this.branchGroupId, this.branchId1, this.branchId2, this.splFerryTime);
		int result = branchGroupDao.insert(branchGroupPojo);
		branchGroupDao.close();
		return result;
	}
	public BranchGroupBean getBranchGroup() throws SQLException{
		Properties properties = Factory.getContextProperties();
		BranchGroupDao  dao = new BranchGroupDao(properties);
		List<Object> branchgroupList = dao.select();
		for(Object object: branchgroupList){
			BranchGroupPojo branchGroupPojo = (BranchGroupPojo) object;
			System.out.println("In forEach" +  branchGroupPojo.getBranchGroupId());
			
			if(this.branchGroupId.trim().equals(branchGroupPojo.getBranchGroupId().trim())){
				this.setBranchId1(branchGroupPojo.getBranchId1());
				this.setBranchId2(branchGroupPojo.getBranchId2());
				this.setSplFerryTime(branchGroupPojo.getSplFerryTime());
				System.out.println(this);
			}
		}
		dao.close();
		return this;
	}
	public int updateBranchGroup() throws SQLException{
		Properties properties = Factory.getContextProperties();
		BranchGroupDao  dao = new BranchGroupDao(properties);
		BranchGroupPojo pojo = new BranchGroupPojo(branchGroupId.trim(), branchId1.trim(), branchId2.trim(), splFerryTime );
		int result = dao.update(pojo);
		dao.close();
		return result;
	}
	public int deleteBranchGroup() throws SQLException{
		Properties properties = Factory.getContextProperties();
		BranchGroupDao  dao = new BranchGroupDao(properties);
		BranchGroupPojo pojo = new BranchGroupPojo();
		System.out.println(this);
		pojo.setBranchGroupId(this.branchGroupId.trim());
		return dao.delete(pojo);
		
	}
	@Override
	public String toString() {
		return "BranchGroupBean [branchGroupId=" + branchGroupId + ", branchId1=" + branchId1 + ", branchId2="
				+ branchId2 + ", splFerryTime=" + splFerryTime + "]";
	}


	
}
