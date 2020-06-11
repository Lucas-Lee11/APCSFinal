import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class GraphingCalc extends JFrame{
  public GraphingCalc() {
    JFrame f = this;
  	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	setResizable(false);

    JButton back = new JButton("Back");
    back.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            f.dispose();
        }
    });

    Graphing x = new Graphing();
    x.add(back);
    add(x);
    pack();
    setVisible(true);
    }

}
