package main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

import been.ProductBeans;

public class Mondai09 {
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		TreeSet<ProductBeans> list = new TreeSet<ProductBeans>();
		LABEL1: while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("商品を登録します。");
			System.out.println("商品コードを入力してください。9999と入力すると終了します。");
			int code = scanner.nextInt();
			if (code == 9999) {
				System.out.println("--------------結果を表示します。-----------------");
				try {
					File file = new File("data.txt");
					PrintWriter filewriter = new PrintWriter(file);
				
					for (ProductBeans pb : list) {
						int FormatId = pb.getCode();
						System.out.println((String.format("%03d", FormatId)) + "," + pb.getName() + "," + pb.getCost());
						filewriter.println((String.format("%03d", FormatId)) + "," + pb.getName() + "," + pb.getCost());
					}
					filewriter.close();
					break LABEL1;
				} catch (IOException e) {
					System.out.println(e);
				}
			}

			System.out.println("商品名を入力してください。");
			String name = scanner.next();

			System.out.println("単価を入力してください。");
			int cost = scanner.nextInt();
			ProductBeans pb = new ProductBeans(code, name, cost);
			list.add(pb);
		}
	}
}
