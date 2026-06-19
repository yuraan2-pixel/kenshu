package test.main;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import test.function.Before.BeforeInput;
import test.function.Before.FileManeger;
//	2026年6月3日
public class Re09 {

	public static void main(String[] args) {
		Set<String> info = new TreeSet<>();
		BeforeInput.setLoop(info);
		try {
			FileManeger.writer(info);
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
