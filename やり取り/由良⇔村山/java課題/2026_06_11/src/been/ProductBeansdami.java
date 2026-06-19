package been;

public class ProductBeansdami {
	private int code;
	private String name;
	private int cost;

	public ProductBeansdami() {
	};

	public ProductBeansdami(int code,String name,int cost) {
		this.code=code;
		this.name=name;
		this.cost=cost;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		try {
			int a = (name.getBytes("UTF-8").length);
			if (a >= 21) {
				throw new IllegalArgumentException("文字数オーバーです。");
			}
			this.name = name;
		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		if (cost > 1000000) {
			throw new IllegalArgumentException("金額オーバーです。");
		}
		this.cost = cost;
	}
}