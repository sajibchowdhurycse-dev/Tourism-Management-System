package travel.management.system;

import java.awt.*;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class ViewBookedHotel extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ViewBookedHotel frame = new ViewBookedHotel("");
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ViewBookedHotel(String username) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(550, 200, 900, 620);

        // ===== Modern Gradient Background Panel =====
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(30, 60, 114),
                        0, getHeight(), new Color(42, 82, 152)
                );
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // ===== White Card Panel for Details =====
        JPanel card = new JPanel();
        card.setBounds(30, 40, 400, 510);
        card.setBackground(Color.WHITE);
        card.setLayout(null);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1, true),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        contentPane.add(card);

        // ===== Section Title =====
        JLabel lblName = new JLabel("VIEW BOOKED HOTEL DETAILS");
        lblName.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblName.setForeground(new Color(40, 40, 40));
        lblName.setBounds(45, 10, 310, 30);
        card.add(lblName);

      
        String[] labels = {
                "Username :", "Name :", "Number of Persons :", "Number of Days :",
                "AC / Non-AC :", "Food Included (Yes/No) :", "ID :",
                "Number :", "Phone :", "Cost :"
        };

        JLabel[] dataLabels = new JLabel[10];

        int y = 60;
        for (int i = 0; i < labels.length; i++) {

            JLabel lbl = new JLabel(labels[i]);
            lbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            lbl.setBounds(20, y, 200, 25);
            card.add(lbl);

            dataLabels[i] = new JLabel();
            dataLabels[i].setFont(new Font("Segoe UI", Font.BOLD, 14));
            dataLabels[i].setForeground(new Color(30, 60, 114));
            dataLabels[i].setBounds(220, y, 250, 25);
            card.add(dataLabels[i]);

            y += 35;
        }

        // ===== Right Side Image =====
        String path = "C:\\Users\\User\\Desktop\\file\\Sajib python\\Travel Management System\\src\\icons\\bookedDetails.jpg";
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage().getScaledInstance(380, 380, Image.SCALE_SMOOTH);

        JLabel la1 = new JLabel(new ImageIcon(img));
        la1.setBounds(450, 100, 400, 380);
        contentPane.add(la1);

        // ===== Back Button =====
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(150, 480, 120, 35);
        btnBack.setBackground(new Color(30, 60, 114));
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnBack.setFocusPainted(false);
        btnBack.addActionListener(e -> setVisible(false));
        card.add(btnBack);

       
        Conn c = new Conn();
        try {
            ResultSet rs = c.s.executeQuery("select * from bookHotel where username = '" + username + "'");
            int i = 0;
            while (rs.next()) {
                for (int col = 1; col <= 10; col++) {
                    dataLabels[col - 1].setText(rs.getString(col));
                }
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

