package test.bean;

public class ProductBean {
	private int code;
	private String name;
	private int price;
	private String information;

	public ProductBean(int code, String name, int price) {
		setCode(code);
		setName(name);
		setPrice(price);
		String f = "%03d,%s,%d";
		setInformation(String.format(f, code, name, price));
	}
	
	public ProductBean(String info) {
		setInformation(info);
	}
	
	@Override
	public String toString() {
		// TODO 自動生成されたメソッド・スタブ
		return information;
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
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}
}
