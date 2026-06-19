package main;

import function.NumInput;
import function.NumInput2;
import function.Select;

public class Practice {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		NumInput n = new NumInput();
		double a = n.Input();
		NumInput2 n2 = new NumInput2();
		double b = n2.Input();
		Select s=new Select();
		int c = s.Select();
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}