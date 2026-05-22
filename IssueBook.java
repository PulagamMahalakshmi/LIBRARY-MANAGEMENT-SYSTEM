import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class IssueBook extends JFrame implements ActionListener {

    JLabel title, l1, l2, l3, l4;

    JTextField t1, t2, t3, t4;

    JButton b1;

    IssueBook() {

        setTitle("Issue Book");

        setSize(550, 500);

        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        title = new JLabel("ISSUE BOOK");

        title.setBounds(150, 30, 300, 40);

        title.setFont(
                new Font("Arial", Font.BOLD, 30));

        add(title);

        l1 = new JLabel("Student ID");

        l1.setBounds(50, 120, 150, 30);

        l1.setFont(
                new Font("Arial", Font.BOLD, 18));

        add(l1);

        t1 = new JTextField();

        t1.setBounds(220, 120, 220, 30);

        add(t1);

        l2 = new JLabel("Student Name");

        l2.setBounds(50, 190, 150, 30);

        l2.setFont(
                new Font("Arial", Font.BOLD, 18));

        add(l2);

        t2 = new JTextField();

        t2.setBounds(220, 190, 220, 30);

        add(t2);

        l3 = new JLabel("Book ID");

        l3.setBounds(50, 260, 150, 30);

        l3.setFont(
                new Font("Arial", Font.BOLD, 18));

        add(l3);

        t3 = new JTextField();

        t3.setBounds(220, 260, 220, 30);

        add(t3);

        l4 = new JLabel("Book Name");

        l4.setBounds(50, 330, 150, 30);

        l4.setFont(
                new Font("Arial", Font.BOLD, 18));

        add(l4);

        t4 = new JTextField();

        t4.setBounds(220, 330, 220, 30);

        add(t4);

        b1 = new JButton("ISSUE");

        b1.setBounds(180, 400, 150, 40);

        add(b1);

        b1.addActionListener(this);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library",
                    "root",
                    "maha");

            PreparedStatement ps =
                    con.prepareStatement(
                    "INSERT INTO issue_book VALUES(?,?,?,?)");

            ps.setString(1, t1.getText());

            ps.setString(2, t2.getText());

            ps.setString(3, t3.getText());

            ps.setString(4, t4.getText());

            ps.executeUpdate();

            PreparedStatement ps2 =
                    con.prepareStatement(
                    "UPDATE books SET COPIES = COPIES - 1 WHERE BOOK_ID=?");

            ps2.setString(1, t3.getText());

            ps2.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "Book Issued Successfully");

            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");

            con.close();

        } catch(Exception ex) {

            JOptionPane.showMessageDialog(this, ex);
        }
    }
}