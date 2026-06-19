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
	
	/**
	 * 
	 * @param set
	 * @throws IOException 
	 */
	public static void reader(Set<String> set) throws NoSuchFileException ,IOException {
		try (BufferedReader br = Files.newBufferedReader(path)) {
			while((word = br.readLine()) != null) {
				set.add(word);
			}
			System.out.println("要素を取り出しました");
		} catch (NoSuchFileException e) {
			noSuchFileError();
		}
	}
	
	/**
	 * 
	 * @param list
	 * @param set
	 * @throws IOException 
	 */
	public static void reader(ArrayList<ReProduct> list, Set<String> set) throws IOException {
		reader(set);
		for(String info : set) {
			list.add(new ReProduct(info));
		}
	}
	
	/**
	 * 
	 * @param set
	 * @throws IndexOutOfBoundsException
	 * @throws IOException 
	 */
	public static void writer(Set<String> set) throws IOException {
		try (BufferedWriter bw = Files.newBufferedWriter(path);) {
			Iterator<String> it = set.iterator();
			while(it.hasNext()) {
				bw.write(it.next() + "\n");
			}
			System.out.println("要素の書き込み完了");
		}
	}
	
	/**
	 * 
	 * @param list
	 * @throws IOException 
	 * @throws IndexOutOfBoundsException 
	 */
	public static void writerList(ArrayList<ReProduct> list) throws IndexOutOfBoundsException, IOException {
		Set<String> info = new TreeSet<>();
		try {
			for(ReProduct rp : list) {
				info.add(rp.getInformation());
			}
		} catch (IndexOutOfBoundsException e) {
			indexOutBoundsError();
		}
		writer(info);
	}
	
	private static void indexOutBoundsError() throws IndexOutOfBoundsException{
		printError("比較対象が", "登録処理を行います。");
	}
	private static void noSuchFileError() throws NoSuchFileException{
		printError("指定されたファイルが","新規ファイルを作成します。");
	}
	private static void printError(String error, String move) {
		System.out.println(error + "ありません。\n" + move);
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
