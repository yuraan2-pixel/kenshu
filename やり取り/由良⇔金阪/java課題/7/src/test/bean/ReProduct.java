package test.bean;

import test.function.Before.BeforeInput;

//	2026年6月9日	自動生成以外のコメント完了	追加予定なし
public class ReProduct {
	private int code;
	private String name;
	private int price;
	private String information;
	
	public String toString() {
		return getInformation();
	}
	
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
		setInformation(setString(code, name, price));
	}
	
	/**
	 * コードだけ取り込んでname, priceの入力を受け付けてset
	 * @param code	外部入力受取
	 */
	public ReProduct(int code) {
		setCode(code);
		setName();
		setPrice();
		System.out.println();
		setInformation(setString(code, name, price));
	}
	
	/**
	 * infoの形(%03d,%s,%d)を受け取り分けてsetterに投げる
	 * @param info	全体の形で受取
	 */
 	public ReProduct(String info) {
		String[] word = info.split(",");
		int code = Integer.parseInt(word[0]);
		String name = word[1];
		int price = Integer.parseInt(word[2]);
		setProduct(code, name, price);
	}
	
	/**
	 * 取り込んだ値をそのままsetterに投げる
	 * @param code	外部入力のコード
	 * @param name	外部入力の名称
	 * @param price	外部入力の値段
	 */
	public ReProduct(int code, String name, int price) {
		setProduct(code, name, price);
	}
	
	/**
	 * 全ての値をそのままセット、setterがまとまってるだけ
	 * @param code	入力されたコード
	 * @param name	入力された名称
	 * @param price	入力された値段
	 */
	public void 	setProduct(int code, String name, int price) {
		setCode(code);
		setName(name);
		setPrice(price);
		setInformation(setString(code, name, price));
	}
	/**
	 * 受け取った値をformat(%03d,%s,%d)で変換して返す
	 * @param code	入力されたコード
	 * @param name	入力された名称
	 * @param price	入力された値段
	 * @return	String	フォーマットで纏めた情報
	 */
	static String 	setString(int code, String name, int price) {
		String format = "%03d,%s,%d";
		return String.format(format, code, name, price);
	}
	/**
	 * 商品コードの	入力受付
	 * @return	int	入力されたコード
	 */
	public int 		setCode() {
		return this.code = BeforeInput.digit("商品コード", 3);
	}
	/**
	 * 商品名の		入力受付
	 * @return	String	入力された名称
	 */
	public String 	setName() {
		return this.name = BeforeInput.name("商品名", 20);
	}
	/**
	 * 単価の		入力受付
	 * @return	String	入力された値段
	 */
	public int 		setPrice() {
		return this.price = BeforeInput.less("単価", 1000000);
	}
	/**
	 * コードを%03d方式で変換
	 * @param word	判別用
	 * @return	String	型固定のコード(単体)
	 */
	public String 	getCode(String word) {
		return String.format("%03d", code);
	}
	
//	↓---|---|---|---|--- 自動生成 ---|---|---|---|---↓
	
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
