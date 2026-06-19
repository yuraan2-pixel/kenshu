package main;

import java.util.Scanner;

import been.ProductBeansdami;

public class Mondai07 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scanner = new Scanner(System.in);
		ProductBeansdami[] list=new ProductBeansdami[3];
		System.out.println("これから3つの商品を登録していきます。");
		for(int i=0;i<list.length;i++) {
		list[i] =new ProductBeansdami();
		System.out.println("商品コードを入力してください。");
		int code = scanner.nextInt();
		list[i].setCode(code);
		
		System.out.println("商品名を入力してください。");
		String name=scanner.next();
		list[i].setName(name);
		
		System.out.println("単価を入力してください。");
		int cost=scanner.nextInt();
		list[i].setCost(cost);
		}
		for(ProductBeansdami pb:list){
			int FormatId=pb.getCode();
			System.out.println((String.format("「%03d」", FormatId))+","+pb.getName()+","+pb.getCost());
		}
	}

}
