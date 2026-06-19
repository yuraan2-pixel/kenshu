package test.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import test.bean.ProductBean;

public class test {
	public static void main(String[] args) throws IOException {
	    Path path = Paths.get("file.csv");
//	    Set<ProductBean> info = new TreeSet<>();
	    Set<String> info = new TreeSet<>();
//	    ArrayList<ProductBean> info = new ArrayList<>();

//	    try (Stream<String> stream = Files.lines(path)){
//			stream.forEach(line -> System.out.println(line)/* 処理 */);
//			System.out.println("test");
//	    }
	    
	    String word = "";
		
		try (BufferedReader br = Files.newBufferedReader(path)) {
			while((word = br.readLine()) != null) {
//				System.out.println(word);
				info.add(new ProductBean(word).getInformation());
//				info.add(word);
				}
			Iterator<String> it = info.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
			
		}
	}
}
