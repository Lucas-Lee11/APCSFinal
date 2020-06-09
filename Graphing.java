import java.awt.geom.Line2D;
import java.awt.*;
import javax.swing.*;

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

    // draw graph - not working
    for (int x = -500; x < 500; x++)
        g2.drawLine(x, solveY(x) , x+1, solveY(x+1));
  }
}