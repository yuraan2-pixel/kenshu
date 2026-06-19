package test.main;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import test.bean.ReProduct;
import test.function.FileManeger;
import test.function.Input;

public class Re11 {

	public static void main(String[] args) {
		ArrayList<ReProduct> list = new ArrayList<>();
		Set<String> info = new TreeSet<>();
		FileManeger.reader(list, info);
		Input.dateLoop(list);
		FileManeger.writerList(list);
	}

}
