package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateCustomer extends JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    private JPanel contentPane;
    private JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new UpdateCustomer("").setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public UpdateCustomer(String username) {
        setTitle("Update Customer Details");
        setBounds(450, 150, 900, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(245, 245, 245));
        setContentPane(contentPane);

        JLabel lblTitle = new JLabel("UPDATE CUSTOMER DETAILS");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitle.setForeground(new Color(30, 144, 255));
        lblTitle.setBounds(40, 20, 400, 40);
        contentPane.add(lblTitle);

        // Labels and TextFields
        String[] labels = {"Username:", "ID:", "Number:", "Name:", "Gender:", "Country:", "Permanent Address:", "Phone:", "Email:"};
        JTextField[] textFields = new JTextField[9];
        int y = 80;

        for (int i = 0; i < labels.length; i++) {
            JLabel lbl = new JLabel(labels[i]);
            lbl.setBounds(40, y, 200, 25);
            lbl.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            contentPane.add(lbl);

            JTextField t = new JTextField();
            t.setBounds(250, y, 200, 25);
            t.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            contentPane.add(t);

            textFields[i] = t;
            y += 40;
        }

        t1 = textFields[0];
        t2 = textFields[1];
        t3 = textFields[2];
        t4 = textFields[3];
        t5 = textFields[4];
        t6 = textFields[5];
        t7 = textFields[6];
        t8 = textFields[7];
        t9 = textFields[8];

        // Image on the right
        ImageIcon icon = new ImageIcon("C:\\Users\\User\\Desktop\\file\\Sajib python\\Travel Management System\\src\\icons\\updata.jpg");
        Image img = icon.getImage().getScaledInstance(250, 450, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(img));
        imageLabel.setBounds(500, 50, 250, 450);
        contentPane.add(imageLabel);

        // Load data from DB
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username='" + username + "'");
            if (rs.next()) {
                t1.setText(rs.getString(1));
                t2.setText(rs.getString(2));
                t3.setText(rs.getString(3));
                t4.setText(rs.getString(4));
                t5.setText(rs.getString(5));
                t6.setText(rs.getString(6));
                t7.setText(rs.getString(7));
                t8.setText(rs.getString(8));
                t9.setText(rs.getString(9));
            }
        } catch (Exception e) {}

        // Update Button
        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(120, 450, 140, 40);
        btnUpdate.setBackground(new Color(30, 144, 255));
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnUpdate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(e -> updateCustomer());
        contentPane.add(btnUpdate);

        // Back Button
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(300, 450, 140, 40);
        btnBack.setBackground(new Color(220, 20, 60));
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBack.addActionListener(e -> setVisible(false));
        contentPane.add(btnBack);
    }

    private void updateCustomer() {
        try {
            Conn c = new Conn();
            String q = "update customer set id_type='" + t2.getText() + "', number='" + t3.getText() + "', name='" + t4.getText() +
                    "', gender='" + t5.getText() + "', country='" + t6.getText() + "', address='" + t7.getText() +
                    "', phone='" + t8.getText() + "', email='" + t9.getText() + "' where username='" + t1.getText() + "'";
            c.s.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Customer Detail Updated Successfully");
            setVisible(false);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}
