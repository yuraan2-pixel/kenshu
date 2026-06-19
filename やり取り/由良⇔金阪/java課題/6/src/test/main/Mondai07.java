package test.main;
//	2026年5月22日
import test.function.Mondai07Function;

public class Mondai07 {

	public static void main(String[] args) {
		Mondai07Function m07 = new Mondai07Function();
		
		int code[] = new int[3];
		String name[] = new String[3];
		int price[] = new int[3];
		String infomation[] = new String[3];
		// TODO 自動生成されたメソッド・スタブ
		for(int i = 0; i < 3; i++) {
			code[i] = m07.codeGetter();
			name[i] = m07.nameGetter();
			price[i] = m07.priceGetter();
			String f = "%03d,%s,%d";
			infomation[i] = String.format(f, code[i], name[i], price[i]);
			System.out.println("");
		}
		
		for(String i : infomation) {
			System.out.println(i);
		}
		
	}

}
