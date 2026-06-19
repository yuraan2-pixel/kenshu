package test.function;

public class Mondai07Function extends MondaiFunction {
	
	public int codeGetter() {
		return input("商品コード", 3);
	}
	
	public String nameGetter() {
		return input("商品名", "10");
	}
	
	public int priceGetter() {
		return super.input("単価", 0, 1000000);
	}
	
}
