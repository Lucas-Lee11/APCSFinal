import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
  public Main() {
  	setDefaultCloseOperation(this.EXIT_ON_CLOSE);
  	setResizable(false);
    Graphing x = new Graphing();
    add(x);
    pack();
  }

  public static void main(String[] a) {
    new Main().setVisible(true);
  }
}