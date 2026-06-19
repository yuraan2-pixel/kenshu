package test.function;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import test.bean.ReProduct;

public class FileManeger {
	private static Path path = Paths.get("file.csv");
	static String word;
	
	public static void reader(Set<String> set) {
		try (BufferedReader br = Files.newBufferedReader(path)) {
			while((word = br.readLine()) != null) {
				set.add(word);
			}
			System.out.println("要素を取り出しました");
		} catch (NoSuchFileException e) {
			System.out.println("ファイルを読み込めません");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void reader(ArrayList<ReProduct> list, Set<String> set) {
		reader(set);
		for(String info : set) {
			list.add(new ReProduct(info));
		}
	}
	
	public static void writer(Set<String> set) {
		try (BufferedWriter bw = Files.newBufferedWriter(path);) {
			Iterator<String> it = set.iterator();
			while(it.hasNext()) {
				bw.write(it.next() + "\n");
			}
			System.out.println("要素の書き込み完了");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writerList(ArrayList<ReProduct> list) {
		Set<String> info = new TreeSet<>();
		for(ReProduct rp : list) {
			info.add(rp.getInformation());
		}
		writer(info);
	}
	
//	---|---|---|---|--- 自動生成 ---|---|---|---|---
	
	public Path getPath() {
		return path;
	}
	@SuppressWarnings("static-access")
	public void setPath(Path path) {
		this.path = path;
	}
}
