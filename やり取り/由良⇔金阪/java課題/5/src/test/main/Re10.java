package test.main;

import java.util.Set;
import java.util.TreeSet;

import test.function.FileManeger;
import test.function.Input;

public class Re10 {
	public static void main(String[] args) {
		Set<String> info = new TreeSet<>();
		FileManeger.reader(info);
		Input.setLoop(info);
		FileManeger.writer(info);
	}
}
