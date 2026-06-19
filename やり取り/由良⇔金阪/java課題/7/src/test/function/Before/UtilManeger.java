package test.function.Before;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

import test.bean.ProductBean;

public class UtilManeger {
	
	/**
	 * Pathをstreamに代入してforEachでalに要素を格納する
	 * @param path
	 * @param al
	 * @throws IOException
	 */
	public static void loading(Path path, ArrayList<String> al) throws IOException {
		try (Stream<String> stream = Files.lines(path)){
			stream.forEach(line -> al.add(line));
		}
	}
	
	
	public static void writing(Path path, Set<String> set) throws IOException {
		try (BufferedWriter bw = Files.newBufferedWriter(path);) {
			Iterator<String> it = set.iterator();
			while(it.hasNext()) {
				bw.write(it.next() + "\n");
			}
		System.out.println("要素の書き込み完了");
		}
	}
	
	/**
	 * 登録
	 * @param al
	 */
	public static void registration(ArrayList<ProductBean> al) {
		Mondai07Function m07 = new Mondai07Function();

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
				int alc = al.get(i).getCode();
				if(code == alc) {
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
	}
	
	/**
	 * 登録
	 * @param set
	 */
	public static void registration(Set<String> set) {
		Mondai07Function m07 = new Mondai07Function();
		ProductBean pb;
		
		while(true) {
			boolean upd = false;
			int code = m07.codeGetter();
			
			if(code == 999) {
				System.out.println("入力終了\n");
				break;
			}
			for(String word : set) {
				pb = new ProductBean(word);
				if(code == pb.getCode()) {
					System.out.println("登録済みのコードです\n");
					upd = true;
					break;
				}
			}
			
			if(!upd) {
				String name = m07.nameGetter();
				int price = m07.priceGetter();
				set.add(new ProductBean(code, name, price).getInformation());
				System.out.println("登録処理\n");
			}
		}
	}
	
	public static void indication(Set<String> set) {
		for(String info : set) {
			String[] s = info.split("[,]");
			String format = "コード＝%03d、商品名＝%s、単価＝%s";
			System.out.println(String.format(format, Integer.parseInt(s[0]), s[1], s[2]));
		}
	}

	public static void indication(ArrayList<String> al) {
		for(int i = 0; i < al.size(); i++) {
			String[] s = al.get(i).split("[,]");
			String format = "コード＝%03d、商品名＝%s、単価＝%s";
			System.out.println(String.format(format, Integer.parseInt(s[0]), s[1], s[2]));
		}
	}

	public static void indicationP(ArrayList<ProductBean> al) {
		for(int i = 0; i < al.size(); i++) {
			String[] s = al.get(i).getInformation().split("[,]");
			String format = "コード＝%03d、商品名＝%s、単価＝%s";
			String st = String.format(format, Integer.parseInt(s[0]) , s[1], s[2]);
			System.out.println(st);
		}
	}
}
