package test.main;

import java.util.ArrayList;

import test.bean.ProductBean;
import test.function.Mondai07Function;

//	2026年5月22日
public class Mondai08 {
	public static void main(String[] args) {
		ArrayList<ProductBean> info = new ArrayList<>();
		Mondai07Function m07 = new Mondai07Function();
		
		while(true) {
			int code = m07.codeGetter();
			
			if(code == 999) {
				System.out.println("");
				break;
			}
			info.add(new ProductBean(code, m07.nameGetter(), m07.priceGetter()));
			System.out.println("");
		}
		for(int i = 0; i < info.size(); i++) {
			System.out.println(info.get(i));
		}
		
	}
	
}
