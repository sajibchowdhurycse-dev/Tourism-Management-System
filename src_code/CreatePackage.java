package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class CreatePackage extends JFrame implements ActionListener {

    private JPanel panel;
    private JLabel header, lblPid, lblPname, lblDate, lblCost;
    private JTextField tfPid, tfPname, tfDate, tfCost;
    private JButton btnBack, btnLogout, btnSave;

    public CreatePackage() {
        setTitle("Create Package");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        panel = new JPanel();
        panel.setBackground(new Color(34, 40, 49));
        panel.setLayout(null);
        setContentPane(panel);

        header = new JLabel("Create Package");
        header.setFont(new Font("Raleway", Font.BOLD, 28));
        header.setForeground(new Color(255, 153, 51));
        header.setBounds(140, 20, 300, 40);
        panel.add(header);

        lblPid = new JLabel("Package ID:");
        lblPid.setForeground(Color.WHITE);
        lblPid.setFont(new Font("SansSerif", Font.PLAIN, 16));
        lblPid.setBounds(50, 80, 120, 25);
        panel.add(lblPid);

        tfPid = new JTextField();
        tfPid.setBounds(180, 80, 220, 28);
        tfPid.setFont(new Font("SansSerif", Font.PLAIN, 14));
        panel.add(tfPid);

        lblPname = new JLabel("Package Name:");
        lblPname.setForeground(Color.WHITE);
        lblPname.setFont(new Font("SansSerif", Font.PLAIN, 16));
        lblPname.setBounds(50, 120, 120, 25);
        panel.add(lblPname);

        tfPname = new JTextField();
        tfPname.setBounds(180, 120, 220, 28);
        tfPname.setFont(new Font("SansSerif", Font.PLAIN, 14));
        panel.add(tfPname);

        lblDate = new JLabel("Date:");
        lblDate.setForeground(Color.WHITE);
        lblDate.setFont(new Font("SansSerif", Font.PLAIN, 16));
        lblDate.setBounds(50, 160, 120, 25);
        panel.add(lblDate);

        tfDate = new JTextField();
        tfDate.setBounds(180, 160, 220, 28);
        tfDate.setFont(new Font("SansSerif", Font.PLAIN, 14));
        panel.add(tfDate);

        lblCost = new JLabel("Cost:");
        lblCost.setForeground(Color.WHITE);
        lblCost.setFont(new Font("SansSerif", Font.PLAIN, 16));
        lblCost.setBounds(50, 200, 120, 25);
        panel.add(lblCost);

        tfCost = new JTextField();
        tfCost.setBounds(180, 200, 220, 28);
        tfCost.setFont(new Font("SansSerif", Font.PLAIN, 14));
        panel.add(tfCost);

        btnSave = new JButton("Save");
        btnSave.setBounds(180, 250, 120, 40);
        btnSave.setBackground(new Color(0, 153, 102));
        btnSave.setForeground(Color.WHITE);
        btnSave.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnSave.setFocusPainted(false);
        btnSave.addActionListener(this);
        panel.add(btnSave);

        btnBack = new JButton("Main Menu");
        btnBack.setBounds(50, 310, 130, 40);
        btnBack.setBackground(new Color(51, 51, 51));
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnBack.setFocusPainted(false);
        btnBack.addActionListener(this);
        panel.add(btnBack);

        btnLogout = new JButton("Log Out");
        btnLogout.setBounds(300, 310, 130, 40);
        btnLogout.setBackground(new Color(204, 0, 0));
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnLogout.setFocusPainted(false);
        btnLogout.addActionListener(this);
        panel.add(btnLogout);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd.equals("Save")) {
            savePackage();
            JOptionPane.showMessageDialog(this, "New Package Saved");
        } else if(cmd.equals("Log Out")) {
            new Login().setVisible(true);
            this.setVisible(false);
        } else if(cmd.equals("Main Menu")) {
            this.setVisible(false);
        }
    }

    private void savePackage() {
        String query = "INSERT INTO `package` VALUES('"+tfPid.getText()+"','"+tfPname.getText()+"','"+tfDate.getText()+"','"+tfCost.getText()+"')";
        Connection con = null;
        Statement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
            st = con.createStatement();
            st.execute(query);
        } catch(Exception e) {
            System.out.println(e);
        } finally {
            try {
                if(con != null) con.close();
                if(st != null) st.close();
            } catch(Exception e) { System.out.println(e); }
        }
    }

    public static void main(String[] args) {
        new CreatePackage().setVisible(true);
    }
}
