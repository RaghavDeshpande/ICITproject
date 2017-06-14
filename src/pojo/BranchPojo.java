package pojo;

public class BranchPojo {
	private String branchId;
	private String branchName;
	private String branchAddress;
	private int branchPhone;
	
	public BranchPojo() {
		// TODO Auto-generated constructor stub
	}
	public BranchPojo(String branchId, String branchName, String branchAddress, int branchPhone) {
		this.branchId = branchId;
		this.branchName = branchName;
		this.branchAddress = branchAddress;
		this.branchPhone = branchPhone;
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

	public int getBranchPhone() {
		return this.branchPhone;
	}

	public void setBranchPhone(int branchPhone) {
		this.branchPhone = branchPhone;
	}

	@Override
	public String toString() {
		return "BranchPojo [branchId=" + branchId + ", branchName=" + branchName + ", branchAddress=" + branchAddress
				+ ", branchPhone=" + branchPhone + "]";
	}
	
	
}
