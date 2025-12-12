package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class About extends JFrame implements ActionListener {

    JButton b1;
    JLabel titleLabel;
    JTextArea textArea;
    String s;

    public About() {

        setTitle("About Project");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(560, 460);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(new Color(28, 36, 46));
        root.setBorder(new EmptyBorder(18, 18, 18, 18));
        setContentPane(root);

        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);

        titleLabel = new JLabel("Tourism Management System", SwingConstants.CENTER);
        Font headerFont = new Font("Raleway", Font.BOLD, 22);
        if (!isFontAvailable("Raleway")) headerFont = new Font("SansSerif", Font.BOLD, 22);
        titleLabel.setFont(headerFont);
        titleLabel.setForeground(new Color(230, 240, 250));
        header.add(titleLabel, BorderLayout.CENTER);

        JLabel badge = new JLabel("About Project");
        badge.setFont(new Font("SansSerif", Font.BOLD, 12));
        badge.setForeground(new Color(180, 200, 220));
        badge.setBorder(new EmptyBorder(6, 10, 6, 10));
        badge.setOpaque(true);
        badge.setBackground(new Color(41, 54, 72));
        badge.setHorizontalAlignment(SwingConstants.CENTER);
        badge.setPreferredSize(new Dimension(120, 28));
        header.add(badge, BorderLayout.WEST);

        root.add(header, BorderLayout.NORTH);

        s = "                                    About Projects          \n  "
                + "\nThe objective of the Tourism Management System"
                + " To build u a system that gives information identifying specific places. "
                + "and activities of a travel and the purpose is to design a "
                + "system using which one can perform all operations related to "
                + "traveling.\n\n"
                + "This application will help in accessing the information related "
                + "to the travel to the particular destination with great ease. "
                + "The users can track the information related to their tours with "
                + "great ease through this application. The travel agency information "
                + "can also be obtained through this application.\n\n"
                + "Advantages of Project:"
                + "\nGives accurate information"
                + "\nSimplifies the manual work"
                + "\nIt minimizes the documentation related work"
                + "\nProvides up to date information"
                + "\nFriendly Environment by providing warning messages."
                + "\ntravelers details can be provided"
                + "\nbooking confirmation notification";

        textArea = new JTextArea(s);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        Font bodyFont = new Font("Raleway", Font.PLAIN, 14);
        if (!isFontAvailable("Raleway")) bodyFont = new Font("SansSerif", Font.PLAIN, 14);
        textArea.setFont(bodyFont);
        textArea.setForeground(new Color(220, 230, 240));
        textArea.setBackground(new Color(16, 22, 30));
        textArea.setBorder(new EmptyBorder(12, 12, 12, 12));

        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.getVerticalScrollBar().setUnitIncrement(12);

        JPanel centerCard = new JPanel(new BorderLayout());
        centerCard.setBackground(new Color(20, 28, 36));
        centerCard.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(50, 65, 85), 1, true),
                new EmptyBorder(10, 10, 10, 10)));
        centerCard.add(scroll, BorderLayout.CENTER);

        root.add(centerCard, BorderLayout.CENTER);

        JPanel footer = new JPanel();
        footer.setOpaque(false);

        b1 = new JButton("Exit");
        b1.setPreferredSize(new Dimension(110, 34));
        b1.setFocusPainted(false);
        b1.addActionListener(this);
        b1.setForeground(new Color(18, 20, 22));
        b1.setBackground(new Color(120, 215, 145));
        b1.setBorder(BorderFactory.createEmptyBorder(6, 12, 6, 12));
        footer.add(b1);

        root.add(footer, BorderLayout.SOUTH);

        getRootPane().setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));

        setVisible(true);
    }

    private boolean isFontAvailable(String name) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = ge.getAvailableFontFamilyNames();
        for (String f : fonts) if (f.equalsIgnoreCase(name)) return true;
        return false;
    }

    public void actionPerformed(ActionEvent e) {
        dispose();
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new About().setVisible(true));
    }
}
