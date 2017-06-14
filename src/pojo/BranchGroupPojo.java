package pojo;

import java.sql.Time;

public class BranchGroupPojo {
	private String branchGroupId;
	private String branchId1;
	private String branchId2;
	private String splFerryTime;
	
	public BranchGroupPojo(String branchGroupId, String branchId1, String branchId2, String splFerryTime) {
		super();
		this.branchGroupId = branchGroupId;
		this.branchId1 = branchId1;
		this.branchId2 = branchId2;
		this.splFerryTime = splFerryTime;
	}

	public BranchGroupPojo()
	{	}

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

	@Override
	public String toString() {
		return "BranchGroupPojo [branchGroupId=" + branchGroupId + ", branchId1=" + branchId1 + ", branchId2="
				+ branchId2 + ", splFerryTime=" + splFerryTime + "]";
	}
}
