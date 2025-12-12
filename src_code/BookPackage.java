package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class BookPackage extends JFrame {
    private JPanel contentPane;
    JTextField t1;
    Choice c1;

    public static void main(String[] args) {
        new BookPackage("").setVisible(true);
    }

    public BookPackage(String username) {
        setBounds(360, 150, 1100, 450);
        setResizable(false);

        contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(new Color(18, 24, 30));
        setContentPane(contentPane);

        JPanel left = new JPanel(null);
        left.setPreferredSize(new Dimension(460, 0));
        left.setBackground(new Color(22, 28, 36));
        contentPane.add(left, BorderLayout.WEST);

        JLabel header = new JLabel("BOOK PACKAGE");
        header.setBounds(30, 10, 400, 35);
        header.setForeground(new Color(220, 230, 240));
        header.setFont(new Font("Raleway", Font.BOLD, 24));
        left.add(header);

        JLabel la2 = new JLabel("Username :");
        la2.setBounds(30, 60, 150, 22);
        la2.setForeground(new Color(180, 200, 220));
        la2.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(la2);

        JLabel l1 = new JLabel(username);
        l1.setBounds(210, 60, 200, 22);
        l1.setForeground(new Color(210, 230, 245));
        l1.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(l1);

        JLabel lblId = new JLabel("Select Package :");
        lblId.setBounds(30, 100, 150, 22);
        lblId.setForeground(new Color(180, 200, 220));
        lblId.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(lblId);

        c1 = new Choice();
        c1.add("Gold Package");
        c1.add("Silver Package");
        c1.add("Bronze Package");
        c1.setBounds(210, 100, 220, 30);
        left.add(c1);

        JLabel la3 = new JLabel("Total Persons");
        la3.setBounds(30, 140, 150, 22);
        la3.setForeground(new Color(180, 200, 220));
        la3.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(la3);

        t1 = new JTextField("0");
        t1.setBounds(210, 140, 220, 28);
        t1.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(t1);

        JLabel lbl1 = new JLabel("ID :");
        lbl1.setBounds(30, 180, 150, 22);
        lbl1.setForeground(new Color(180, 200, 220));
        lbl1.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(lbl1);

        JLabel l2 = new JLabel();
        l2.setBounds(210, 180, 220, 22);
        l2.setForeground(new Color(210, 230, 245));
        left.add(l2);

        JLabel lbl2 = new JLabel("Number :");
        lbl2.setBounds(30, 220, 150, 22);
        lbl2.setForeground(new Color(180, 200, 220));
        left.add(lbl2);

        JLabel l3 = new JLabel();
        l3.setBounds(210, 220, 220, 22);
        l3.setForeground(new Color(210, 230, 245));
        left.add(l3);

        JLabel lbl3 = new JLabel("Phone :");
        lbl3.setBounds(30, 260, 150, 22);
        lbl3.setForeground(new Color(180, 200, 220));
        left.add(lbl3);

        JLabel l4 = new JLabel();
        l4.setBounds(210, 260, 220, 22);
        l4.setForeground(new Color(210, 230, 245));
        left.add(l4);

        JLabel lblDeposite = new JLabel("Total Price :");
        lblDeposite.setBounds(30, 300, 150, 22);
        lblDeposite.setForeground(new Color(180, 200, 220));
        left.add(lblDeposite);

        JLabel l5 = new JLabel();
        l5.setBounds(210, 300, 220, 22);
        l5.setForeground(new Color(255, 90, 90));
        l5.setFont(new Font("SansSerif", Font.BOLD, 14));
        left.add(l5);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while(rs.next()){
                l2.setText(rs.getString("id_type"));
                l3.setText(rs.getString("number"));
                l4.setText(rs.getString("phone"));
            }
            rs.close();
        } catch(SQLException e) { }

        JButton b1 = new JButton("Check Price");
        b1.setBounds(30, 340, 140, 36);
        b1.setBackground(new Color(0, 153, 102));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("SansSerif", Font.BOLD, 13));
        b1.setFocusPainted(false);
        left.add(b1);

        JButton btnBook = new JButton("Book");
        btnBook.setBounds(190, 340, 140, 36);
        btnBook.setBackground(new Color(0, 120, 215));
        btnBook.setForeground(Color.WHITE);
        btnBook.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnBook.setFocusPainted(false);
        left.add(btnBook);

        JButton btnExit = new JButton("Back");
        btnExit.setBounds(350, 340, 140, 36);
        btnExit.setBackground(new Color(60, 64, 72));
        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnExit.setFocusPainted(false);
        left.add(btnExit);

        JPanel right = new JPanel(null);
        right.setBackground(new Color(12, 18, 24));
        contentPane.add(right, BorderLayout.CENTER);

        try {
            BufferedImage img = ImageIO.read(new File("C:\\Users\\User\\Desktop\\file\\Sajib python\\Travel Management System\\src\\icons\\package1.jpg"));
            Image scaled = img.getScaledInstance(600, 380, Image.SCALE_SMOOTH);
            JLabel la1 = new JLabel(new ImageIcon(scaled));
            la1.setBounds(30, 30, 600, 380);
            right.add(la1);
        } catch (IOException e) {
            System.out.println("Image not found!");
        }

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String p = c1.getSelectedItem();
                int cost = 0;
                if(p.equals("Gold Package")) cost = 12000;
                else if(p.equals("Silver Package")) cost = 25000;
                else if(p.equals("Bronze Package")) cost = 32000;
                cost *= Integer.parseInt(t1.getText());
                l5.setText("Rs "+cost);
            }
        });

        btnBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn c = new Conn();
                    String q1 = "insert into bookPackage values('"+username+"', '"+c1.getSelectedItem()+"', '"+t1.getText()+"', '"+l2.getText()+"', '"+l3.getText()+"', '"+l4.getText()+"', '"+l5.getText()+"')";
                    c.s.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                    setVisible(false);
                } catch(Exception ee){
                    System.out.println(ee.getMessage());
                }
            }
        });

        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
