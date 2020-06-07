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

	// Includes steps
	public String halfsin() {
		String output = "sin(theta / 2) = sqrt((1 - cos(theta)) / 2)" + "\n";
	    output += "sin(" + (degrees / 2) + " degrees)) = sqrt((1 - cos(" + degrees + " degrees) / 2)" + "\n";
	    output += "sin(" + (degrees / 2) + " degrees) = sqrt((1 - " + Math.cos(radians) + ") / 2)" + "\n";
		output += "sin(" + (degrees / 2) + " degrees) = " + Math.pow( (1 - Math.cos(radians)) / 2, 0.5 );
		return output;
	}

	// Includes steps
	public String halfcos() {
	    String output = "cos(theta / 2) = sqrt((1 + cos(theta)) / 2)" + "\n";
	    output += "cos(" + (degrees / 2) + " degrees)) = sqrt((1 + cos(" + degrees + " degrees) / 2)" + "\n";
	    output += "cos(" + (degrees / 2) + " degrees) = sqrt((1 + " + Math.cos(radians) + ") / 2)" + "\n";
		output += "cos(" + (degrees / 2) + " degrees) = " + Math.pow( (1 + Math.cos(radians)) / 2, 0.5 );
		return output;
	}

	// Includes steps
	public String halftan() {
	    String output = "tan(theta / 2) = sqrt((1 - cos(theta)) / (1 + cos(theta)))" + "\n";
	    output += "tan(" + (degrees / 2) + " degrees) = sqrt((1 - cos(" + degrees + " degrees)) / (1 + cos(" + degrees + " degrees)))" + "\n";
	    output += "tan(" + (degrees / 2) + " degrees) = sqrt((1 - " + Math.cos(radians) + ") / (1 + " + Math.cos(radians) + "))" + "\n";
		output += "tan(" + (degrees / 2) + " degrees) = " + Math.pow( (1 - Math.cos(radians)) / (1 + Math.cos(radians)) , 0.5 ) ;
		return output;
	}

	// Includes steps
	public String doublesin() {
	    String output = "sin(2 * theta) = 2 * sin(theta) * cos(theta)" + "\n";
	    output += "sin (" + (2 * degrees) + " degrees) = 2 * sin(" + degrees + " degrees) * cos(" + degrees + " degrees)" + "\n";
	    output += "sin (" + (2 * degrees) + " degrees) = 2 * " + Math.sin(radians) + " * " + Math.cos(radians) + "\n";
		output += "sin (" + (2 * degrees) + " degrees) = " + ( 2 * Math.sin(radians) * Math.cos(radians) );
		return output;
	}

	// Includes steps
	public String doublecos() {
	    String output = "cos(2 * theta) = cos^2(theta) - sin^2(theta)" + "\n";
	    output += "cos(" + (2 * degrees) + " degrees) = cos^2(" + degrees + " degrees) - sin^2(" + degrees + " degrees)" + "\n";
	    output += "cos(" + (2 * degrees) + " degrees) = " + Math.pow(Math.cos(radians), 2) + " - " + Math.pow(Math.cos(radians), 2) + "\n";
		output += "cos(" + (2 * degrees) + " degrees) = " + ( Math.pow(Math.cos(radians), 2) - Math.pow(Math.cos(radians), 2) );
		return output;
	}

	// Includes steps
	public String doubletan() {
		String output = "tan(2 * theta) = 2tan(theta) / (1 - tan^2(theta))" + "\n";
		output += "tan(" + (2 * degrees) + " degrees) = 2tan(" + degrees + " degrees) / (1 - tan^2(" + degrees + " degrees))" + "\n";
		output += "tan(" + (2 * degrees) + " degrees) = " + (2 * Math.tan(radians)) + " / (1 - " + Math.pow(Math.tan(radians), 2) + ")" + "\n";
		output += "tan(" + (2 * degrees) + " degrees) = " + ( 2 * Math.tan(radians) / (1 - Math.pow(Math.tan(radians), 2)) );
		return output;
	}
	
	public double getDegrees() {
		return degrees;
	}
	
	public double getRadians() {
		return radians;	
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
		output += "\n";
		output += halfsin() + "\n";
		output += "\n";
		output += halfcos() + "\n";
		output += "\n";
		output += halftan() + "\n";
		output += "\n";
		output += doublesin() + "\n";
		output += "\n";
		output += doublecos() + "\n";
		output += "\n";
		output += doubletan();
		return output;
	}
	
	public static void main(String[] args) {
		Trig x = new Trig(30);
		System.out.println(x.toString());
	}

}
