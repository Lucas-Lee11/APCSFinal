import java.util.*;

public class Trig {
	private double degrees;
	private double radians;

	// assumes theta is in degrees
	public Trig (double theta) {
		degrees = theta;
		radians = Math.toRadians(theta);
	}

	public double sin() {
		return Math.sin(radians);
	}

	public double cos() {
		return Math.cos(radians);
	}

	public double tan() {
		return Math.tan(radians);
	}

	public double csc() {
		return (1 / Math.sin(radians));
	}

	public double sec() {
		return (1 / Math.cos(radians));
	}

	public double cot() {
		return (1 / Math.tan(radians));
	}

	public double asin() {
		return Math.asin(radians);
	}

	public double acos() {
		return Math.acos(radians);
	}

	public double atan() {
		return Math.atan(radians);
	}

	public double halfsin() {
		return Math.pow( (1 - Math.cos(radians)) / 2, 0.5 );
	}

	public double halfcos() {
		return Math.pow( (1 + Math.cos(radians)) / 2, 0.5 );
	}

	public double halftan() {
		return Math.pow( (1 - Math.cos(radians)) / (1 + Math.cos(radians)) , 0.5 );
	}

	public double doublesin() {
		return ( 2 * Math.sin(radians) * Math.cos(radians) );
	}

	public double doublecos() {
		return ( Math.pow(Math.cos(radians), 2) - Math.pow(Math.cos(radians), 2) );
	}

	public double doubletan() {
		return ( 2 * Math.tan(radians) / (1 - Math.pow(Math.tan(radians), 2)) );
	}

}