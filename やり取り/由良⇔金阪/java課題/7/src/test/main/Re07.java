package test.main;

import java.util.ArrayList;

import test.bean.ReProduct;
//	2026年6月2日
public class Re07 {

	public static void main(String[] args) {
		ArrayList<ReProduct> al = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			al.add(new ReProduct(true));
		}
		for (int i = 0; i < 3; i++) {
			System.out.println(al.get(i).getInformation());
		}
		
	}

}
