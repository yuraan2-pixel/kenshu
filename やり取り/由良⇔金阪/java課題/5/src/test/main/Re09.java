package test.main;

import java.util.ArrayList;

import test.bean.ReProduct;
import test.function.FileManeger;
import test.function.Input;

public class Re09 {

	public static void main(String[] args) {
		ArrayList<ReProduct> al = new ArrayList<>();
		Input.listLoop(al);
		FileManeger.writerList(al);
	}

}
