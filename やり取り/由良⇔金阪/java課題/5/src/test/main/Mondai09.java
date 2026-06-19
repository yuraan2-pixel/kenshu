package test.main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import test.bean.ProductBean;
import test.function.Mondai07Function;
//	2026年5月26日
public class Mondai09 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList<ProductBean> info = new ArrayList<>();
		Mondai07Function m07 = new Mondai07Function();
		Path path = Paths.get("file.csv");
		
		while(true) {
			int code = m07.codeGetter();
			
			if(code == 999) {
				System.out.println("");
				break;
			}
			info.add(new ProductBean(code, m07.nameGetter(), m07.priceGetter()));
			System.out.println("");
		}
		try (BufferedWriter bw = Files.newBufferedWriter(path);) {
			for(int i = 0; i < info.size(); i++) {
				bw.write(info.get(i) + "\n");
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		System.out.println("end");
	}

}
