import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ReturnBook extends JFrame implements ActionListener {

    JLabel title, l1, l2;

    JTextField t1, t2;

    JButton b1;

    ReturnBook() {

        setTitle("Return Book");

        setSize(500, 400);

        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        title = new JLabel("RETURN BOOK");

        title.setBounds(120, 40, 300, 40);

        title.setFont(
                new Font("Arial", Font.BOLD, 30));

        add(title);

        l1 = new JLabel("Student ID");

        l1.setBounds(50, 130, 150, 30);

        l1.setFont(
                new Font("Arial", Font.BOLD, 18));

        add(l1);

        t1 = new JTextField();

        t1.setBounds(220, 130, 180, 30);

        add(t1);

        l2 = new JLabel("Book ID");

        l2.setBounds(50, 210, 150, 30);

        l2.setFont(
                new Font("Arial", Font.BOLD, 18));

        add(l2);

        t2 = new JTextField();

        t2.setBounds(220, 210, 180, 30);

        add(t2);

        b1 = new JButton("RETURN");

        b1.setBounds(160, 290, 140, 40);

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
                    "DELETE FROM issue_book WHERE STUDENT_ID=? AND BOOK_ID=?");

            ps.setString(1, t1.getText());

            ps.setString(2, t2.getText());

            int rows = ps.executeUpdate();

            if(rows > 0) {

                PreparedStatement ps2 =
                        con.prepareStatement(
                        "UPDATE books SET COPIES = COPIES + 1 WHERE BOOK_ID=?");

                ps2.setString(1, t2.getText());

                ps2.executeUpdate();

                JOptionPane.showMessageDialog(
                        this,
                        "Book Returned Successfully");

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Record Not Found");
            }

            t1.setText("");

            t2.setText("");

            con.close();

        } catch(Exception ex) {

            JOptionPane.showMessageDialog(this, ex);
        }
    }
}