import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewBooks extends JFrame {

    JTable table;

    JScrollPane sp;

    ViewBooks() {

        setTitle("View Books");

        setSize(1000, 500);

        setLayout(new BorderLayout());

        String columns[] = {
                "BOOK ID",
                "CATEGORY",
                "NAME",
                "AUTHOR",
                "COPIES"
        };

        DefaultTableModel model =
                new DefaultTableModel(columns, 0);

        table = new JTable(model);

        table.setRowHeight(25);

        table.setFont(new Font("Arial", Font.PLAIN, 14));

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
                    st.executeQuery("SELECT * FROM books");

            while(rs.next()) {

                String id =
                        rs.getString("BOOK_ID");

                String category =
                        rs.getString("CATEGORY");

                String name =
                        rs.getString("NAME");

                String author =
                        rs.getString("AUTHOR");

                String copies =
                        rs.getString("COPIES");

                model.addRow(new Object[]{

                        id,
                        category,
                        name,
                        author,
                        copies
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