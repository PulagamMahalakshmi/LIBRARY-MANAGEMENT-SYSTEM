import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchBook extends JFrame implements ActionListener {

    JLabel title, l1;

    JTextField t1;

    JButton b1;

    JTextArea result;

    SearchBook() {

        setTitle("Search Book");

        setSize(700, 500);

        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        title = new JLabel("SEARCH BOOK");

        title.setBounds(200, 30, 350, 40);

        title.setFont(
                new Font("Arial", Font.BOLD, 30));

        add(title);

        l1 = new JLabel("Book ID");

        l1.setBounds(80, 120, 120, 30);

        l1.setFont(
                new Font("Arial", Font.BOLD, 18));

        add(l1);

        t1 = new JTextField();

        t1.setBounds(220, 120, 220, 30);

        add(t1);

        b1 = new JButton("SEARCH");

        b1.setBounds(250, 190, 140, 40);

        b1.setFont(
                new Font("Arial", Font.BOLD, 16));

        add(b1);

        result = new JTextArea();

        result.setBounds(50, 270, 580, 150);

        result.setFont(
                new Font("Arial", Font.BOLD, 16));

        result.setEditable(false);

        result.setLineWrap(true);

        result.setWrapStyleWord(true);

        add(result);

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
                    "SELECT * FROM books WHERE BOOK_ID=?");

            ps.setString(1, t1.getText());

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                String text =

                        "BOOK ID : " +
                        rs.getString("BOOK_ID") +

                        "\n\nCATEGORY : " +
                        rs.getString("CATEGORY") +

                        "\n\nBOOK NAME : " +
                        rs.getString("NAME") +

                        "\n\nAUTHOR : " +
                        rs.getString("AUTHOR") +

                        "\n\nCOPIES : " +
                        rs.getString("COPIES");

                result.setText(text);

            } else {

                result.setText("BOOK NOT FOUND");
            }

            con.close();

        } catch(Exception ex) {

            JOptionPane.showMessageDialog(this, ex);
        }
    }
}