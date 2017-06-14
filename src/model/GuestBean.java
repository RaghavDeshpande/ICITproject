package model;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import dao.GuestDao;
import listener.Factory;
import pojo.GuestPojo;

public class GuestBean {
	private String guestId = null;
	private String guestName = null;
	private String guestAddress = null;

	public GuestBean() {

	}

	public GuestBean(String guestId, String guestName, String guestAddress) {
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

	public List<Object> getGuests() throws SQLException {
		Properties properties = Factory.getContextProperties();
		GuestDao dao = new GuestDao(properties);
		List<Object> guestList = dao.select();
		dao.close();
		return guestList;
	}

	public int addGuest() throws SQLException {
		Properties properties = Factory.getContextProperties();
		GuestDao guestDao = new GuestDao(properties);
		this.toString();
		GuestPojo guestPojo = new GuestPojo(this.guestId, this.guestName, this.guestAddress);
		int result = guestDao.insert(guestPojo);
		guestDao.close();
		return result;
	}

	public GuestBean getGuest() throws SQLException {
		Properties properties = Factory.getContextProperties();
		GuestDao dao = new GuestDao(properties);
		List<Object> guestList = dao.select();
		for (Object object : guestList) {
			GuestPojo guestPojo = (GuestPojo) object;
			System.out.println("In forEach" + this.guestId + " " + guestPojo.getGuestId());

			if (this.guestId.trim().equals(guestPojo.getGuestId().trim())) {
				System.out.println("In bean");
				this.setGuestName(guestPojo.getGuestName());
				this.setGuestAddress(guestPojo.getGuestAddress());
			}
		}
		dao.close();
		return this;
	}

	public int updateGuest() throws SQLException {
		Properties properties = Factory.getContextProperties();
		GuestDao dao = new GuestDao(properties);
		GuestPojo pojo = new GuestPojo(guestId.trim(), guestName.trim(), guestAddress.trim());
		int result = dao.update(pojo);
		dao.close();
		return result;
	}

	public int deleteGuest() throws SQLException {
		Properties properties = Factory.getContextProperties();
		GuestDao dao = new GuestDao(properties);
		GuestPojo pojo = new GuestPojo();
		System.out.println(this);
		pojo.setGuestId(this.guestId.trim());
		return dao.delete(pojo);

	}

	@Override
	public String toString() {
		return "GuestBean [guestId=" + guestId + ", guestName=" + guestName + ", guestAddress=" + guestAddress + "]";
	}

}
