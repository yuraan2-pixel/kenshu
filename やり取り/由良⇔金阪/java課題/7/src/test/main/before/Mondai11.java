package test.main.before;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import test.bean.ProductBean;
import test.function.Before.Mondai07Function;

//	2026年5月26日
public class Mondai11 {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("file.csv");
		
		ArrayList<ProductBean> al = new ArrayList<>();
		Mondai07Function m07 = new Mondai07Function();

		
		try (Stream<String> stream = Files.lines(path)){
			stream.forEach(line -> al.add(new ProductBean(line)));
		}
		while(true) {
			boolean upd = false;
			int code = m07.codeGetter();
			
			if(code == 999) {
				System.out.println("入力終了\n");
				break;
			}
			String name = m07.nameGetter();
			int price = m07.priceGetter();
			
			for(int i = 0; i < al.size(); i++) {
				String[] s = al.get(i).getInformation().split("[,]");
				int c = Integer.parseInt(s[0]);
				if(code == c) {
					System.out.println("更新処理\n");
					al.set(i, new ProductBean(code, name, price));
					upd = true;
					break;
				}
			}
			if(!upd) {
				al.add(new ProductBean(code, name, price));
				System.out.println("登録処理\n");
			}
		}
		Set<String> ts = new TreeSet<>();
		
		for(ProductBean pb : al) {
			ts.add(pb.getInformation());
		}
		try (BufferedWriter bw = Files.newBufferedWriter(path);) {
			Iterator<String> it = ts.iterator();
			while(it.hasNext()) {
				bw.write(it.next() + "\n");
			}
			System.out.println("要素の書き込み完了");
		}
	}

}
