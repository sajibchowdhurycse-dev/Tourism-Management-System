package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class ViewPackage extends JFrame {
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new ViewPackage("").setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ViewPackage(String username) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(500, 150, 850, 450);

        // Gradient-like background panel
        JPanel background = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(58, 123, 213);
                Color color2 = new Color(58, 213, 179);
                GradientPaint gp = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        background.setLayout(null);
        setContentPane(background);

        // Header
        JLabel lblHeader = new JLabel("VIEW PACKAGE DETAILS");
        lblHeader.setFont(new Font("Segoe UI Semibold", Font.BOLD, 22));
        lblHeader.setForeground(Color.WHITE);
        lblHeader.setBounds(50, 10, 400, 40);
        background.add(lblHeader);

        // Image on right
        String path = "C:\\Users\\User\\Desktop\\file\\Sajib python\\Travel Management System\\src\\icons\\hotel6.jpg";
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        JLabel la1 = new JLabel(new ImageIcon(img));
        la1.setBounds(450, 40, 350, 350);
        background.add(la1);

        // Labels and values
        Font labelFont = new Font("Segoe UI", Font.BOLD, 16);
        Font valueFont = new Font("Segoe UI", Font.PLAIN, 16);

        int y = 70;
        int spacing = 40;

        JLabel lbUser = createLabel("Username:", 35, y, labelFont, Color.WHITE);
        JLabel l1 = createLabel("", 271, y, valueFont, Color.WHITE); y += spacing;
        background.add(lbUser); background.add(l1);

        JLabel lbPackage = createLabel("Package:", 35, y, labelFont, Color.WHITE);
        JLabel l2 = createLabel("", 271, y, valueFont, Color.WHITE); y += spacing;
        background.add(lbPackage); background.add(l2);

        JLabel lbPersons = createLabel("Number of Persons:", 35, y, labelFont, Color.WHITE);
        JLabel l3 = createLabel("", 271, y, valueFont, Color.WHITE); y += spacing;
        background.add(lbPersons); background.add(l3);

        JLabel lbId = createLabel("ID:", 35, y, labelFont, Color.WHITE);
        JLabel l4 = createLabel("", 271, y, valueFont, Color.WHITE); y += spacing;
        background.add(lbId); background.add(l4);

        JLabel lbNumber = createLabel("Number:", 35, y, labelFont, Color.WHITE);
        JLabel l5 = createLabel("", 271, y, valueFont, Color.WHITE); y += spacing;
        background.add(lbNumber); background.add(l5);

        JLabel lbPhone = createLabel("Phone:", 35, y, labelFont, Color.WHITE);
        JLabel l6 = createLabel("", 271, y, valueFont, Color.WHITE); y += spacing;
        background.add(lbPhone); background.add(l6);

        JLabel lbPrice = createLabel("Price:", 35, y, labelFont, Color.WHITE);
        JLabel l7 = createLabel("", 271, y, valueFont, Color.WHITE);
        background.add(lbPrice); background.add(l7);

        // Fetch from database
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bookPackage where username = '" + username + "'");
            if (rs.next()) {
                l1.setText(rs.getString(1));
                l2.setText(rs.getString(2));
                l3.setText(rs.getString(3));
                l4.setText(rs.getString(4));
                l5.setText(rs.getString(5));
                l6.setText(rs.getString(6));
                l7.setText(rs.getString(7));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Back button
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(160, 350, 120, 30);
        btnBack.setBackground(new Color(30, 144, 255));
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnBack.addActionListener(e -> setVisible(false));
        background.add(btnBack);
    }

    private JLabel createLabel(String text, int x, int y, Font font, Color color) {
        JLabel lbl = new JLabel(text);
        lbl.setBounds(x, y, 200, 25);
        lbl.setFont(font);
        lbl.setForeground(color);
        return lbl;
    }
}
