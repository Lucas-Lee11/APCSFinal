import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.StringTokenizer;

public class MatrixCalc extends JFrame implements ActionListener
{
	private Matrix a, b;
	private Complex c;
	private JButton add, sub, mult, scal, tran, inv, det, solv, back;
	private JTextArea taA, taB, taC, taD;

	public MatrixCalc()
	{
		super("Matrix Calculator");
		setSize(925, 250);
		JFrame f = this;

		taA = new JTextArea();
		taB = new JTextArea();
		taC = new JTextArea();
		taD = new JTextArea();
		taD.setEditable(false);

		JPanel panelMat = new JPanel();
		panelMat.setLayout(new BoxLayout(panelMat, BoxLayout.X_AXIS));
		panelMat.add(Box.createRigidArea(new Dimension(5, 0)));
		panelMat.add(TextPane("Matrix A", taA));
		panelMat.add(Box.createRigidArea(new Dimension(5, 0)));
		panelMat.add(TextPane("Matrix B", taB));
		panelMat.add(Box.createRigidArea(new Dimension(5, 0)));
		panelMat.add(TextPane("Scalar c", taC));
		panelMat.add(Box.createRigidArea(new Dimension(5, 0)));
		panelMat.add(TextPane("Answer", taD));

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
		JScrollPane scrollpane = new JScrollPane(ta);
		scrollpane.setPreferredSize(new Dimension(200, 200));

		JLabel label = new JLabel(str);
		label.setLabelFor(scrollpane);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(label);
		panel.add(scrollpane);
		return panel;
	}

	public void actionPerformed(ActionEvent evt)
	{
		if (evt.getActionCommand().equals("add"))
		{	
			try 
			{
				taD.setText(Matrix.add(Read(taA), Read(taB)).toString());
			}
			catch(IllegalArgumentException a)
			{
				taD.setText("Error: " + a);
			}		
		}
		else
			if (evt.getActionCommand().equals("sub"))
			{
				try 
				{
					taD.setText(Matrix.subtract(Read(taA), Read(taB)).toString());
				}
				catch(IllegalArgumentException a)
				{
					taD.setText("Error: " + a);
				}
			}
			else
				if (evt.getActionCommand().equals("mult"))
				{
					try
					{
						taD.setText(Matrix.matmult(Read(taA), Read(taB)).toString());
					}
					catch(IllegalArgumentException a)
					{
						taD.setText("Error: " + a);
					}
				}
				else
					if (evt.getActionCommand().equals("scal"))
					{
						try
						{
							taD.setText(Matrix.scalmult(Read(taA), Scal(taC)).toString());
						}
						catch(IllegalArgumentException a)
						{
							taD.setText("Error: " + a);
						}
					}
					else
						if (evt.getActionCommand().equals("tran"))
						{
							try
							{
								taD.setText(Read(taA).transpose().toString());
							}
							catch(IllegalArgumentException a)
							{
								taD.setText("Error: " + a);
							}
						}
						else
							if (evt.getActionCommand().equals("inv"))
							{
								try
								{
									taD.setText(Read(taA).inverse().toString());
								}
								catch(IllegalArgumentException a)
								{
									taD.setText("Error: " + a);
								}
							}
							else 
								if (evt.getActionCommand().equals("det"))
								{
									try
									{
										taD.setText(Read(taA).determinant().toString());
									}
									catch(IllegalArgumentException a)
									{
										taD.setText("Error: " + a);
									}
								}
								else
									if (evt.getActionCommand().equals("solv"))
									{
										try
										{
											taD.setText(Matrix.cramerSolve(Read(taA), Read(taB)).toString());
										}
										catch(IllegalArgumentException a)
										{
											taD.setText("Error: " + a);
										}
									}
	}

	public Matrix Read(JTextArea ta)
	{
		String text = ta.getText();
		StringTokenizer st = new StringTokenizer(text, "\n");
		StringTokenizer ts = new StringTokenizer(text, "\n");
		int row = st.countTokens();
		StringTokenizer st2 = new StringTokenizer(ts.nextToken(), "+i");
		int col = st2.countTokens() / 2;

		Matrix mat = new Matrix(row, col);
		Complex comp;
		double real, imag;

		row = 1;
		col = 1;

		while (st.hasMoreTokens())
		{
			st2 = new StringTokenizer(st.nextToken(), "+i ");
			while (st2.hasMoreElements())
			{
				real = Double.parseDouble(st2.nextToken());
				imag = Double.parseDouble(st2.nextToken());
				comp = new Complex(real, imag);

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
		StringTokenizer st = new StringTokenizer(text, "+i");
		double real = 0.0;
		double imag = 0.0;
		Complex comp;

		if (st.countTokens() == 0)
			comp = new Complex(0, 0);
		else
			if (st.countTokens() == 1)
			{
				real = Double.parseDouble(st.nextToken());
				comp = new Complex(real, imag);
			}
			else
			{
				real = Double.parseDouble(st.nextToken());
				imag = Double.parseDouble(st.nextToken());
				comp = new Complex(real, imag);
			}
		return comp;
	}

	public static void main (String[] args)
	{
		new MatrixCalc();
	}
}
		
		

		