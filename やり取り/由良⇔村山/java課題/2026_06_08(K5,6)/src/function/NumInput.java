package function;

import java.util.Scanner;

public class NumInput {
	public double Input() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("1‚Â–Ú‚Ì”š‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢B");
			double num = scanner.nextDouble();
			if (num >= -100 && num <= 100) {
				return num;
			}
			System.out.println("-100`100‚Ì”ÍˆÍ‚Å”š‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢B");
		}
	}
}