package travel.management.system;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookHotel extends JFrame {
    private JPanel contentPane;
    JTextField t1, t2;
    Choice c1, c2, c3;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BookHotel frame = new BookHotel("");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BookHotel(String username) {
        setBounds(360, 120, 1100, 640);
        setUndecorated(false);
        setResizable(false);

        contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(new Color(18, 24, 30));
        contentPane.setBorder(new EmptyBorder(14, 14, 14, 14));
        setContentPane(contentPane);

        JPanel left = new JPanel(null);
        left.setPreferredSize(new Dimension(460, 0));
        left.setBackground(new Color(22, 28, 36));
        contentPane.add(left, BorderLayout.WEST);

        JLabel header = new JLabel("BOOK HOTEL");
        header.setBounds(30, 10, 420, 40);
        header.setForeground(new Color(220, 230, 240));
        header.setFont(new Font("Raleway", Font.BOLD, 24));
        left.add(header);

        JLabel la2 = new JLabel("Username :");
        la2.setBounds(30, 70, 180, 22);
        la2.setForeground(new Color(180, 200, 220));
        la2.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(la2);

        JLabel l1 = new JLabel(username);
        l1.setBounds(210, 70, 200, 22);
        l1.setForeground(new Color(210, 230, 245));
        l1.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(l1);

        JLabel lblId = new JLabel("Select Hotel :");
        lblId.setBounds(30, 110, 180, 22);
        lblId.setForeground(new Color(180, 200, 220));
        lblId.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(lblId);

        c1 = new Choice();
        Conn c = new Conn();
        try {
            ResultSet rs = c.s.executeQuery("select * from hotels");
            while (rs.next()) {
                c1.add(rs.getString("name"));
            }
            rs.close();
        } catch (SQLException e) { }
        c1.setBounds(210, 110, 220, 30);
        left.add(c1);

        JLabel la3 = new JLabel("Total Persons");
        la3.setBounds(30, 150, 180, 22);
        la3.setForeground(new Color(180, 200, 220));
        la3.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(la3);

        t1 = new JTextField();
        t1.setText("0");
        t1.setBounds(210, 150, 220, 28);
        t1.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(t1);

        JLabel la4 = new JLabel("Number of Days");
        la4.setBounds(30, 195, 180, 22);
        la4.setForeground(new Color(180, 200, 220));
        la4.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(la4);

        t2 = new JTextField();
        t2.setText("0");
        t2.setBounds(210, 195, 220, 28);
        t2.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(t2);

        JLabel la5 = new JLabel("AC / Non-AC");
        la5.setBounds(30, 240, 180, 22);
        la5.setForeground(new Color(180, 200, 220));
        la5.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(la5);

        c2 = new Choice();
        c2.add("AC");
        c2.add("Non-AC");
        c2.setBounds(210, 240, 220, 30);
        left.add(c2);

        JLabel la6 = new JLabel("Food Included :");
        la6.setBounds(30, 285, 180, 22);
        la6.setForeground(new Color(180, 200, 220));
        la6.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(la6);

        c3 = new Choice();
        c3.add("Yes");
        c3.add("No");
        c3.setBounds(210, 285, 220, 30);
        left.add(c3);

        JLabel lbl1 = new JLabel("ID :");
        lbl1.setBounds(30, 330, 180, 22);
        lbl1.setForeground(new Color(180, 200, 220));
        lbl1.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(lbl1);

        JLabel l2 = new JLabel();
        l2.setBounds(210, 330, 220, 22);
        l2.setForeground(new Color(210, 230, 245));
        l2.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(l2);

        JLabel lbl2 = new JLabel("Number :");
        lbl2.setBounds(30, 370, 180, 22);
        lbl2.setForeground(new Color(180, 200, 220));
        lbl2.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(lbl2);

        JLabel l3 = new JLabel();
        l3.setBounds(210, 370, 220, 22);
        l3.setForeground(new Color(210, 230, 245));
        l3.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(l3);

        JLabel lbl3 = new JLabel("Phone :");
        lbl3.setBounds(30, 410, 180, 22);
        lbl3.setForeground(new Color(180, 200, 220));
        lbl3.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(lbl3);

        JLabel l4 = new JLabel();
        l4.setBounds(210, 410, 220, 22);
        l4.setForeground(new Color(210, 230, 245));
        l4.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(l4);

        JLabel lblDeposite = new JLabel("Total Price :");
        lblDeposite.setBounds(30, 450, 180, 22);
        lblDeposite.setForeground(new Color(180, 200, 220));
        lblDeposite.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(lblDeposite);

        JLabel l5 = new JLabel();
        l5.setBounds(210, 450, 220, 22);
        l5.setForeground(new Color(255, 90, 90));
        l5.setFont(new Font("SansSerif", Font.BOLD, 14));
        left.add(l5);

        try {
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while (rs.next()) {
                l2.setText(rs.getString("id_type"));
                l3.setText(rs.getString("number"));
                l4.setText(rs.getString("phone"));
            }
            rs.close();
        } catch (SQLException e) { }

        JButton b1 = new JButton("Check Price");
        b1.setBounds(40, 520, 140, 36);
        b1.setBackground(new Color(0, 153, 102));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("SansSerif", Font.BOLD, 13));
        b1.setFocusPainted(false);
        left.add(b1);

        JButton btnNewButton = new JButton("Book");
        btnNewButton.setBounds(200, 520, 140, 36);
        btnNewButton.setBackground(new Color(0, 120, 215));
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnNewButton.setFocusPainted(false);
        left.add(btnNewButton);

        JButton btnExit = new JButton("Back");
        btnExit.setBounds(360, 520, 140, 36);
        btnExit.setBackground(new Color(60, 64, 72));
        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnExit.setFocusPainted(false);
        left.add(btnExit);

        JPanel right = new JPanel(null);
        right.setBackground(new Color(12, 18, 24));
        contentPane.add(right, BorderLayout.CENTER);

        ImageIcon i1 = new ImageIcon("C:\\Users\\User\\Desktop\\file\\Sajib python\\Travel Management System\\src\\icons\\book.jpg");
        Image i3 = i1.getImage().getScaledInstance(600, 520, Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(30, 40, 600, 520);
        right.add(la1);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();
                try {
                    String q1 = "select * from hotels where name = '"+c1.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(q1);
                    if (rs.next()) {
                        int cost = Integer.parseInt(rs.getString("cost_per_day"));
                        int food = Integer.parseInt(rs.getString("food_charges"));
                        int ac = Integer.parseInt(rs.getString("ac_charges"));
                        int persons = Integer.parseInt(t1.getText());
                        int days = Integer.parseInt(t2.getText());
                        String acprice = c2.getSelectedItem();
                        String foodprice = c3.getSelectedItem();
                        if (persons * days > 0) {
                            int total = 0;
                            total += acprice.equals("AC") ? ac : 1;
                            total += foodprice.equals("Yes") ? food : 1;
                            total += cost;
                            total = total * persons * days;
                            l5.setText("Rs " + total);
                        }
                    }
                    rs.close();
                } catch (Exception ee) {
                    System.out.println(ee.getMessage());
                }
            }
        });

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();
                try {
                    String q1 = "insert into bookHotel values('"+l1.getText()+"', '"+c1.getSelectedItem()+"', '"+t1.getText()+"', '"+t2.getText()+"', '"+c2.getSelectedItem()+"', '"+c3.getSelectedItem()+"', '"+l2.getText()+"', '"+l3.getText()+"', '"+l4.getText()+"', '"+l5.getText()+"')";
                    c.s.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                    setVisible(false);
                } catch (Exception ee) {
                    System.out.println(ee.getMessage());
                }
            }
        });

        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setVisible(true);
    }
}
