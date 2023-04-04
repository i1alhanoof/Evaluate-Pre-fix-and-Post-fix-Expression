
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class evaluate extends JFrame {

    JLabel l1, l2, l3, l4;
    JTextField t1;
    JRadioButton r1, r2;
    ButtonGroup bg;
    JButton b1, b2;

    public evaluate() {
        super("Evaluate Program");
        setLayout(null);

        // for exp type
        l1 = new JLabel("Choose your expression:");
        l1.setFont(new Font("Serif", Font.BOLD, 25));
        l1.setBounds(125, 20, 300, 30);
        add(l1);
        r1 = new JRadioButton("Postfix");
        r1.setFont(new Font("Serif", Font.PLAIN, 20));
        r1.setBounds(135, 60, 100, 50);
        add(r1);
        r2 = new JRadioButton("Prefix");
        r2.setFont(new Font("Serif", Font.PLAIN, 20));
        r2.setBounds(285, 60, 100, 50);
        add(r2);
        bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        // for write exp
        l2 = new JLabel("Write your expression:");
        l2.setFont(new Font("Serif", Font.BOLD, 25));
        l2.setBounds(125, 120, 400, 30);
        add(l2);
        t1 = new JTextField(100);
        t1.setFont(new Font("Serif", Font.PLAIN, 20));
        t1.setBounds(100, 160, 300, 35);
        add(t1);
        // for anser
        l3 = new JLabel("The answer of evaluation:");
        l3.setFont(new Font("Serif", Font.BOLD, 25));
        l3.setBounds(120, 260, 400, 30);
        add(l3);
        l4 = new JLabel("");
        l4.setFont(new Font("Serif", Font.PLAIN, 20));
        l4.setForeground(Color.red);
        add(l4);

        // for evaluate
        b1 = new JButton("Solve");
        b1.setFont(new Font("Serif", Font.BOLD, 15));
        b1.setBounds(200, 200, 100, 40);
        add(b1);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //if we press on solve button
                if (event.getSource() == b1) {
                    //evaluate by postfix 
                    if (r1.isSelected()) {
                        String exp = t1.getText();
                        Stack<Integer> stack = new Stack<Integer>();
                        for (int i = 0; i < exp.length(); i++) {// 23+4-
                            char c = exp.charAt(i);
                            if (Character.isDigit(c)) {// 89&
                                stack.push((c - '0'));
                            } else if (Character.isLetter(c)) {
                                l4.setText("INVALID INPUT (enter number)");
                                l4.setBounds(130, 300, 300, 35);
                            } else {
                                int n1 = stack.pop();
                                int n2 = stack.pop();
                                switch (c) {
                                    case '+':
                                        stack.push(n2 + n1);
                                        break;
                                    case '-':
                                        stack.push(n2 - n1);
                                        break;
                                    case '/':
                                        stack.push(n2 / n1);
                                        break;
                                    case '*':
                                        stack.push(n2 * n1);
                                        break;
                                    case '^':
                                        stack.push((int) (Math.pow(n2, n1)));
                                        break;
                                    case '%':
                                        stack.push(n2 % n1);
                                        break;
                                    default:
                                        l4.setText("INVALID INPUT (enter +,-,/,*,^)");
                                        l4.setBounds(115, 300, 300, 35);
                                        break;
                                }
                            }
                        }
                        l4.setText(stack.pop() + "");
                        l4.setBounds(240, 300, 300, 35);

                        //evaluate by prefix
                    } else if (r2.isSelected()) {
                        String exp = t1.getText();
                        Stack<Integer> stack = new Stack<Integer>();
                        String str = "";
                        for (int i = 0; i < exp.length(); i++) { //-23
                            char ch = exp.charAt(i);
                            str = ch + str;
                            // 32-
                        }
                        for (int i = 0; i < str.length(); i++) { // 32-
                            char c = str.charAt(i);
                            if (Character.isDigit(c)) {
                                stack.push(c - '0');
                            } else if (Character.isLetter(c)) {
                                l4.setText("INVALID INPUT (enter digit)");
                                l4.setBounds(130, 300, 300, 35);
                            } else {
                                int n1 = stack.pop();
                                int n2 = stack.pop();
                                switch (c) {
                                    case '+':
                                        stack.push(n1 + n2);
                                        break;
                                    case '-':
                                        stack.push(n1 - n2);
                                        break;
                                    case '/':
                                        stack.push(n1 / n2);
                                        break;
                                    case '*':
                                        stack.push(n1 * n2);
                                        break;
                                    case '^':
                                        stack.push((int) (Math.pow(n1, n2)));
                                        break;
                                    case '%':
                                        stack.push(n1 % n2);
                                        break;
                                    default:
                                        l4.setText("INVALID INPUT (enter +,-,/,*,^)");
                                        l4.setBounds(115, 300, 300, 35);
                                        break;
                                }
                            }
                        }
                        l4.setText(stack.pop() + "");
                        l4.setBounds(240, 300, 300, 35);
                    }
                }
            }
        }
        );

        //for reset
        b2 = new JButton("Delete");
        b2.setFont(new Font("Serif", Font.BOLD, 15));
        b2.setBounds(200, 340, 100, 40);
        add(b2);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                t1.setText("");
                l4.setText("");
            }
        }
        );
    }
}
