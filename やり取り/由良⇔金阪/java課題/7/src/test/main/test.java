package test.main;

import java.io.IOException;

public class test {
	
	public static void main(String[] args) {}
	
	public static void m(String[] args) throws IOException {
	/*

		Path path = Paths.get("file.csv");
//	    Set<ProductBean> info = new TreeSet<>();
	    Set<String> info = new TreeSet<>();
//	    ArrayList<ProductBean> info = new ArrayList<>();

//	    try (Stream<String> stream = Files.lines(path)){
//			stream.forEach(line -> System.out.println(line)/* 処理 );
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
//	*/
	}
	public static void ma(String[] args) {
		String s = "a b,c";
//		switch("b") {
//		case "%1s" -> {s = "good";}
//		case "%s" -> {s = "hit";}
//		case ".*" -> {s = "ok";}
//		default -> {s = "no";}
//		}
//		String[] wo = s.split("[ ,.|]");
//		System.out.println(wo[0]);
//		System.out.println(wo[1]);
		int i = 12;
		i+=20;
		System.out.println(i);
		s.matches("");
	}
	public static void mai(String[] args) {
	/*
		try(Connection con = DBManager.getConnection()) {
			String code = "001";
			ArrayList<String> res = ProductSQL.selectSet(con, "SELECT * FROM STOCK WHERE 商品コード = ?", code);
//			ArrayList<String> res = ProductSQL.selectSet(con, "SELECT * FROM STOCK", code);
			System.out.println(res);
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			System.out.println();
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			System.out.println("SQL");
			e.printStackTrace();
		}
//	*/
	}

}
