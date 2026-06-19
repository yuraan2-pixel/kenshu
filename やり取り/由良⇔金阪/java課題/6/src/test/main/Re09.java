package test.main;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import test.function.FileManeger;
import test.function.Input;
//	2026年6月3日
public class Re09 {

	public static void main(String[] args) {
		Set<String> info = new TreeSet<>();
		Input.setLoop(info);
		try {
			FileManeger.writer(info);
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
