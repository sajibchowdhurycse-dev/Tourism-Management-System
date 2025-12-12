package travel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.geom.RoundRectangle2D;
import java.sql.*;

public class Loading extends JFrame implements Runnable {

    private JPanel contentPane;
    private JProgressBar progressBar;
    Connection conn;
    String username;
    int s;
    Thread th;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Loading("").setVisible(true));
    }

    public void setUploading() {
        setVisible(false);
        th.start();
    }

    public void run() {
        try {
            for (int i = 0; i < 200; i++) {
                s = s + 1;
                int m = progressBar.getMaximum();
                int v = progressBar.getValue();
                if (v < m) {
                    progressBar.setValue(progressBar.getValue() + 1);
                } else {
                    i = 201;
                    setVisible(false);
                    new Home(username).setVisible(true);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Loading(String username) {
        this.username = username;
        th = new Thread((Runnable) this);

        setUndecorated(true);
        setSize(700, 420);
        setLocationRelativeTo(null);

        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                int w = getWidth();
                int h = getHeight();
                GradientPaint gp = new GradientPaint(0, 0, new Color(6, 82, 221), w, h, new Color(98, 208, 255));
                g2.setPaint(gp);
                g2.fillRoundRect(0, 0, w, h, 30, 30);
                g2.dispose();
            }
        };

        contentPane.setBorder(new EmptyBorder(18, 18, 18, 18));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JPanel card = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f));
                g2.setColor(new Color(255, 255, 255, 220));
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
                g2.dispose();
            }
        };

        card.setOpaque(false);
        card.setBounds(30, 30, 640, 360);
        card.setLayout(null);
        contentPane.add(card);

        JLabel title = new JLabel("Tourism Management System", SwingConstants.CENTER);
        title.setForeground(new Color(12, 58, 84));
        title.setFont(new Font("Segoe UI", Font.BOLD, 30));
        title.setBounds(20, 20, 600, 40);
        card.add(title);

        JLabel subtitle = new JLabel("Preparing your experience...", SwingConstants.CENTER);
        subtitle.setForeground(new Color(50, 95, 115));
        subtitle.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
        subtitle.setBounds(20, 62, 600, 26);
        card.add(subtitle);

        JPanel center = new JPanel();
        center.setOpaque(false);
        center.setBounds(40, 110, 560, 160);
        center.setLayout(null);
        card.add(center);

        progressBar = new JProgressBar(0, 100);
        progressBar.setBounds(30, 40, 500, 28);
        progressBar.setStringPainted(true);
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
        progressBar.setPreferredSize(new Dimension(500, 28));
        progressBar.setUI(new BasicProgressBarUI() {
            protected Color getSelectionBackground() { return Color.WHITE; }
            protected Color getSelectionForeground() { return Color.WHITE; }
        });
        center.add(progressBar);

        JLabel percent = new JLabel("0%", SwingConstants.CENTER);
        percent.setBounds(230, 75, 100, 20);
        percent.setFont(new Font("Segoe UI", Font.BOLD, 14));
        percent.setForeground(new Color(10, 70, 90));
        center.add(percent);

        progressBar.addChangeListener(e -> percent.setText(progressBar.getValue() + "%"));

        JLabel wait = new JLabel("Please wait...", SwingConstants.CENTER);
        wait.setBounds(30, 110, 500, 20);
        wait.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        wait.setForeground(new Color(80, 120, 130));
        center.add(wait);

        JLabel footer = new JLabel("© Travel & Tours", SwingConstants.RIGHT);
        footer.setBounds(20, 300, 600, 20);
        footer.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        footer.setForeground(new Color(12, 58, 84));
        card.add(footer);

        setUploading();
    }
}