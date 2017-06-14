package pojo;

public class GuestPojo {
	private String guestId;
	private String guestName;
	private String guestAddress;
	
	public GuestPojo(){
		
	}

	public GuestPojo(String guestId, String guestName, String guestAddress) {
		super();
		this.guestId = guestId;
		this.guestName = guestName;
		this.guestAddress = guestAddress;
	}

	public String getGuestId() {
		return guestId;
	}

	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getGuestAddress() {
		return guestAddress;
	}

	public void setGuestAddress(String guestAddress) {
		this.guestAddress = guestAddress;
	}

	@Override
	public String toString() {
		return "GuestPojo [guestId=" + guestId + ", guestName=" + guestName + ", guestAddress=" + guestAddress + "]";
	}
	
}
