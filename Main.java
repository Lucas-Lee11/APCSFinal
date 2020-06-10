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
    setVisible(true);
  }

}
