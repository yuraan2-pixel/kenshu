package been;

public class ProductBeans {
	private String code;
	private String name;
	private String cost;

	public ProductBeans() {
	};

	public ProductBeans(String code, String name, String cost) {
		this.code = code;
		this.name = name;
		this.cost = cost;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}
}