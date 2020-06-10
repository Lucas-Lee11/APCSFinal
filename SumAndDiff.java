import java.util.*;

public class SumAndDiff {
	private Angle angle1;
	private Angle angle2;

	// assumes theta1 and theta2 are in degrees
	public SumAndDiff (double theta1, double theta2) {
		angle1 = new Angle(theta1);
		angle2 = new Angle(theta2);
	}

	// Includes steps
	public String sinAdd () {
		String output = "sin(theta1 + theta2) = sin(theta1) * cos(theta2) + cos(theta1) * sin(theta2)" + "\n";
		output += "sin(" + angle1.getDegrees() + "degrees + " + angle2.getDegrees() + " degrees) = "
			+ "sin(" + angle1.getDegrees() + " degrees) * cos(" + angle2.getDegrees() + " degrees) + cos(" + angle1.getDegrees() + " degrees) * sin(" + angle2.getDegrees() + " degrees)" + "\n";
		output += "sin(" + (angle1.getDegrees() + angle2.getDegrees()) + " degrees) = "
			+ angle1.sin() + " * " + angle2.cos() + " + " + angle1.cos() + " * " + angle2.sin() + "\n";
		output += "sin(" + (angle1.getDegrees() + angle2.getDegrees()) + " degrees) = "
			+ ( (angle1.sin() * angle2.cos()) + (angle1.cos() * angle2.sin()) );
		return output;
	}

	// Includes steps
	public String sinSubtract () {
		String output = "sin(theta1 - theta2) = sin(theta1) * cos(theta2) - cos(theta1) * sin(theta2)" + "\n";
		output += "sin(" + angle1.getDegrees() + "degrees - " + angle2.getDegrees() + " degrees) = "
			+ "sin(" + angle1.getDegrees() + " degrees) * cos(" + angle2.getDegrees() + " degrees) - cos(" + angle1.getDegrees() + " degrees) * sin(" + angle2.getDegrees() + " degrees)" + "\n";
		output += "sin(" + (angle1.getDegrees() - angle2.getDegrees()) + " degrees) = "
			+ angle1.sin() + " * " + angle2.cos() + " - " + angle1.cos() + " * " + angle2.sin() + "\n";
		output += "sin(" + (angle1.getDegrees() - angle2.getDegrees()) + " degrees) = "
			+ ( (angle1.sin() * angle2.cos()) - (angle1.cos() * angle2.sin()) );
		return output;
	}

	// Includes steps
	public String cosAdd () {
		String output = "cos(theta1 + theta2) = cos(theta1) * cos(theta2) - sin(theta1) * sin(theta2)" + "\n";
		output += "cos(" + angle1.getDegrees() + "degrees + " + angle2.getDegrees() + " degrees) = "
			+ "cos(" + angle1.getDegrees() + " degrees) * cos(" + angle2.getDegrees() + " degrees) - sin(" + angle1.getDegrees() + " degrees) * sin(" + angle2.getDegrees() + " degrees)" + "\n";
		output += "cos(" + (angle1.getDegrees() + angle2.getDegrees()) + " degrees) = "
			+ angle1.cos() + " * " + angle2.cos() + " - " + angle1.sin() + " * " + angle2.sin() + "\n";
		output += "cos(" + (angle1.getDegrees() + angle2.getDegrees()) + " degrees) = "
			+ ( (angle1.cos() * angle2.cos()) - (angle1.sin() * angle2.sin()) );
		return output;
	}

	// Includes steps
	public String cosSubtract () {
		String output = "cos(theta1 - theta2) = cos(theta1) * cos(theta2) + sin(theta1) * sin(theta2)" + "\n";
		output += "cos(" + angle1.getDegrees() + "degrees + " + angle2.getDegrees() + " degrees) = "
			+ "cos(" + angle1.getDegrees() + " degrees) * cos(" + angle2.getDegrees() + " degrees) + sin(" + angle1.getDegrees() + " degrees) * sin(" + angle2.getDegrees() + " degrees)" + "\n";
		output += "cos(" + (angle1.getDegrees() - angle2.getDegrees()) + " degrees) = "
			+ angle1.cos() + " * " + angle2.cos() + " + " + angle1.sin() + " * " + angle2.sin() + "\n";
		output += "cos(" + (angle1.getDegrees() - angle2.getDegrees()) + " degrees) = "
			+ ( (angle1.cos() * angle2.cos()) + (angle1.sin() * angle2.sin()) );
		return output;
	}

	// Includes steps
	public String tanAdd () {
		String output = "tan(theta1 + theta2) = tan(theta1) + tan(theta2) / 1 - (tan(theta1) * tan(theta2))" + "\n";
		output += "tan(" + angle1.getDegrees() + " degrees + " + angle2.getDegrees() + " degrees) = "
			+ "tan(" + angle1.getDegrees() + " degrees) + tan(" + angle2.getDegrees() + " degrees) / 1 - (tan(" + angle1.getDegrees() + " degrees) * tan(" + angle2.getDegrees() + " degrees))" + "\n";
		output += "tan(" + (angle1.getDegrees() + angle2.getDegrees()) + " degrees) = "
			+ angle1.tan() + " + " + angle2.tan() + " / 1 - (" + angle1.tan() + " * " + angle2.tan() + "))" + "\n";
		output += "tan(" + (angle1.getDegrees() + angle2.getDegrees()) + " degrees) = "
			+ ( (angle1.tan() + angle2.tan()) / (1 - (angle1.tan() * angle2.tan())) );
		return output;
	}

	// Includes steps
	public String tanSubtract () {
		String output = "tan(theta1 - theta2) = tan(theta1) - tan(theta2) / 1 + (tan(theta1) * tan(theta2))" + "\n";
		output += "tan(" + angle1.getDegrees() + " degrees - " + angle2.getDegrees() + " degrees) = "
			+ "tan(" + angle1.getDegrees() + " degrees) - tan(" + angle2.getDegrees() + " degrees) / 1 + (tan(" + angle1.getDegrees() + " degrees) * tan(" + angle2.getDegrees() + " degrees))" + "\n";
		output += "tan(" + (angle1.getDegrees() - angle2.getDegrees()) + " degrees) = "
			+ angle1.tan() + " - " + angle2.tan() + " / 1 + (" + angle1.tan() + " * " + angle2.tan() + "))" + "\n";
		output += "tan(" + (angle1.getDegrees() - angle2.getDegrees()) + " degrees) = "
			+ ( (angle1.tan() - angle2.tan()) / (1 + (angle1.tan() * angle2.tan())) );
		return output;
	}

	public String toString() {
		String output = sinAdd() + "\n";
		output += "\n";
		output += sinSubtract() + "\n";
		output += "\n";
		output += cosAdd() + "\n";
		output += "\n";
		output += cosSubtract() + "\n";
		output += "\n";
		output += tanAdd() + "\n";
		output += "\n";
		output += tanSubtract();
		return output;
	}

	public static void main(String[] args) {
		SumAndDiff z = new SumAndDiff(30, 15);
		System.out.println(z.toString());
	}

}
