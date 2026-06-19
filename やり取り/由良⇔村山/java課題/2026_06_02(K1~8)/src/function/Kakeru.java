package function;

import etc.KeisanIf1;

public class Kakeru implements KeisanIf1 {
	@Override
	public int keisan(int x, int y) {
		return x * y;
	}
}