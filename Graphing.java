import java.awt.geom.Line2D;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Graphing extends JPanel {
  int width = 500, height = 500;
  int rows, cols;

  String aVal, bVal, cVal;
  double A, B, C;

  public Graphing () {
    super();
    setPreferredSize(new Dimension(width, height));

    // sets up a 10 x 10 coordinate grid
    rows = 20;
    cols = 20;

    aVal = JOptionPane.showInputDialog("Enter A:");
    bVal = JOptionPane.showInputDialog("Enter B:");
    cVal = JOptionPane.showInputDialog("Enter C:");
    convertVals(aVal, bVal, cVal);
}

  // converts user input to doubles
  public void convertVals (String val1, String val2, String val3) {
    A = Double.valueOf(val1);
    B = Double.valueOf(val2);
    C = Double.valueOf(val3);
  }

  public int solveY (int x) {
    int output = (int) (A * x * x + B * x + C);
    return output;
  }

  // scaling height of graph for Ax^2 + Bx + C and Ax^2 + Bx graphs 
  public double scaleBh (double B) {
    double output = 0.0;
    while (B > 0){
        if (B == 1)
            output += (0.25 * 25);
        else if (B % 2 == 0)
            output += (1.75 * 25);
        else
            output += (1.25 * 25);
        B--;
    }
    return output;
  }

  // scaling width of graph for Ax^2 + Bx + C and Ax^2 + Bx graphs 
  public double scaleBw (double B) {
    double output = B;
    if (Math.abs(B) == 3.0)
        output = 1.5;
    while (Math.abs(B) > 3) {
        output += -0.25;
        B--;
    }
    return output;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) (g);

    int i;
    width = getSize().width;
    height = getSize().height;

    BasicStroke bs = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 10);
    BasicStroke bs2 = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 10);
    g2.setStroke(bs);

    // draw the rows
    int rowHt = height / (rows);
    for (i = 0; i < rows; i++) {
        // draws x-axis
        if (i == rows / 2) {
            g2.setStroke(bs2);
            g2.drawLine(0, i * rowHt, width, i * rowHt);
            g2.setStroke(bs);
        }
        else
            g2.drawLine(0, i * rowHt, width, i * rowHt);
    }

    // draw the columns
    int rowWid = width / (cols);
    for (i = 0; i < cols; i++) {
        // draws y-axis
        if (i == cols / 2) {
            g2.setStroke(bs2);
             g2.drawLine(i * rowWid, 0, i * rowWid, height);
            g2.setStroke(bs);
        }
        else
            g2.drawLine(i * rowWid, 0, i * rowWid, height);
    }

    // setting graph color and thickness
    g2.setStroke(bs2);
    Color gColor = new Color(102,153,255);
    g2.setColor(gColor);

    // draes curves Ax^2
    if (A != 0.0 && B == 0.0 && C == 0.0) {
        for (int x = -250; x < 250; x++)
            g2.drawLine(x+250, 
                (-solveY(x) / (25 / (int) A)) / (int) A + 250, 
                x+251, 
                (-solveY(x+1) / (25 / (int) A)) / (int) A + 250);
    }

    // draws curves y = Ax^2 + Bx given B > 0, slightly inaccurate if B > 5
    if (A != 0.0 && B != 0.0 && C == 0.0) {
       for (int x = -250; x < 250; x++)
            g2.draw(new Line2D.Double(x + (250 - (int) B * (25 / 2)), 
                (-solveY(x) / (25 / (int) A)) / (int) A * scaleBw(B) + 250 + scaleBh(B), 
                x + (250 - (int) B * (25 / 2)), 
                (-solveY(x+1) / (25 / (int) A)) / (int) A * scaleBw(B) + 250 + scaleBh(B)));
    }

    // draws curves y = Ax^2 + C
    if (A != 0.0 && B == 0.0 && C != 0.0) {
        for (int x = -250; x < 250; x++)
            g2.drawLine(x+250, 
                (-solveY(x) / (25 / (int) A)) / (int) A + 250 - (25 * (int) C), 
                x+251, 
                (-solveY(x+1) / (25 / (int) A)) / (int) A + 250 - (25 * (int) C));
    }

    // draws curves y = Ax^2 + Bx + C, only works for B = 1
    if (A != 0.0 && B != 0.0 && C != 0.0) {
        for (int x = -250; x < 250; x++)
             g2.draw(new Line2D.Double(x + (250 - (int) B * (25 / 2)), 
                (-solveY(x) / (25 / (int) A)) / (int) A * scaleBw(B) + 250 + scaleBh(B) - (25 * (int) C), 
                x + (250 - (int) B * (25 / 2)), 
                (-solveY(x+1) / (25 / (int) A)) / (int) A * scaleBw(B) + 250 + scaleBh(B) - (25 * (int) C)));
    }

    // draws lines y = Bx
    if (A == 0.0 && B != 0.0 && C == 0.0) {
        for (int x = -250; x < 250; x++)
            g2.drawLine(x+250, 
                -solveY(x) + 250, 
                x+251, 
                -solveY(x+1) + 250);
    }

    // draws lines y = Bx + C
    if (A == 0.0 && B != 0.0 && C != 0.0) {
        for (int x = -250; x < 250; x++)
            g2.drawLine(x+250, 
                -solveY(x) + 250 - (25 * (int) B), 
                x+251, 
                -solveY(x+1) + 250 - (25 * (int) B));
    }

    // draws lines y = C
    if (A == 0.0 && B == 0.0 && C != 0) {
        for (int x = -250; x < 250; x++)
            g2.drawLine(x+250, 
                -solveY(x) + 250 - (25 * (int) C), 
                x+251, 
                -solveY(x+1) + 250 - (25 * (int) C));
    }
  }
}
