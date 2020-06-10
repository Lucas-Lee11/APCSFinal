import java.util.*;

public class SumAndDiffFormulas {
	private Angle angle1;
	private Angle angle2;

	// assumes theta1 and theta2 are in degrees
	public SumAndDiffFormulas (double theta1, double theta2) {
		angle1 = new Angle(theta1);
		angle2 = new Angle(theta2);
	}

	public double sinAdd () {
		return ( (angle1.sin() * angle2.cos()) + (angle2.cos() * angle1.sin()) );
	}

	public double sinSubtract () {
		return ( (angle1.sin() * angle2.cos()) - (angle2.cos() * angle1.sin()) );
	}

	public double cosAdd () {
		return ( (angle1.cos() * angle2.cos()) - (angle1.sin() * angle2.sin()) );
	}

	public double cosSubtract () {
		return ( (angle1.cos() * angle2.cos()) + (angle1.sin() * angle2.sin()) );
	}

	public double tanAdd () {
		return ( (angle1.tan() + angle2.tan()) / (1 - (angle1.tan() * angle2.tan())) );
	}

	public double tanSubtract () {
		return ( (angle1.tan() - angle2.tan()) / (1 + (angle1.tan() * angle2.tan())) );
	}
}
