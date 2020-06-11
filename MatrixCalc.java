import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.StringTokenizer;

public class MatrixCalc extends JFrame implements ActionListener
{
	private Matrix a, b;
	private Complex c;
	private JButton add, sub, mult, scal, tran, inv, det, solv, back;
	private JTextArea matA, matB, scalC, ans;

	public MatrixCalc()
	{
		super("Matrix Calculator");
		setSize(925, 250);
		JFrame f = this;

		matA = new JTextArea();
		matB = new JTextArea();
		scalC = new JTextArea();
		ans = new JTextArea();
		ans.setEditable(false);

		JPanel panelMat = new JPanel();
		panelMat.setLayout(new BoxLayout(panelMat, BoxLayout.X_AXIS));
		panelMat.add(Box.createRigidArea(new Dimension(5, 0)));
		panelMat.add(TextPane("Matrix A", matA));
		panelMat.add(Box.createRigidArea(new Dimension(5, 0)));
		panelMat.add(TextPane("Matrix B", matB));
		panelMat.add(Box.createRigidArea(new Dimension(5, 0)));
		panelMat.add(TextPane("Scalar c", scalC));
		panelMat.add(Box.createRigidArea(new Dimension(5, 0)));
		panelMat.add(TextPane("Answer", ans));

		JPanel panelBut = new JPanel();
		panelBut.setLayout(new GridLayout(3, 3));
		add = new JButton("Add A and B");
		sub = new JButton("Subtract B from A");
		mult = new JButton("Multiply A and B");
		scal = new JButton("Multiply A and c");
		tran = new JButton("Transpose of A");
		inv = new JButton("Inverse of A");
		det = new JButton("Determinant of A");
		solv = new JButton("Solves Ax=B for x");
		back = new JButton("Back");

		panelBut.add(add);
		panelBut.add(sub);
		panelBut.add(mult);
		panelBut.add(scal);
		panelBut.add(tran);
		panelBut.add(inv);
		panelBut.add(det);
		panelBut.add(solv);
		panelBut.add(back);

		add.addActionListener(this);
		sub.addActionListener(this);
		mult.addActionListener(this);
		scal.addActionListener(this);
		tran.addActionListener(this);
		inv.addActionListener(this);
		det.addActionListener(this);
		solv.addActionListener(this);
		back.addActionListener(new ActionListener(){
            			public void actionPerformed(ActionEvent e){
                		f.dispose();
            		}
        	});

		add.setActionCommand("add");
		sub.setActionCommand("sub");
		mult.setActionCommand("mult");
		scal.setActionCommand("scal");
		tran.setActionCommand("tran");
		inv.setActionCommand("inv");
		det.setActionCommand("det");
		solv.setActionCommand("solv");

		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));

		mainpanel.add(panelMat);
		mainpanel.add(panelBut);

		add(mainpanel, BorderLayout.CENTER);
		setVisible(true);
       		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JPanel TextPane(String str, JTextArea ta)
	{
		JScrollPane sp = new JScrollPane(ta);
		sp.setPreferredSize(new Dimension(200, 200));

		JLabel label = new JLabel(str);
		label.setLabelFor(sp);

		JPanel textpane = new JPanel();
		textpane.setLayout(new BoxLayout(textpane, BoxLayout.Y_AXIS));
		textpane.add(label);
		textpane.add(sp);
		return textpane;
	}

	public void actionPerformed(ActionEvent evt)
	{
		if (evt.getActionCommand().equals("add"))
		{
			try
			{
				ans.setText(Matrix.add(Read(matA), Read(matB)).toString());
			}
			catch(IllegalArgumentException a)
			{
				ans.setText("Error: " + a);
			}
		}
		else
			if (evt.getActionCommand().equals("sub"))
			{
				try
				{
					ans.setText(Matrix.subtract(Read(matA), Read(matB)).toString());
				}
				catch(IllegalArgumentException a)
				{
					ans.setText("Error: " + a);
				}
			}
			else
				if (evt.getActionCommand().equals("mult"))
				{
					try
					{
						ans.setText(Matrix.matmult(Read(matA), Read(matB)).toString());
					}
					catch(IllegalArgumentException a)
					{
						ans.setText("Error: " + a);
					}
				}
				else
					if (evt.getActionCommand().equals("scal"))
					{
						try
						{
							ans.setText(Matrix.scalmult(Read(matA), Scal(scalC)).toString());
						}
						catch(IllegalArgumentException a)
						{
							ans.setText("Error: " + a);
						}
					}
					else
						if (evt.getActionCommand().equals("tran"))
						{
							try
							{
								ans.setText(Read(matA).transpose().toString());
							}
							catch(IllegalArgumentException a)
							{
								ans.setText("Error: " + a);
							}
						}
						else
							if (evt.getActionCommand().equals("inv"))
							{
								try
								{
									ans.setText(Read(matA).inverse().toString());
								}
								catch(IllegalArgumentException a)
								{
									ans.setText("Error: " + a);
								}
							}
							else
								if (evt.getActionCommand().equals("det"))
								{
									try
									{
										ans.setText(Read(matA).determinant().toString());
									}
									catch(IllegalArgumentException a)
									{
										ans.setText("Error: " + a);
									}
								}
								else
									if (evt.getActionCommand().equals("solv"))
									{
										try
										{
											ans.setText(Matrix.cramerSolve(Read(matA), Read(matB)).toString());
										}
										catch(IllegalArgumentException a)
										{
											ans.setText("Error: " + a);
										}
									}
	}

	public Matrix Read(JTextArea ta)
	{
		String text = ta.getText();
		StringTokenizer st = new StringTokenizer(text, "\n");
		StringTokenizer ts = new StringTokenizer(text, "\n");
		int row = st.countTokens();
		StringTokenizer st2 = new StringTokenizer(ts.nextToken(), ",");
		int col = st2.countTokens();

		Matrix mat = new Matrix(row, col);
		Complex comp;
		double real, imag;

		row = 1;
		col = 1;

		while (st.hasMoreTokens())
		{
			st2 = new StringTokenizer(st.nextToken(), ",");
			while (st2.hasMoreTokens())
			{
				comp = new Solver(st2.nextToken()).getValue();
				mat.assignElement(row, col, comp);
				col++;
			}
			row++;
			col = 1;
		}

		return mat;
	}

	public Complex Scal(JTextArea ta)
	{
		String text = ta.getText();
		Complex comp = new Solver(text).getValue();
		return comp;
	}

	public static void main (String[] args)
	{
		new MatrixCalc();
	}
}
