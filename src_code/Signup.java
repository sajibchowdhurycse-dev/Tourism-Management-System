package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.io.File;
import java.net.URL;

public class Signup extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JButton b1, b2;
    private JComboBox comboBox;

    private static final String FALLBACK_FILE_PATH =
        "C:\\Users\\User\\Desktop\\file\\Sajib python\\Travel Management System\\src\\icons\\signup.png";

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Signup frame = new Signup();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Signup() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        setTitle(" Tourism_Management_System : SignUp");
        setBounds(600, 250, 700, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                int w = getWidth();
                int h = getHeight();
                GradientPaint gp = new GradientPaint(0, 0, new Color(230, 240, 255),
                                                     0, h, new Color(200, 220, 240));
                g2.setPaint(gp);
                g2.fillRect(0, 0, w, h);
            }
        };
        contentPane.setBorder(new EmptyBorder(8, 8, 8, 8));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel header = new JLabel("Create Your Account");
        header.setHorizontalAlignment(SwingConstants.LEFT);
        header.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
        header.setForeground(new Color(20, 60, 90));
        header.setBounds(40, 20, 360, 34);
        contentPane.add(header);

        JLabel lblUsername = new JLabel("Username :");
        lblUsername.setForeground(new Color(45, 65, 85));
        lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblUsername.setBounds(99, 86, 110, 26);
        contentPane.add(lblUsername);

        JLabel lblName = new JLabel("Name :");
        lblName.setForeground(new Color(45, 65, 85));
        lblName.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblName.setBounds(99, 123, 110, 26);
        contentPane.add(lblName);

        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setForeground(new Color(45, 65, 85));
        lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblPassword.setBounds(99, 160, 110, 26);
        contentPane.add(lblPassword);

        JLabel lblSecurityQuestion = new JLabel("Security Question :");
        lblSecurityQuestion.setForeground(new Color(45, 65, 85));
        lblSecurityQuestion.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblSecurityQuestion.setBounds(99, 197, 160, 26);
        contentPane.add(lblSecurityQuestion);

        JLabel lblAnswer = new JLabel("Answer :");
        lblAnswer.setForeground(new Color(45, 65, 85));
        lblAnswer.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblAnswer.setBounds(99, 234, 92, 26);
        contentPane.add(lblAnswer);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {
            "Your NickName?", "Your Lucky Number?",
            "Your child SuperHero?", "Your childhood Name ?"
        }));
        comboBox.setBounds(265, 202, 210, 24);
        comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        contentPane.add(comboBox);

        ImageIcon c1 = null;
        URL imgURL = Signup.class.getResource("/travel/management/system/icons/signup.png");
        if (imgURL != null) {
            c1 = new ImageIcon(imgURL);
        } else {
            File f = new File(FALLBACK_FILE_PATH);
            if (f.exists()) {
                c1 = new ImageIcon(f.getAbsolutePath());
            }
        }

        JLabel l6;
        if (c1 != null && c1.getIconWidth() > 0) {
            Image i1 = c1.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
            Image blur = new ImageIcon(i1).getImage();
            l6 = new JLabel(new ImageIcon(blur));
        } else {
            l6 = new JLabel("Image not found");
            l6.setHorizontalAlignment(SwingConstants.CENTER);
            l6.setFont(new Font("Segoe UI", Font.ITALIC, 12));
            l6.setForeground(new Color(140, 140, 140));
        }
        l6.setBounds(430, 60, 250, 250);
        contentPane.add(l6);

        textField = new JTextField();
        textField.setBounds(265, 91, 210, 24);
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        contentPane.add(textField);

        textField_1 = new JTextField();
        textField_1.setBounds(265, 128, 210, 24);
        textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        contentPane.add(textField_1);

        textField_2 = new JPasswordField();
        textField_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        textField_2.setBounds(265, 165, 210, 24);
        contentPane.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setBounds(265, 239, 210, 24);
        textField_3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        contentPane.add(textField_3);

        b1 = new JButton("Create");
        b1.addActionListener(this);
        b1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
        b1.setBounds(140, 289, 110, 36);
        b1.setBackground(new Color(34, 139, 34));
        b1.setForeground(Color.WHITE);
        b1.setFocusPainted(false);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
        b2.setBounds(300, 289, 110, 36);
        b2.setBackground(new Color(80, 120, 180));
        b2.setForeground(Color.WHITE);
        b2.setFocusPainted(false);
        contentPane.add(b2);

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2),
                "Create Account", TitledBorder.LEADING, TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 14),
                new Color(34, 139, 34)));
        panel.setBounds(31, 60, 640, 310);
        panel.setLayout(null);
        contentPane.add(panel);

        header.setVisible(true);
        panel.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Conn con = new Conn();

            if (ae.getSource() == b1) {
                String sql = "insert into account(username, name, password, question, answer) values(?, ?, ?, ?, ?)";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, textField_1.getText());
                st.setString(3, textField_2.getText());
                st.setString(4, (String) comboBox.getSelectedItem());
                st.setString(5, textField_3.getText());

                int i = st.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Account Created Successfully");
                }

                textField.setText("");
                textField_1.setText("");
                textField_2.setText("");
                textField_3.setText("");
            }
            if (ae.getSource() == b2) {
                this.setVisible(false);
                new Login().setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
