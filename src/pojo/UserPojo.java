package pojo;

public class UserPojo {
	private String empId;
	private String userName;
	private String passWord;
	public UserPojo(String empId, String userName, String passWord) {
		this.empId = empId;
		this.userName = userName;
		this.passWord = passWord;
	}
	public UserPojo( String userName, String passWord) {
		this.empId = null;
		this.userName = userName;
		this.passWord = passWord;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public boolean equals(Object obj) {
		UserPojo pojo = (UserPojo) obj;
		if(this.userName.equals(pojo.userName) && this.passWord.equals(pojo.passWord)){
			return true;
		}
		else{
			return false;
		}
	}
	@Override
	public String toString() {
		return String.format("%-10s%-10s%", this.empId, this.userName);
	}
	
}
