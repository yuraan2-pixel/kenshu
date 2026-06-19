package function;

import etc.KeisanIf;

public class Waru implements KeisanIf {
	@Override
	public double keisan(double x, double y) {
		return x / y;
	}

}
