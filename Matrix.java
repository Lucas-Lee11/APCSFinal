import java.util.Scanner;

public class Matrix
{
	private Complex[][] matrix;
	private int rownum, colnum;

	//Creates a zero matrix with specified dimensions.

	public Matrix (int row, int col)
	{
		if (row < 0)
			row = -1 * row;
		else
			if (row == 0)
				row = 1;

		if (col < 0)
			col = -1 * col;
		else
			if (col == 0)
				col = 1;

		matrix = new Complex[row][col];
		rownum = row;
		colnum = col;

		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				matrix[i][j] = new Complex(0, 0);
	}

	//Creates a matrix using a given 2D array.

	public Matrix (Complex[][] m)
	{
		matrix = m;
		rownum = m.length;
		colnum = m[0].length;
	}

	//Creates a matrix with user-input. Not recommended for large matrices.

	public Matrix ()
	{
		Scanner sc = new Scanner (System.in);
		double real, imaginary;

		System.out.println ("Enter the number of rows:");
		rownum = sc.nextInt();

		if (rownum < 0)
			rownum = -1 * rownum;
		else
			if (rownum == 0)
				rownum = 1;

		System.out.println ("Enter the number of columns:");
		colnum = sc.nextInt();

		if (colnum < 0)
			colnum = -1 * colnum;
		else
			if (colnum == 0)
				colnum = 1;

		matrix = new Complex[rownum][colnum];

		for (int i = 0; i < rownum; i++)
		{
			int k = i + 1;
			for (int j = 0; j < colnum; j++)
			{
				int l = j + 1;
				System.out.println ("For row " + k + ", column " + l);
				System.out.println ("Enter the real part:");
				real = sc.nextDouble();
				System.out.println ("Enter the imaginary part:");
				imaginary = sc.nextDouble();

				matrix[i][j] = new Complex(real, imaginary);
			}
		}
	}

	public int getnumRow()
	{
		return rownum;
	}

	public int getnumCol()
	{
		return colnum;
	}

	public Complex getElement(int row, int col)
	{
		return matrix[row - 1][col - 1];
	}

	public void assignElement(int row, int col, Complex entry)
	{
		matrix[row - 1][col - 1] = entry;
	}

	//Returns the dxd identity matrix.

	public static Matrix Identity(int row)
	{
		Complex[][] m = new Complex[row][row];
		
		for (int i = 0; i < row; i++)
			for (int j = 0; j < row; j++)
				m[i][j] = new Complex(1, 0);

		Matrix mat = new Matrix(m);
		return mat;
	}

	//Returns the sum of two matrices.

	public static Matrix add(Matrix a, Matrix b)
	{
		int row = a.getnumRow();
		int col = a.getnumCol();

		Complex entry = new Complex(0, 0);

		if (a.getnumRow() == b.getnumRow() && a.getnumCol() == b.getnumCol())
		{
			Matrix c = new Matrix(a.getnumRow(), a.getnumCol());

			for (int i = 1; i <= row; i++)
				for (int j = 1; j <= col; j++)
				{
					entry = Complex.add(a.getElement(i, j), b.getElement(i, j));
					c.assignElement(i, j, entry);
				}	
			
			return c;
		}
		else
		{
			System.out.println ("Error: dimensions of the matrices don't match.");
			return null;
		}
	}

	//Returns the product of two matrices.

	public static Matrix matmult(Matrix a, Matrix b)
	{
		int rowa = a.getnumRow();
		int colb = b.getnumCol();
		int rowb = b.getnumRow();
		int cola = a.getnumCol();
		Complex entry = new Complex(0, 0);
		Complex zero = new Complex(0, 0);


		if (cola == rowb)
		{
			Matrix c = new Matrix(rowa, colb);
			
			for (int i = 1; i <= rowa; i++)
				for (int j = 1; j <= colb; j++)
				{
					for (int k = 1; k <= cola; k++)
							entry = Complex.add(entry, Complex.mult(a.getElement(i, k), b.getElement(k, j)));

					c.assignElement(i, j, entry);
					entry = zero;
				}

			return c;
		}
		else
		{
			System.out.println("Error: factors are of wrong dimension.");
			return null;
		}
	}

	//Computes the product of a matrix and a scalar.

	public static Matrix scalmult(Matrix a, Complex b)
	{
		for (int i = 1; i <= a.getnumRow(); i++)
			for (int j = 1; j <= a.getnumCol(); j++)
				a.assignElement(i, j, Complex.mult(a.getElement(i, j), b));
		return a;
	}

