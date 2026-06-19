package main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import been.ProductBeans;
import function.ProductcodeInput;
import function.ProductcostInput;
import function.ProductnameInput;
import function.Readtxt;

public class Mondai10 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		try (Scanner scanner = new Scanner(System.in);) {
		Map<String, ProductBeans> list = new TreeMap<String, ProductBeans>();
		LABEL1: while (true) {
			System.out.println("商品を登録します。");
			
//			商品コードの入力処理
			String code=ProductcodeInput.pc(scanner);
			if (code.equals("9999")) {
				System.out.println("--------------結果を表示します。-----------------");
				Readtxt.read();
				try {
					File file = new File("data.txt");
					PrintWriter filewriter = new PrintWriter(file);

					for (String key : list.keySet()) {
						ProductBeans pb = list.get(key);
						System.out.println(pb.getCode()+ "," + pb.getName() + "," + pb.getCost());
						filewriter.println(pb.getCode()+ "," + pb.getName() + "," + pb.getCost());
					}
					filewriter.close();
					break LABEL1;
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			
			
			String a;
			a="a,b,a";
			String[] b;
			b=a.split(",");
			
//			商品名の入力処理
			String name=ProductnameInput.pn(scanner);

//			単価の入力処理
			String cost =ProductcostInput.pco(scanner);;

//			Beans、TreeMapに代入
			ProductBeans pb = new ProductBeans(code, name, cost);
			list.put(code, pb);
		}
		}
	}

}
