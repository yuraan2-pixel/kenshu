package test.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import test.bean.ProductBean;
import test.function.Mondai07Function;

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
			int code = m07.codeGetter();
			
			if(code == 999) {
				System.out.println("入力終了\n");
				break;
			}
			String name = m07.nameGetter();
			int price = m07.priceGetter();
			
			for(ProductBean pb : al) {
				String[] s = pb.getInformation().split("[,]");
				int i = Integer.parseInt(s[0]);
				if(code == i) {
					System.out.println("更新処理\n");
					al.set(i, new ProductBean(code, name, price));
					break;
				}
			}
			al.add(new ProductBean(code, name, price));
		}
	}

}
