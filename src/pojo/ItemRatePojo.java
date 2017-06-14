package pojo;

public class ItemRatePojo {
	private String branchGroupId;
	private String itemId;
	private String itemRate;
	
	public ItemRatePojo(){
		
	}

	public ItemRatePojo(String branchGroupId, String itemId, String itemRate) {
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

	@Override
	public String toString() {
		return "ItemRatePojo [branchGroupId=" + branchGroupId + ", itemId=" + itemId + ", itemRate=" + itemRate + "]";
	}
	
	
}
