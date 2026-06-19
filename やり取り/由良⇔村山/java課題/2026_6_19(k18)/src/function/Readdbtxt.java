package function;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class Readdbtxt {
	public static String read(String txt) {
		Path Filepath = Path.of(txt);
		try {
			String dbtxt = Files.readString(Filepath, Charset.forName("Shift_JIS"));
			return dbtxt;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
