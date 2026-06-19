package function;

import etc.KeisanIf2;

public class Waru implements KeisanIf2 {
	@Override
	public double keisan(double x, double y) {
		double a = x;
		double b = y;
		return a/b;
	}
}
