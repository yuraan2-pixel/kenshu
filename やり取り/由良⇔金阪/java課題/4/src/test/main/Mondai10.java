package test.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import test.bean.ProductBean;
import test.function.Mondai07Function;

//	2026年5月26日
public class Mondai10 {

	public static void main(String[] args) throws IOException {
		Mondai07Function m07 = new Mondai07Function();
		Set<String> info = new TreeSet<>();
		Path path = Paths.get("file.csv");
		String word = "";
		
		try (BufferedReader br = Files.newBufferedReader(path)) {
			while((word = br.readLine()) != null) {
				info.add((word));
			}
			System.out.println("要素を取り出しました");
		}
		
		while(true) {
			int code = m07.codeGetter();
			
			if(code == 999) {
				System.out.println("");
				break;
			}
			info.add(new ProductBean(code, m07.nameGetter(), m07.priceGetter()).getInformation());
			System.out.println("入力完了\n");
		}
		
		try (BufferedWriter bw = Files.newBufferedWriter(path);) {
			Iterator<String> it = info.iterator();
			while(it.hasNext()) {
				bw.write(it.next() + "\n");
			}
			System.out.println("要素の書き込み完了");
		}
	}

}
