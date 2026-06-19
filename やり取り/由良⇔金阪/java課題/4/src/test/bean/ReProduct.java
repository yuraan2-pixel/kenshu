package test.bean;

import test.function.Input;

public class ReProduct {
	private int code;
	private String name;
	private int price;
	private String information;
	
	public ReProduct() {
		
	}
	
	/**
	 * code,name,priceの順に入力を受け付けてset
	 * @param sellect	判別用
	 */
	public ReProduct(boolean sellect) {
		setCode();
		setName();
		setPrice();
		System.out.println();
		setInformation(code, name, price);
	}
	
	/**
	 * コードだけ取り込んでname, priceの入力を受け付けてsetterへ
	 * @param code
	 */
	public ReProduct(int code) {
		setName();
		setPrice();
		setInformation(code, name, price);
	}
	
	/**
	 * infoの形(%03d,%s,%d)を受け取り分けてsetterに投げる
	 * @param info
	 */
	public ReProduct(String info) {
		String[] word = info.split(",");
		int code = Integer.parseInt(word[0]);
		String name = word[1];
		int price = Integer.parseInt(word[2]);
		setProduct(code, name, price);
	}
	
	
	/**
	 * 全ての値をそのままセット、setterがまとまってるだけ
	 * @param code
	 * @param name
	 * @param price
	 */
	public void setProduct(int code, String name, int price) {
		setCode(code);
		setName(name);
		setPrice(price);
		setInformation(setInformation(code, name, price));
	}
	
	
	static String setInformation(int code, String name, int price) {
		String format = "%03d,%s,%d";
		return String.format(format, code, name, price);
	}
	
	public int setCode() {
		return this.code = Input.digit("商品コード", 3);
	}
	public String setName() {
		return this.name = Input.name("商品名", 20);
	}
	public int setPrice() {
		return this.price = Input.less("単価", 1000000);
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
