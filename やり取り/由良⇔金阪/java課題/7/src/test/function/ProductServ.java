package test.function;

import test.bean.ProductBean;

public class ProductServ extends ProductBean{
	public ProductServ(String info) {
		setBean(info);
	}
	
	public ProductServ(int code, String name, int price) {
		seter(code, name, price);
	}
	
	public ProductServ() {}
	
	@Override
	public String toString() {
		// TODO 自動生成されたメソッド・スタブ
		return getInformation();
	}

	public void setBean(String info) {
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
	
	public String getCode(String s) {
		return String.format("%03d", getCode());
	}
}
