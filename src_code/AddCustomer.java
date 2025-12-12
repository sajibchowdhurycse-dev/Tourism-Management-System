package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;

public class AddCustomer extends JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    private JPanel contentPane;
    private JTextField t1, t2, t3, t5, t6, t7, t8;
    private JComboBox<String> comboBox;
    private JRadioButton r1, r2;
    private ButtonGroup genderGroup;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                AddCustomer frame = new AddCustomer("");
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public AddCustomer(String username) throws SQLException {
        setBounds(520, 150, 900, 600);
        setUndecorated(false);
        setResizable(false);

        contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(new Color(18, 24, 30));
        contentPane.setBorder(new EmptyBorder(14, 14, 14, 14));
        setContentPane(contentPane);

        JPanel left = new JPanel();
        left.setPreferredSize(new Dimension(480, 0));
        left.setBackground(new Color(22, 28, 36));
        left.setLayout(null);
        contentPane.add(left, BorderLayout.WEST);

        JLabel header = new JLabel("NEW CUSTOMER FORM");
        header.setBounds(30, 10, 420, 40);
        header.setForeground(new Color(200, 220, 240));
        header.setFont(new Font("Raleway", Font.BOLD, 22));
        left.add(header);

        JLabel l3 = new JLabel("Username :");
        l3.setBounds(30, 70, 180, 22);
        l3.setForeground(new Color(180, 200, 220));
        l3.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(l3);

        t7 = new JTextField();
        t7.setBounds(210, 70, 220, 28);
        t7.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(t7);

        JLabel lblId = new JLabel("ID :");
        lblId.setBounds(30, 115, 180, 22);
        lblId.setForeground(new Color(180, 200, 220));
        lblId.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(lblId);

        comboBox = new JComboBox<>(new String[] { "Passport", "Aadhar Card", "Voter Id", "Driving license" });
        comboBox.setBounds(210, 115, 220, 28);
        comboBox.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(comboBox);

        JLabel l2 = new JLabel("Number :");
        l2.setBounds(30, 160, 180, 22);
        l2.setForeground(new Color(180, 200, 220));
        l2.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(l2);

        t1 = new JTextField();
        t1.setBounds(210, 160, 220, 28);
        t1.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(t1);

        JLabel lblName_1 = new JLabel("Name :");
        lblName_1.setBounds(30, 205, 180, 22);
        lblName_1.setForeground(new Color(180, 200, 220));
        lblName_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(lblName_1);

        t2 = new JTextField();
        t2.setBounds(210, 205, 220, 28);
        t2.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(t2);

        JLabel lblGender = new JLabel("Gender :");
        lblGender.setBounds(30, 250, 180, 22);
        lblGender.setForeground(new Color(180, 200, 220));
        lblGender.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(lblGender);

        r1 = new JRadioButton("Male");
        r1.setBounds(210, 250, 90, 26);
        r1.setBackground(new Color(22, 28, 36));
        r1.setForeground(new Color(200, 220, 240));
        r1.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(310, 250, 120, 26);
        r2.setBackground(new Color(22, 28, 36));
        r2.setForeground(new Color(200, 220, 240));
        r2.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(r2);

        genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);

        JLabel lblCountry = new JLabel("Country :");
        lblCountry.setBounds(30, 295, 180, 22);
        lblCountry.setForeground(new Color(180, 200, 220));
        lblCountry.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(lblCountry);

        t3 = new JTextField();
        t3.setBounds(210, 295, 220, 28);
        t3.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(t3);

        JLabel lblReserveRoomNumber = new JLabel("Permanent Address :");
        lblReserveRoomNumber.setBounds(30, 340, 180, 22);
        lblReserveRoomNumber.setForeground(new Color(180, 200, 220));
        lblReserveRoomNumber.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(lblReserveRoomNumber);

        t5 = new JTextField();
        t5.setBounds(210, 340, 220, 28);
        t5.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(t5);

        JLabel lblCheckInStatus = new JLabel("Phone :");
        lblCheckInStatus.setBounds(30, 385, 180, 22);
        lblCheckInStatus.setForeground(new Color(180, 200, 220));
        lblCheckInStatus.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(lblCheckInStatus);

        t6 = new JTextField();
        t6.setBounds(210, 385, 220, 28);
        t6.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(t6);

        JLabel lblDeposite = new JLabel("Email :");
        lblDeposite.setBounds(30, 430, 180, 22);
        lblDeposite.setForeground(new Color(180, 200, 220));
        lblDeposite.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(lblDeposite);

        t8 = new JTextField();
        t8.setBounds(210, 430, 220, 28);
        t8.setFont(new Font("SansSerif", Font.PLAIN, 14));
        left.add(t8);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.setBounds(70, 490, 140, 36);
        btnNewButton.setBackground(new Color(0, 153, 102));
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnNewButton.setFocusPainted(false);
        left.add(btnNewButton);

        JButton btnExit = new JButton("Back");
        btnExit.setBounds(260, 490, 140, 36);
        btnExit.setBackground(new Color(40, 44, 52));
        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnExit.setFocusPainted(false);
        left.add(btnExit);

        JPanel right = new JPanel(null);
        right.setBackground(new Color(12, 18, 24));
        contentPane.add(right, BorderLayout.CENTER);

        ImageIcon i1 = new ImageIcon("C:/Users/User/Desktop/file/Sajib python/Travel Management System/src/icons/newcustomer.jpg");
        Image i3 = i1.getImage().getScaledInstance(360, 480, Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(40, 40, 360, 480);
        right.add(l1);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from account where username = '" + username + "'");
            while (rs.next()) {
                t7.setText(rs.getString("username"));
                t2.setText(rs.getString("name"));
            }
        } catch (Exception e) { }

        btnNewButton.addActionListener(e -> {
            Conn c = new Conn();
            String radio = null;
            if (r1.isSelected()) radio = "Male";
            else if (r2.isSelected()) radio = "Female";
            try {
                String s9 = t7.getText();
                String s1 = (String) comboBox.getSelectedItem();
                String s2 = t1.getText();
                String s3 = t2.getText();
                String s4 = radio;
                String s5 = t3.getText();
                String s7 = t5.getText();
                String s8 = t6.getText();
                String s10 = t8.getText();
                String q1 = "insert into customer values('" + s9 + "','" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s7 + "','" + s8 + "','" + s10 + "')";
                c.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Customer Added Successfully");
                setVisible(false);
            } catch (SQLException e1) {
                System.out.println(e1.getMessage());
            } catch (NumberFormatException s) {
                JOptionPane.showMessageDialog(null, "Please enter a valid Number");
            }
        });

        btnExit.addActionListener(e -> setVisible(false));

        setVisible(true);
    }
}
