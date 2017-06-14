package model;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;



import dao.BranchDao;
import listener.Factory;
import pojo.BranchPojo;

public class BranchBean {
	private String branchId = null;
	private String branchName = null;
	private String branchAddress = null;
	private int branchPhone = 0;
	
	public BranchBean()
	{	}

	public BranchBean(String branchId, String branchName, String branchAddress, int branchPhone) {
		this.branchId = branchId;
		this.branchName = branchName;
		this.branchAddress = branchAddress;
		this.branchPhone = branchPhone;
	}

	public BranchBean(String branchName) {
		this.branchName = branchName;
	}
	
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchAddress() {
		return branchAddress;
	}
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
	public String getBranchPhone() {
		return String.valueOf(branchPhone);
	}
	public void setBranchPhone(int branchPhone) {
		this.branchPhone = branchPhone;
	}
	public List<Object> getBranches() throws SQLException{
		Properties properties = Factory.getContextProperties();
		BranchDao dao =new BranchDao(properties);
		List<Object> branchList = dao.select();
		dao.close();
		return branchList;
	}
	public int addBranch()throws SQLException{
		Properties properties = Factory.getContextProperties();
		BranchDao branchDao = new BranchDao(properties);
		this.toString();
		BranchPojo branchPojo = new BranchPojo(this.branchId, this.branchName, this.branchAddress, this.branchPhone);
		int result = branchDao.insert(branchPojo);
		branchDao.close();
		return result;
	}
	public BranchBean getBranch() throws SQLException{
		Properties properties = Factory.getContextProperties();
		BranchDao  dao = new BranchDao(properties);
		List<Object> branchList = dao.select();
		for(Object object: branchList){
			BranchPojo branchPojo = (BranchPojo) object;
			System.out.println("In forEach" + this.branchId +" "+ branchPojo.getBranchId());
			
			if(this.branchId.trim().equals(branchPojo.getBranchId().trim())){
				System.out.println("In bean");
				this.setBranchName(branchPojo.getBranchName());
				this.setBranchAddress(branchPojo.getBranchAddress());
				this.setBranchPhone(branchPojo.getBranchPhone());
			}
		}
		dao.close();
		return this;
	}
	public int updateBranch() throws SQLException{
		Properties properties = Factory.getContextProperties();
		BranchDao  dao = new BranchDao(properties);
		BranchPojo pojo = new BranchPojo(branchId.trim(), branchName.trim(), branchAddress.trim(), branchPhone );
		int result = dao.update(pojo);
		dao.close();
		return result;
	}
	public int deleteBranch() throws SQLException{
		Properties properties = Factory.getContextProperties();
		BranchDao  dao = new BranchDao(properties);
		BranchPojo pojo = new BranchPojo();
		System.out.println(this);
		pojo.setBranchId(this.branchId.trim());
		return dao.delete(pojo);
		
	}
	@Override
	public String toString() {
		
		return String.format("%-20s %-20s %-20s %-12d",branchId, branchName , branchAddress, branchPhone);
	}
}
