package pojo;

public class ItemPojo {
	private String itemId;
	private String itemDescriptor;
	private int vehicle;
	private String itemGroupId;
	
	public ItemPojo(){
		
	}

	public ItemPojo(String itemId, String itemDescriptor, int vehicle, String itemGroupId) {
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

	@Override
	public String toString() {
		return "ItemPojo [itemId=" + itemId + ", itemDescriptor=" + itemDescriptor + ", vehicle=" + vehicle
				+ ", itemGroupId=" + itemGroupId + "]";
	}
	
	
}
