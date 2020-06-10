import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener {
  public Main() {
  	setDefaultCloseOperation(this.EXIT_ON_CLOSE);
  	setResizable(false);

    JButton back = new JButton("Back");
    back.addActionListener(this);

    Graphing x = new Graphing();
    x.add(back);

    add(x);
    pack();
    setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
    	this.dispose();
    	new Calculator();
    }
}
