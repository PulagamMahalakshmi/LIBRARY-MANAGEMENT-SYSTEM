import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewIssuedBooks extends JFrame {

    JTable table;

    JScrollPane sp;

    ViewIssuedBooks() {

        setTitle("View Issued Books");

        setSize(900, 500);

        setLayout(new BorderLayout());

        String columns[] = {

                "STUDENT ID",
                "STUDENT NAME",
                "BOOK ID",
                "BOOK NAME"
        };

        DefaultTableModel model =
                new DefaultTableModel(columns, 0);

        table = new JTable(model);

        table.setRowHeight(25);

        table.setFont(
                new Font("Arial", Font.PLAIN, 14));

        table.getTableHeader().setFont(
                new Font("Arial", Font.BOLD, 15));

        sp = new JScrollPane(table);

        add(sp);

        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library",
                    "root",
                    "maha");

            Statement st = con.createStatement();

            ResultSet rs =
                    st.executeQuery(
                    "SELECT * FROM issue_book");

            while(rs.next()) {

                String sid =
                        rs.getString("STUDENT_ID");

                String sname =
                        rs.getString("STUDENT_NAME");

                String bid =
                        rs.getString("BOOK_ID");

                String bname =
                        rs.getString("BOOK_NAME");

                model.addRow(new Object[] {

                        sid,
                        sname,
                        bid,
                        bname
                });
            }

            con.close();

        } catch(Exception ex) {

            JOptionPane.showMessageDialog(this, ex);
        }

        setLocationRelativeTo(null);

        setVisible(true);
    }
}