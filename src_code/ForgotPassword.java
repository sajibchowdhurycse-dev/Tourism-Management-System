package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.File;
import java.io.IOException;

public class ForgotPassword extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField t1, t2, t3, t4, t5;
    private JButton b1, b2, b3;

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
        EventQueue.invokeLater(() -> new ForgotPassword().setVisible(true));
    }

    public ForgotPassword() {
        setTitle("Forgot Password");
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                int w = getWidth();
                int h = getHeight();
                GradientPaint gp = new GradientPaint(0, 0, new Color(245, 245, 250), w, h, new Color(230, 238, 255));
                g2.setPaint(gp);
                g2.fillRect(0, 0, w, h);
                g2.dispose();
            }
        };
        contentPane.setBorder(new EmptyBorder(16, 16, 16, 16));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        RoundedPanel formPanel = new RoundedPanel(20, new Color(255, 255, 255, 230));
        formPanel.setBounds(40, 40, 520, 300);
        formPanel.setLayout(null);
        contentPane.add(formPanel);

        JLabel title = new JLabel("Account Recovery");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setBounds(30, 10, 300, 30);
        formPanel.add(title);

        JLabel l1 = new JLabel("Username");
        l1.setFont(new Font("Segoe UI", Font.BOLD, 13));
        l1.setBounds(30, 60, 100, 25);
        formPanel.add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setFont(new Font("Segoe UI", Font.BOLD, 13));
        l2.setBounds(30, 95, 100, 25);
        formPanel.add(l2);

        JLabel l3 = new JLabel("Your Security Question");
        l3.setFont(new Font("Segoe UI", Font.BOLD, 13));
        l3.setBounds(30, 130, 200, 25);
        formPanel.add(l3);

        JLabel l4 = new JLabel("Answer");
        l4.setFont(new Font("Segoe UI", Font.BOLD, 13));
        l4.setBounds(30, 165, 100, 25);
        formPanel.add(l4);

        JLabel l5 = new JLabel("Password");
        l5.setFont(new Font("Segoe UI", Font.BOLD, 13));
        l5.setBounds(30, 200, 100, 25);
        formPanel.add(l5);

        t1 = new JTextField();
        t1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        t1.setBounds(220, 62, 170, 26);
        formPanel.add(t1);

        t2 = new JTextField();
        t2.setEditable(false);
        t2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        t2.setBounds(220, 97, 170, 26);
        formPanel.add(t2);

        t3 = new JTextField();
        t3.setEditable(false);
        t3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        t3.setBounds(220, 132, 260, 26);
        formPanel.add(t3);

        t4 = new JTextField();
        t4.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        t4.setBounds(220, 167, 170, 26);
        formPanel.add(t4);

        t5 = new JTextField();
        t5.setEditable(false);
        t5.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        t5.setBounds(220, 202, 170, 26);
        formPanel.add(t5);

        b1 = new JButton("Search");
        b1.setFocusable(false);
        b1.setBounds(415, 62, 80, 26);
        styleButton(b1);
        b1.addActionListener(this);
        formPanel.add(b1);

        b2 = new JButton("Retrieve");
        b2.setFocusable(false);
        b2.setBounds(415, 167, 90, 26);
        styleButton(b2);
        b2.addActionListener(this);
        formPanel.add(b2);

        b3 = new JButton("Back");
        b3.setFocusable(false);
        b3.setBounds(220, 240, 100, 28);
        styleButton(b3);
        b3.addActionListener(this);
        formPanel.add(b3);

        JPanel imgPanel = new RoundedPanel(18, new Color(255, 255, 255, 200));
        imgPanel.setBounds(580, 70, 200, 200);
        imgPanel.setLayout(new BorderLayout());
        contentPane.add(imgPanel);

        try {
            Image img = ImageIO.read(new File("C:\\Users\\User\\Desktop\\file\\Sajib python\\Travel Management System\\src\\icons\\forgotpassword.jpg"));
            Image scaled = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            JLabel pic = new JLabel(new ImageIcon(scaled));
            imgPanel.add(pic, BorderLayout.CENTER);
        } catch (IOException e) {
            JLabel fallback = new JLabel("No Image");
            fallback.setHorizontalAlignment(SwingConstants.CENTER);
            imgPanel.add(fallback, BorderLayout.CENTER);
        }

        try {
            setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 25, 25));
        } catch (Throwable t) {
        }
    }

    private void styleButton(JButton b) {
        b.setBackground(new Color(45, 58, 91));
        b.setForeground(Color.WHITE);
        b.setFont(new Font("Segoe UI", Font.BOLD, 12));
        b.setBorder(BorderFactory.createEmptyBorder(6, 12, 6, 12));
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Conn con = new Conn();
            if (ae.getSource() == b1) {
                String sql = "select * from account where username=?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, t1.getText());
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("question"));
                }
            }
            if (ae.getSource() == b2) {
                String sql = "select * from account where answer=?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, t4.getText());
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    t5.setText(rs.getString("password"));
                }
            }
            if (ae.getSource() == b3) {
                this.setVisible(false);
                new Login().setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class RoundedPanel extends JPanel {
        private int radius;
        private Color backgroundColor;

        public RoundedPanel(int radius, Color bg) {
            this.radius = radius;
            this.backgroundColor = bg;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(backgroundColor);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            g2.dispose();
            super.paintComponent(g);
        }

        @Override
        public boolean isOpaque() {
            return false;
        }
    }
}