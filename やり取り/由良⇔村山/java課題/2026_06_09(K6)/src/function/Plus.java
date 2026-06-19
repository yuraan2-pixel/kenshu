package function;

import etc.KeisanIf;

public class Plus implements KeisanIf {
	@Override
	public double keisan(double x, double y) {
		return x + y;
	}
}