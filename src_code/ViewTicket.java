package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewTicket extends JFrame implements ActionListener {

    private JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9;
    private JButton bFirst, bNext, bPrev, bLast, bCancel;

    public ViewTicket() {
        setTitle("Travel Management System - View Tickets");
        setBounds(400, 50, 450, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Gradient background panel
        JPanel background = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(58, 123, 213); // blue shade
                Color color2 = new Color(58, 213, 179); // turquoise shade
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        background.setLayout(null);
        setContentPane(background);

        JLabel header = new JLabel("VIEW TICKET DETAILS");
        header.setFont(new Font("Segoe UI Semibold", Font.BOLD, 22));
        header.setForeground(Color.WHITE);
        header.setBounds(80, 10, 300, 40);
        background.add(header);

        Font labelFont = new Font("Segoe UI", Font.BOLD, 14);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 14);

        int y = 70;
        int spacing = 45;

        background.add(createLabel("Customer ID:", 50, y, labelFont));
        t1 = createField(220, y, fieldFont); y += spacing;
        background.add(t1);

        background.add(createLabel("Customer Name:", 50, y, labelFont));
        t2 = createField(220, y, fieldFont); y += spacing;
        background.add(t2);

        background.add(createLabel("Destination:", 50, y, labelFont));
        t3 = createField(220, y, fieldFont); y += spacing;
        background.add(t3);

        background.add(createLabel("Flight Name:", 50, y, labelFont));
        t4 = createField(220, y, fieldFont); y += spacing;
        background.add(t4);

        background.add(createLabel("Price:", 50, y, labelFont));
        t5 = createField(220, y, fieldFont); y += spacing;
        background.add(t5);

        background.add(createLabel("Number of Persons:", 50, y, labelFont));
        t6 = createField(220, y, fieldFont); y += spacing;
        background.add(t6);

        background.add(createLabel("From Date:", 50, y, labelFont));
        t7 = createField(220, y, fieldFont); y += spacing;
        background.add(t7);

        background.add(createLabel("To Date:", 50, y, labelFont));
        t8 = createField(220, y, fieldFont); y += spacing;
        background.add(t8);

        background.add(createLabel("Total Price:", 50, y, labelFont));
        t9 = createField(220, y, fieldFont); y += spacing;
        background.add(t9);

        // Buttons
        bFirst = createButton("First", 50, y, background);
        bNext = createButton("Next", 220, y, background); y += spacing;
        bPrev = createButton("Previous", 50, y, background);
        bLast = createButton("Last", 220, y, background); y += spacing;
        bCancel = createButton("Cancel", 140, y, background);

        // Add action listeners
        bFirst.addActionListener(this);
        bNext.addActionListener(this);
        bPrev.addActionListener(this);
        bLast.addActionListener(this);
        bCancel.addActionListener(this);

        setVisible(true);
    }

    private JLabel createLabel(String text, int x, int y, Font font) {
        JLabel lbl = new JLabel(text);
        lbl.setBounds(x, y, 150, 30);
        lbl.setFont(font);
        lbl.setForeground(Color.WHITE);
        return lbl;
    }

    private JTextField createField(int x, int y, Font font) {
        JTextField tf = new JTextField();
        tf.setBounds(x, y, 150, 30);
        tf.setFont(font);
        tf.setBackground(new Color(255, 255, 255, 220));
        tf.setBorder(BorderFactory.createLineBorder(new Color(30, 144, 255), 2));
        return tf;
    }

    private JButton createButton(String text, int x, int y, JPanel panel) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, 100, 30);
        btn.setBackground(new Color(30, 144, 255));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panel.add(btn);
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String cmd = ae.getActionCommand();
        if (cmd.equals("Cancel")) {
            setVisible(false);
        }
        // Add functionality for First, Next, Previous, Last buttons here
    }

    public static void main(String[] args) {
        new ViewTicket();
    }
}
