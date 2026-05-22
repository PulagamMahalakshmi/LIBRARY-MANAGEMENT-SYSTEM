import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginPage extends JFrame implements ActionListener {

    JLabel l1, l2, title;

    JTextField t1;

    JPasswordField p1;

    JButton b1;

    LoginPage() {

        setTitle("Library Login");

        setSize(500, 400);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.WHITE);

        title = new JLabel("LOGIN PAGE");

        title.setBounds(120, 30, 300, 40);

        title.setFont(new Font("Arial", Font.BOLD, 28));

        l1 = new JLabel("USER ID");

        l1.setBounds(80, 120, 120, 30);

        l1.setFont(new Font("Arial", Font.BOLD, 18));

        t1 = new JTextField();

        t1.setBounds(200, 120, 180, 30);

        l2 = new JLabel("PASSWORD");

        l2.setBounds(80, 190, 120, 30);

        l2.setFont(new Font("Arial", Font.BOLD, 18));

        p1 = new JPasswordField();

        p1.setBounds(200, 190, 180, 30);

        b1 = new JButton("LOGIN");

        b1.setBounds(170, 270, 120, 40);

        b1.setFont(new Font("Arial", Font.BOLD, 14));

        b1.addActionListener(this);

        add(title);
        add(l1);
        add(t1);
        add(l2);
        add(p1);
        add(b1);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library",
                    "root",
                    "maha");

            String username = t1.getText();

            String password =
                    String.valueOf(p1.getPassword());

            PreparedStatement ps =
                    con.prepareStatement(
                    "SELECT * FROM admin WHERE USER_ID=? AND PASSWORD=?");

            ps.setString(1, username);

            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                String name = rs.getString("NAME");

                JOptionPane.showMessageDialog(
                        this,
                        "Welcome " + name);

                new Dashboard();

                dispose();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid USER ID or PASSWORD");
            }

            con.close();

        } catch(Exception ex) {

            JOptionPane.showMessageDialog(this, ex);
        }
    }

    public static void main(String[] args) {

        new LoginPage();
    }
}