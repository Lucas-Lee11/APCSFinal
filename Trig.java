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
	
	public String toString() {
		String output = "sin(" + degrees + " degrees) =" + sin() + "\n";
		output += "cos(" + degrees + " degrees) =" + cos() + "\n";
		output += "tan(" + degrees + " degrees) =" + tan() + "\n";
		output += "sec(" + degrees + " degrees) =" + sec() + "\n";
		output += "csc(" + degrees + " degrees) =" + csc() + "\n";
		output += "cot(" + degrees + " degrees) =" + cot() + "\n";
		output += "asin(" + degrees + " degrees) =" + asin() + "\n";
		output += "acos(" + degrees + " degrees) =" + acos() + "\n";
		output += "atan(" + degrees + " degrees) =" + atan() + "\n";
		output += "sin(" + (degrees / 2) + " degrees) =" + halfsin() + "\n";
		output += "cos(" + (degrees / 2) + " degrees) =" + halfcos() + "\n";
		output += "tan(" + (degrees / 2) + " degrees) =" + halftan() + "\n";
		output += "sin(" + (degrees * 2) + " degrees) =" + doublesin() + "\n";
		output += "cos(" + (degrees * 2) + " degrees) =" + doublecos() + "\n";
		output += "tan(" + (degrees * 2) +" degrees) =" + doubletan();
		return output;
	}
	
	public static void main(String[] args) {
		Trig x = new Trig(30);
		System.out.println(x.toString());
	}

}