	//Computes the difference between two matrices.

	public static Matrix subtract(Matrix a, Matrix b)
	{
		Complex c = new Complex(-1, 0);
		Matrix result = Matrix.add(a, Matrix.scalmult(b, c));
		return result;
	}

	//Computes the transpose of a matrix;

	public Matrix transpose()
	{
		Matrix b = new Matrix(colnum, rownum);

		for (int i = 1; i <= rownum; i++)
			for (int j = 1; j <= colnum; j++)
				assignElement(i, j, getElement(i, j).conjugate());

		for (int i = 1; i <= colnum; i++)
			for (int j = 1; j <= rownum; j++)
				b.assignElement(i, j, getElement(j, i));
	
		return b;
	}

	//Returns the determinant of the matrix using cofactor expansion.

	public Complex determinant()
	{
		Complex det = new Complex(0, 0);
		Complex negone = new Complex (-1, 0);
		if (rownum != colnum)
			return null;

		if (rownum == 1)
			return getElement(1, 1);
		
		if (rownum == 2)
		{
			Complex prod1 = Complex.mult(getElement(1, 1), getElement(2, 2));
			Complex prod2 = Complex.mult(getElement(1, 2), getElement(2, 1));
			det = Complex.sub(prod1, prod2);
			return det;
		}

		for (int i = 1; i <= colnum; i++)
		{
			double pow = (double) i + 1;
			Complex power = new Complex(pow, 0);
			Complex cofactor = Complex.mult(Complex.pow(negone, power), minor(1, i).determinant());
			det = Complex.add(det, Complex.mult(cofactor, getElement(1, i)));
		}

		return det;
	}

	//Returns the i,j minor of the matrix.

	public Matrix minor(int i, int j)
	{
		int row = rownum - 1;
		int col = colnum - 1;
		int c, d;

		Matrix b = new Matrix(row, col);

		for (int k = 1; k <= row; k++)
			for (int l = 1; l <= col; l++)
			{
				c = k;
				d = l;
				
				if (k >= i)
					c++;
				if (l >= j)
					d++;
				b.assignElement(k, l, getElement(c, d));
			}

		return b;
	}

	//Returns the inverse of a square matrix.

	public Matrix inverse()
	{
		Complex zero = new Complex(0,0);
		Complex negone = new Complex(-1, 0);
		Complex one = new Complex (1, 0);

		if (rownum != colnum)
		{
			System.out.println("Not a square matrix.");
			return null;
		}

		Complex det = determinant();
		if (det.equals(zero))
		{
			System.out.println("Matrix is not invertible.");
			return null;
		}

		Matrix cofactor = new Matrix(rownum, colnum);

		det = Complex.pow(det, negone);

		for (int i = 1; i <= rownum; i++)
			for (int j = 1; j <= colnum; j++)
			{
				double pow = (double) i + j;
				Complex power = new Complex(pow, 0);
				cofactor.assignElement(i, j, (Complex.mult(Complex.pow(negone, power), minor(i, j).determinant())));
			}

		cofactor = Matrix.scalmult(cofactor.transpose(), det);

		return cofactor;
	}

	//Adds scalar times row1 to row2 of a matrix.

	public void rowAdd (Complex scalar, int row1, int row2)
	{
		Complex[][] temp = matrix;
		for (int j = 0; j < colnum; j++)
			temp[row1 - 1][j] = Complex.mult(matrix[row1 - 1][j], scalar);
		for (int k = 0; j < colnum; k++)
			temp[row2 - 1][j] = Complex.add(temp[row1 - 1][j], matrix[row2 - 1][j]);

		matrix = temp;
	}

	public static boolean isEqual(Matrix a, Matrix b)
	{
		boolean result = true;
		if (a.getnumRow() == b.getnumRow() && a.getnumCol() == b.getnumCol())
			for (int i = 1; i <= a.getnumRow(); i++)
				for (int j = 1; j <= a.getnumCol(); j++)
					if (!(a.getElement(i, j).equals(b.getElement(i, j))))
						return false;
		else
			return false;
		return false;
	}

	public String toString()
	{
		String result = new String("");
		
		for (int i = 0; i < rownum; i++)
		{
			result += "[";
			for (int j = 0; j < colnum; j++)
			{
				result += matrix[i][j];
				result += " ";
			}
			
			result += "]\n";
		}

		return result;
	}
}

		
			



	

			



