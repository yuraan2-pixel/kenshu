package test.main;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import test.bean.ReProduct;
import test.function.Before.BeforeInput;
import test.function.Before.FileManeger;
//	2026年6月3日
public class Re11 {

	/*
	public static void main(String[] args) throws IOException {
		ArrayList<ReProduct> list = new ArrayList<>();
		Set<String> info = new TreeSet<>();
		try {
			FileManeger.reader(list, info);
			Input.dataLoop(list);
			FileManeger.writerList(list);
			
		} catch (IndexOutOfBoundsException e) {
			Input.setLoop(info);
			FileManeger.writer(info);
		}
//		*/
	
//	/*
	public static void main(String[] args) {
		ArrayList<ReProduct> list = new ArrayList<>();
		Set<String> info = new TreeSet<>();
		try {
			FileManeger.reader(list, info);
			BeforeInput.dataLoop(list);
			FileManeger.writerList(list);
			
		} catch (NoSuchFileException | IndexOutOfBoundsException e) {
			BeforeInput.setLoop(info);
				try {
					FileManeger.writer(info);
					
				} catch (IOException e1) {
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
//		*/
	}

}
