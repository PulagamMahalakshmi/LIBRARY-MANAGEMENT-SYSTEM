import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddBook extends JFrame implements ActionListener {

    JLabel title, l1, l2, l3, l4, l5;

    JTextField t1, t2, t3, t4, t5;

    JButton b1;

    AddBook() {

        setTitle("Add Book");

        setSize(600, 600);

        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        title = new JLabel("ADD BOOK");

        title.setBounds(180, 30, 300, 40);

        title.setFont(
                new Font("Arial", Font.BOLD, 30));

        add(title);

        l1 = new JLabel("Book ID");

        l1.setBounds(60, 100, 150, 30);

        l1.setFont(
                new Font("Arial", Font.BOLD, 18));

        add(l1);

        t1 = new JTextField();

        t1.setBounds(230, 100, 220, 30);

        add(t1);

        l2 = new JLabel("Category");

        l2.setBounds(60, 170, 150, 30);

        l2.setFont(
                new Font("Arial", Font.BOLD, 18));

        add(l2);

        t2 = new JTextField();

        t2.setBounds(230, 170, 220, 30);

        add(t2);

        l3 = new JLabel("Book Name");

        l3.setBounds(60, 240, 150, 30);

        l3.setFont(
                new Font("Arial", Font.BOLD, 18));

        add(l3);

        t3 = new JTextField();

        t3.setBounds(230, 240, 220, 30);

        add(t3);

        l4 = new JLabel("Author");

        l4.setBounds(60, 310, 150, 30);

        l4.setFont(
                new Font("Arial", Font.BOLD, 18));

        add(l4);

        t4 = new JTextField();

        t4.setBounds(230, 310, 220, 30);

        add(t4);

        l5 = new JLabel("Copies");

        l5.setBounds(60, 380, 150, 30);

        l5.setFont(
                new Font("Arial", Font.BOLD, 18));

        add(l5);

        t5 = new JTextField();

        t5.setBounds(230, 380, 220, 30);

        add(t5);

        b1 = new JButton("ADD BOOK");

        b1.setBounds(180, 470, 180, 40);

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
                    "INSERT INTO books VALUES(?,?,?,?,?)");

            ps.setString(1, t1.getText());

            ps.setString(2, t2.getText());

            ps.setString(3, t3.getText());

            ps.setString(4, t4.getText());

            ps.setString(5, t5.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "Book Added Successfully");

            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");

            con.close();

        } catch(Exception ex) {

            JOptionPane.showMessageDialog(this, ex);
        }
    }
}