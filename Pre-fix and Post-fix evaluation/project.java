import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class project extends JFrame {

    JLabel l1, l2;
    JButton b1;

    public project() {
        super("PROJECT");
        setLayout(null);

        l1 = new JLabel(".. Welcome To Our Project ..");
        l1.setFont(new Font("Serif", Font.BOLD, 30));
        l1.setBounds(65, 50, 400, 50);
        add(l1);
        l2 = new JLabel("This program is to evaluate postfix & prefix expressions");
        l2.setFont(new Font("Serif", Font.BOLD, 20));
        l2.setBounds(10, 150, 500, 50);
        add(l2);
        //for starting
        b1 = new JButton("START");
        b1.setFont(new Font("Serif", Font.BOLD, 15));
        b1.setBounds(200, 300, 100, 50);
        add(b1);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                evaluate e = new evaluate();
                e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                e.setSize(500, 450);
                e.setVisible(true);
            }
        }
        );
    }

    public static void main(String[] args) {
        project p = new project();
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setSize(500, 450);
        p.setVisible(true);
    }
}
