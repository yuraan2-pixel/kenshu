package test.bean;

public class ProductBean {
	private int code;
	private String name;
	private int price;
	private String information;

	public ProductBean() {}
	
	public ProductBean(int code, String name, int price) {
		seter(code, name, price);
	}
	
	public ProductBean(String info) {
		String[] word = info.split(",");
		int code = Integer.parseInt(word[0]);
		int price = Integer.parseInt(word[2]);
		seter(code, word[1], price);
	}
	
	public void seter(int code, String name, int price) {
		setCode(code);
		setName(name);
		setPrice(price);
		String f = "%03d,%s,%d";
		setInformation(String.format(f, code, name, price));
	}
	
	@Override
	public String toString() {
		// TODO 自動生成されたメソッド・スタブ
		return information;
	}



	public String getCode(String word) {
		return String.format("%03d", code) ;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName(String word) {
		return String.format("%s", name);
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
