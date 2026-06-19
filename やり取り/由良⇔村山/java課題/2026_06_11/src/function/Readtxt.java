package function;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Readtxt {
	public static List<String> read() {
		try {
			List<String> allLines = Files.readAllLines(Paths.get("data.txt"));
			return allLines;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
