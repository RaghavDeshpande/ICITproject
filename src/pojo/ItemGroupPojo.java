package pojo;

public class ItemGroupPojo {
	private String itemGroupId;
	private String description;
	
	public ItemGroupPojo() 
	{	}

	public ItemGroupPojo(String itemGroupId, String description) {
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

	@Override
	public String toString() {
		return "ItemGroupPojo [itemGroupId=" + itemGroupId + ", description=" + description + "]";
	}
	
}
