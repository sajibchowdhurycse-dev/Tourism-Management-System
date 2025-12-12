package travel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    private JTextField textField;
    private JPasswordField passwordField;
    private RoundedButton b1, b2, b3;

    public Login() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        setTitle("Tourism_management_system :  Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(760, 460);
        setResizable(false);
        setLocationRelativeTo(null);

        BackgroundPanel root = new BackgroundPanel();
        root.setLayout(null);
        setContentPane(root);

        GlassCard card = new GlassCard();
        card.setBounds(70, 40, 620, 360);
        card.setLayout(null);
        root.add(card);

        JLabel title = new JLabel("Welcome Back");
        title.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 26));
        title.setForeground(new Color(18, 50, 75));
        title.setBounds(40, 30, 300, 36);
        card.add(title);

        JLabel subtitle = new JLabel("Sign in to continue to your Travel Dashboard");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitle.setForeground(new Color(90, 110, 125));
        subtitle.setBounds(40, 66, 380, 20);
        card.add(subtitle);

        JLabel userLbl = new JLabel("Username");
        userLbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
        userLbl.setForeground(new Color(40, 60, 80));
        userLbl.setBounds(40, 110, 100, 24);
        card.add(userLbl);

        textField = new JTextField();
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        textField.setBounds(150, 112, 300, 30);
        new GhostText(textField, "e.g. sajib123");
        card.add(textField);

        JLabel passLbl = new JLabel("Password");
        passLbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
        passLbl.setForeground(new Color(40, 60, 80));
        passLbl.setBounds(40, 155, 100, 24);
        card.add(passLbl);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        passwordField.setBounds(150, 157, 300, 30);
        new GhostText(passwordField, "Enter your password");
        card.add(passwordField);

        ImageIcon icon = null;
        try {
            icon = new ImageIcon("C:\\Users\\User\\Desktop\\file\\Sajib python\\Travel Management System\\src\\icons\\login.png");
        } catch (Exception e) {}
        JLabel imgLabel;
        if (icon != null && icon.getIconWidth() > 0) {
            Image img = icon.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
            imgLabel = new JLabel(new ImageIcon(img));
        } else {
            imgLabel = new JLabel("Image");
            imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
            imgLabel.setFont(new Font("Segoe UI", Font.ITALIC, 14));
            imgLabel.setForeground(new Color(150, 150, 150));
        }
        imgLabel.setBounds(470, 80, 140, 140);
        card.add(imgLabel);

        b1 = new RoundedButton("Login");
        b1.setBounds(150, 210, 130, 38);
        b1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        b1.setBackground(new Color(34, 139, 34));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        card.add(b1);

        b2 = new RoundedButton("SignUp");
        b2.setBounds(320, 210, 130, 38);
        b2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        b2.setBackground(new Color(48, 102, 180));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        card.add(b2);

        b3 = new RoundedButton("Forgot Password");
        b3.setBounds(200, 262, 200, 34);
        b3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        b3.setBackground(new Color(250, 245, 240));
        b3.setForeground(new Color(160, 50, 50));
        b3.addActionListener(this);
        card.add(b3);

        JLabel trouble = new JLabel("Trouble signing in?");
        trouble.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        trouble.setForeground(new Color(170, 50, 50));
        trouble.setBounds(40, 268, 150, 24);
        card.add(trouble);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                Conn con = new Conn();
                String sql = "select * from account where username=? and password=?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, textField.getText());
                st.setString(2, new String(passwordField.getPassword()));
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    this.setVisible(false);
                    new Loading(textField.getText()).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login or Password!");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (ae.getSource() == b2) {
            setVisible(false);
            Signup su = new Signup();
            su.setVisible(true);
        } else if (ae.getSource() == b3) {
            setVisible(false);
            ForgotPassword forgot = new ForgotPassword();
            forgot.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }

    class RoundedButton extends JButton {
        private int radius = 12;
        private Color base;
        public RoundedButton(String text) {
            super(text);
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
            base = getBackground();
            addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                    setBackground(brighten(base, 0.08f));
                }
                public void mouseExited(MouseEvent e) {
                    setBackground(base);
                }
                public void mousePressed(MouseEvent e) {
                    setBackground(darken(base, 0.06f));
                }
                public void mouseReleased(MouseEvent e) {
                    setBackground(base);
                }
            });
        }
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            g2.setColor(getForeground());
            FontMetrics fm = g2.getFontMetrics();
            Rectangle r = new Rectangle(0, 0, getWidth(), getHeight());
            int x = (r.width - fm.stringWidth(getText())) / 2;
            int y = (r.height - fm.getHeight()) / 2 + fm.getAscent();
            g2.setFont(getFont());
            g2.drawString(getText(), x, y);
            g2.dispose();
        }
        private Color brighten(Color c, float factor) {
            int r = c.getRed(), g = c.getGreen(), b = c.getBlue();
            r += (int)((255 - r) * factor);
            g += (int)((255 - g) * factor);
            b += (int)((255 - b) * factor);
            return new Color(Math.min(r,255), Math.min(g,255), Math.min(b,255));
        }
        private Color darken(Color c, float factor) {
            int r = (int)(c.getRed() * (1 - factor));
            int g = (int)(c.getGreen() * (1 - factor));
            int b = (int)(c.getBlue() * (1 - factor));
            return new Color(Math.max(r,0), Math.max(g,0), Math.max(b,0));
        }
    }

    class GlassCard extends JPanel {
        public GlassCard() {
            setOpaque(false);
        }
        protected void paintComponent(Graphics g) {
            int arc = 20;
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int w = getWidth(), h = getHeight();
            g2.setColor(new Color(255,255,255,230));
            g2.fillRoundRect(0, 0, w, h, arc, arc);
            g2.setColor(new Color(200,210,220,120));
            g2.setStroke(new BasicStroke(1.5f));
            g2.drawRoundRect(1, 1, w-3, h-3, arc, arc);
            g2.dispose();
            super.paintComponent(g);
        }
    }

    class BackgroundPanel extends JPanel {
        public BackgroundPanel() {
            setOpaque(true);
        }
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            int w = getWidth(), h = getHeight();
            GradientPaint gp = new GradientPaint(0, 0, new Color(235,245,255), 0, h, new Color(220,235,245));
            g2.setPaint(gp);
            g2.fillRect(0, 0, w, h);
            g2.setColor(new Color(255,255,255,40));
            g2.fillOval(w-260, -80, 360, 360);
            g2.fillOval(-140, h-200, 360, 360);
            g2.dispose();
        }
    }

    class GhostText implements FocusListener {
        private final JTextComponent comp;
        private final String ghost;
        private boolean showing;
        private char originalEcho;

        public GhostText(JTextComponent comp, String ghost) {
            this.comp = comp;
            this.ghost = ghost;
            if (comp instanceof JPasswordField) {
                originalEcho = ((JPasswordField) comp).getEchoChar();
            } else {
                originalEcho = (char) 0;
            }
            comp.addFocusListener(this);
            showIfNeeded();
        }
        public void focusGained(FocusEvent e) {
            if (showing) {
                comp.setText("");
                comp.setForeground(Color.BLACK);
                showing = false;
                if (comp instanceof JPasswordField) {
                    ((JPasswordField) comp).setEchoChar(originalEcho == (char)0 ? '•' : originalEcho);
                }
            }
        }
        public void focusLost(FocusEvent e) {
            showIfNeeded();
        }
        private void showIfNeeded() {
            if (comp.getText().isEmpty()) {
                comp.setText(ghost);
                comp.setForeground(new Color(140,140,140));
                showing = true;
                if (comp instanceof JPasswordField) {
                    ((JPasswordField) comp).setEchoChar((char)0);
                }
            } else {
                showing = false;
            }
        }
    }
}
