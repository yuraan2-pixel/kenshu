package test.main;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import test.function.FileManeger;
import test.function.Input;
//	2026年6月3日
public class Re10 {
	public static void main(String[] args) {
		Set<String> info = new TreeSet<>();
		try {
			FileManeger.reader(info);
			Input.setLoop(info);
			FileManeger.writer(info);
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
