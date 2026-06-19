package test.main;

import java.util.ArrayList;

import test.bean.ReProduct;
import test.function.Input;
//	2026年6月3日
public class Re08 {
	public static void main(String[] args) {
		ArrayList<ReProduct> al = new ArrayList<>();
		while(true) {
			int code = Input.digit("商品コード", 3);
			if(code == 999) {
				break;
			} else al.add(new ReProduct(code));
		}
		for(ReProduct rp : al) {
			System.out.println(rp);
		}
		
	}
}
