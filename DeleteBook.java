import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteBook extends JFrame implements ActionListener {

    JLabel title, l1;

    JTextField t1;

    JButton b1;

    DeleteBook() {

        setTitle("Delete Book");

        setSize(500, 350);

        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        title = new JLabel("DELETE BOOK");

        title.setBounds(120, 40, 300, 40);

        title.setFont(
                new Font("Arial", Font.BOLD, 30));

        add(title);

        l1 = new JLabel("Book ID");

        l1.setBounds(60, 130, 120, 30);

        l1.setFont(
                new Font("Arial", Font.BOLD, 18));

        add(l1);

        t1 = new JTextField();

        t1.setBounds(200, 130, 180, 30);

        add(t1);

        b1 = new JButton("DELETE");

        b1.setBounds(160, 220, 140, 40);

        b1.setFont(
                new Font("Arial", Font.BOLD, 16));

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
                    "DELETE FROM books WHERE BOOK_ID=?");

            ps.setString(1, t1.getText());

            int rows = ps.executeUpdate();

            if(rows > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Book Deleted Successfully");

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Book Not Found");
            }

            t1.setText("");

            con.close();

        } catch(Exception ex) {

            JOptionPane.showMessageDialog(this, ex);
        }
    }
}