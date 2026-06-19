package main;

import java.util.List;

import been.ProductBeans;
import function.Readtxt;

public class Practice {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		List<String> text = Readtxt.read();
		for(String line:text) {
			String[]sp=line.split(",");
			ProductBeans pb=new ProductBeans(sp[0],sp[1],sp[2]);
			System.out.println(pb);
		}
	}
}
