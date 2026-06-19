package main;

import java.math.BigDecimal;
import java.math.RoundingMode;

import etc.KeisanIf;
import function.Mainus;
import function.NumInput;
import function.NumInput2;
import function.Plus;

public class Practice {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		KeisanIf a=new Mainus();
		a=new Plus();
		double number1 = NumInput.Input();
		double number2 = NumInput2.Input();
		BigDecimal bd01 = new BigDecimal(a.keisan(number1, number2));
		BigDecimal bd1 = bd01.setScale(3, RoundingMode.DOWN);
		System.out.println("結果：" + bd1);
	}
}