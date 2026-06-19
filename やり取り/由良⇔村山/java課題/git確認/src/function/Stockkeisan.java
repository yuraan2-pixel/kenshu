package function;

import java.util.Scanner;

public class Stockkeisan {
	public static int stockplus(Scanner scan) {
		while (true) {
			try {
				System.out.println("“üŒÉ”‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢B");
				String num = scan.nextLine();
				int n = Integer.parseInt(num);
				if (n >= 0) {
					return n;
				} else {
					System.out.println("0ˆÈã‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢B");
				}
			} catch (NumberFormatException e) {
				System.out.println("”š‚ğ“ü—Í‚µ‚Ä‰º‚³‚¢B");
			}
		}
	}
}