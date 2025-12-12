package travel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;

public class ViewCustomers extends JFrame {
    private JPanel contentPane;
    private JTable table;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new ViewCustomers().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ViewCustomers() throws SQLException {
        setTitle("Tourism Management System - View Customers");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(350, 100, 1000, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setBackground(new Color(245, 245, 245));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel header = new JLabel("CUSTOMER DETAILS");
        header.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
        header.setForeground(new Color(30, 144, 255));
        header.setBounds(20, 10, 400, 40);
        contentPane.add(header);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 70, 950, 350);
        scrollPane.getViewport().setBackground(Color.WHITE);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setRowHeight(30);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setFillsViewportHeight(true);
        table.setGridColor(new Color(200, 200, 200));
        table.setBackground(Color.WHITE);

        // Table header style
        JTableHeader headerTable = table.getTableHeader();
        headerTable.setBackground(new Color(30, 144, 255));
        headerTable.setForeground(Color.WHITE);
        headerTable.setFont(new Font("Segoe UI", Font.BOLD, 16));
        headerTable.setPreferredSize(new Dimension(headerTable.getWidth(), 35));

        scrollPane.setViewportView(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(430, 450, 120, 35);
        btnBack.setBackground(new Color(30, 144, 255));
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnBack.addActionListener(e -> setVisible(false));
        contentPane.add(btnBack);

        // Decorative images at bottom
        String path = "C:\\Users\\User\\Desktop\\file\\Sajib python\\Travel Management System\\src\\icons\\logo.jpg";

        ImageIcon i1 = new ImageIcon(path);
        Image img1 = i1.getImage().getScaledInstance(450, 150, Image.SCALE_SMOOTH);
        JLabel l1 = new JLabel(new ImageIcon(img1));
        l1.setBounds(20, 520, 450, 150);
        contentPane.add(l1);

        ImageIcon i2 = new ImageIcon(path);
        Image img2 = i2.getImage().getScaledInstance(450, 150, Image.SCALE_SMOOTH);
        JLabel l2 = new JLabel(new ImageIcon(img2));
        l2.setBounds(520, 520, 450, 150);
        contentPane.add(l2);
    }
}
