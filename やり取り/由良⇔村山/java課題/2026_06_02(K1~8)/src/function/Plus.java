package function;

import etc.KeisanIf1;

public class Plus implements KeisanIf1 {
	@Override
	public int keisan(int x, int y) {
		return x + y;
	}
}