package lzj.entity;

public class Category {
	private int cid;
	private String cateGoryName;

	public Category() {
		super();
	}

	public Category(int cid, String cateGoryName) {
		super();
		this.cid = cid;
		this.cateGoryName = cateGoryName;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCateGoryName() {
		return cateGoryName;
	}

	public void setCateGoryName(String cateGoryName) {
		this.cateGoryName = cateGoryName;
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cateGoryName=" + cateGoryName + "]";
	}
}
