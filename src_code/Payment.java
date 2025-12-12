package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Payment extends JFrame {

    public Payment() {

        setTitle("Payment");
        setLayout(null);
        setBounds(400, 100, 900, 600);
        getContentPane().setBackground(new Color(245, 245, 245));

        JLabel title = new JLabel("Payment");
        title.setFont(new Font("Segoe UI", Font.BOLD, 42));
        title.setForeground(new Color(30, 144, 255));
        title.setBounds(50, 20, 400, 50);
        add(title);

        String imagePath = "C:\\Users\\User\\Desktop\\file\\Sajib python\\Travel Management System\\src\\icons\\py2.jpg";
        ImageIcon i7 = new ImageIcon(imagePath);
        Image i8 = i7.getImage().getScaledInstance(850, 400, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(i8));
        imageLabel.setBounds(25, 100, 850, 400);
        add(imageLabel);

        JButton pay = new JButton("Pay");
        pay.setBounds(500, 20, 130, 45);
        pay.setBackground(new Color(30, 144, 255));
        pay.setForeground(Color.WHITE);
        pay.setFont(new Font("Segoe UI", Font.BOLD, 16));
        pay.setFocusPainted(false);
        pay.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pay.addActionListener(e -> JOptionPane.showMessageDialog(null, "Payment Successful"));
        add(pay);

        JButton back = new JButton("Back");
        back.setBounds(650, 20, 100, 45);
        back.setBackground(new Color(220, 20, 60));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Segoe UI", Font.BOLD, 16));
        back.setFocusPainted(false);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addActionListener(e -> setVisible(false));
        add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Payment().setVisible(true);
    }
}
