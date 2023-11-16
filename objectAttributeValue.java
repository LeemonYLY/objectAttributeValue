package objectAttributeValue;

/*
 * Item attribute value exporter. 
 * As a module in a game, the program calculates the value of an object 
 * according to its properties using different calculation methods, 
 * and randomly outputs the value.
 */
public class objectAttributeValue {
	public static void main(String[] args) {
		double a11 = Double.parseDouble(args[0]);
		double a12 = Double.parseDouble(args[1]);
		double a13 = Double.parseDouble(args[2]);
		double a21 = Double.parseDouble(args[3]);
		double a22 = Double.parseDouble(args[4]);
		double a23 = Double.parseDouble(args[5]);
		double a31 = Double.parseDouble(args[6]);
		double a32 = Double.parseDouble(args[7]);
		double a33 = Double.parseDouble(args[8]);

		double probability = 0.4;

		double random = Math.random(); // Generate a random number between 0 and 1

		double a[][] = { { a11, a12, a13 }, { a21, a22, a23 }, { a31, a32, a33 } };
		if (random < probability) {
			double result1 = determine(a);
			result1 = (double) (Math.round(result1 * 100) / 100);
			System.out.println(result1);
		} else {
			double result2 = matrixOP(a);
			result2 = (double) (Math.round(result2 * 100) / 100);
			System.out.println(result2);
		}
	}

	// The reciprocal of the determinant is multiplied by 100,000
	public static double determine_modified(double[][] a) {
		double item1 = a[0][0] * a[1][1] * a[2][2];
		double item2 = a[0][1] * a[1][2] * a[2][0];
		double item3 = a[0][2] * a[1][0] * a[2][1];

		double item4 = a[0][2] * a[1][1] * a[2][0];
		double item5 = a[0][0] * a[1][2] * a[2][1];
		double item6 = a[0][1] * a[1][0] * a[2][2];

		double result = 100000 / (item1 + item2 + item3 - item4 - item5 - item6);
		return result % 100000;
	}

	// The sum of the main diagonal and the sum of the secondary diagonal elements
	// are multiplied, the rest of the elements are added, and finally divided
	public static double matrixOP(double[][] a) {
		return (a[0][0] + a[1][1] + a[2][2]) * (a[1][1] + a[0][2] + a[2][0]) / (a[0][1] + a[1][0] + a[1][2] + a[2][1])
				% 100000;
	}
}
