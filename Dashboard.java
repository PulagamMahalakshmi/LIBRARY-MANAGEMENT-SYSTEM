import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    JLabel title;

    JButton b1, b2, b3, b4, b5, b6, b7, b8;

    Dashboard() {

        setTitle("Library Management System");

        setSize(1000, 650);

        setLayout(null);

        getContentPane().setBackground(
                new Color(240, 248, 255));

        title = new JLabel(
                "LIBRARY MANAGEMENT SYSTEM");

        title.setBounds(180, 30, 700, 50);

        title.setFont(
                new Font("Arial", Font.BOLD, 36));

        title.setForeground(new Color(25, 25, 112));

        add(title);

        Font btnFont =
                new Font("Arial", Font.BOLD, 18);

        b1 = new JButton("ADD BOOK");

        b1.setBounds(120, 140, 250, 70);

        b1.setFont(btnFont);

        add(b1);

        b2 = new JButton("VIEW BOOKS");

        b2.setBounds(600, 140, 250, 70);

        b2.setFont(btnFont);

        add(b2);

        b3 = new JButton("ISSUE BOOK");

        b3.setBounds(120, 260, 250, 70);

        b3.setFont(btnFont);

        add(b3);

        b4 = new JButton("RETURN BOOK");

        b4.setBounds(600, 260, 250, 70);

        b4.setFont(btnFont);

        add(b4);

        b5 = new JButton("LOGOUT");

        b5.setBounds(360, 500, 250, 70);

        b5.setFont(btnFont);

        add(b5);

        b6 = new JButton("SEARCH BOOK");

        b6.setBounds(120, 380, 250, 70);

        b6.setFont(btnFont);

        add(b6);

        b7 = new JButton("DELETE BOOK");

        b7.setBounds(600, 380, 250, 70);

        b7.setFont(btnFont);

        add(b7);

        b8 = new JButton("VIEW ISSUED");

        b8.setBounds(360, 440, 250, 50);

        b8.setFont(
                new Font("Arial", Font.BOLD, 16));

        add(b8);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b1) {

            new AddBook();
        }

        if(e.getSource() == b2) {

            new ViewBooks();
        }

        if(e.getSource() == b3) {

            new IssueBook();
        }

        if(e.getSource() == b4) {

            new ReturnBook();
        }

        if(e.getSource() == b5) {

            dispose();

            new LoginPage();
        }

        if(e.getSource() == b6) {

            new SearchBook();
        }

        if(e.getSource() == b7) {

            new DeleteBook();
        }

        if(e.getSource() == b8) {

            new ViewIssuedBooks();
        }
    }
}