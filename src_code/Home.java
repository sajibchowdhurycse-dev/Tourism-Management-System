package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame{
    String username;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Home("").setVisible(true));
    }

    public Home(String username) {
        super("Tourism Management System");
        this.username = username;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int screenW = (int) screen.getWidth();
        int screenH = (int) screen.getHeight();

        String imagePath = "C:/Users/User/Desktop/file/Sajib python/Travel Management System/src/icons/display.jpg";
        ImageIcon original = new ImageIcon(imagePath);
        Image scaled = original.getImage().getScaledInstance(screenW, screenH, Image.SCALE_SMOOTH);
        ImageIcon bgIcon = new ImageIcon(scaled);

        JLabel background = new JLabel(bgIcon);
        background.setBounds(0, 0, screenW, screenH);
        background.setLayout(null);
        add(background);

        // Top overlay with title/subtitle
        JPanel topOverlay = new JPanel();
        topOverlay.setBounds(0, 0, screenW, 140);
        topOverlay.setBackground(new Color(8, 35, 63, 160)); // deep navy translucent
        topOverlay.setLayout(null);
        background.add(topOverlay);

        JLabel title = new JLabel(" Tourism Management System");
        title.setForeground(new Color(255, 245, 238)); // off-white
        title.setFont(new Font("Segoe UI", Font.BOLD, 56));
        title.setBounds(50, 18, screenW - 300, 60);
        topOverlay.add(title);

        JLabel subtitle = new JLabel("Plan. Book. Explore. — online tourism management made simple");
        subtitle.setForeground(new Color(220, 230, 240));
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        subtitle.setBounds(52, 78, 1000, 40);
        topOverlay.add(subtitle);

        if (username != null && username.trim().length() > 0) {
            JLabel welcome = new JLabel("Welcome, " + username);
            welcome.setForeground(new Color(255, 245, 238));
            welcome.setFont(new Font("Segoe UI", Font.ITALIC, 20));
            welcome.setBounds(screenW - 320, 30, 280, 40);
            topOverlay.add(welcome);
        }

        int leftW = 360;
        int leftX = 30;
        int leftY = 180;
        int leftH = screenH - 220;

        JPanel leftCard = new JPanel();
        leftCard.setLayout(new BorderLayout());
        leftCard.setBackground(new Color(255,255,255,230));
        leftCard.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200,200,200), 1),
                BorderFactory.createEmptyBorder(16,16,16,16)));
        leftCard.setBounds(leftX, leftY, leftW, leftH);
        leftCard.setLayout(new BorderLayout());
        background.add(leftCard);

        JLabel cardTitle = new JLabel("FUNCTIONS");
        cardTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        cardTitle.setForeground(new Color(12, 60, 110));
        cardTitle.setBorder(BorderFactory.createEmptyBorder(4,4,12,4));
        leftCard.add(cardTitle, BorderLayout.NORTH);

        JPanel items = new JPanel();
        items.setOpaque(false);
        items.setLayout(new GridLayout(0, 1, 10, 10)); 

        Font itemFont = new Font("Segoe UI", Font.BOLD, 18);
        Dimension btnPref = new Dimension(leftW - 48, 54);

        // CUSTOMER
        JButton bAddCustomer = new JButton("ADD CUSTOMER");
        styleButton(bAddCustomer, itemFont, btnPref, new Color(6, 60, 110));
        bAddCustomer.addActionListener(ae -> { try{ new AddCustomer(username).setVisible(true);}catch(Exception e){} });
        items.add(bAddCustomer);

        JButton bUpdateCustomer = new JButton("UPDATE CUSTOMER DETAIL");
        styleButton(bUpdateCustomer, itemFont, btnPref, new Color(6, 60, 110));
        bUpdateCustomer.addActionListener(ae -> { try{ new UpdateCustomer(username).setVisible(true);}catch(Exception e){} });
        items.add(bUpdateCustomer);

        JButton bViewCustomers = new JButton("VIEW CUSTOMER DETAILS");
        styleButton(bViewCustomers, itemFont, btnPref, new Color(6, 60, 110));
        bViewCustomers.addActionListener(ae -> { try{ new ViewCustomers().setVisible(true);}catch(Exception e){} });
        items.add(bViewCustomers);

        JButton bDeleteCustomer = new JButton("DELETE CUSTOMER DETAILS");
        styleButton(bDeleteCustomer, itemFont, btnPref, new Color(180, 40, 40));
        bDeleteCustomer.addActionListener(ae -> { try{ new DeleteCustomer().setVisible(true);}catch(Exception e){} });
        items.add(bDeleteCustomer);

        // PACKAGES
        JButton bCheckPackage = new JButton("CHECK PACKAGE");
        styleButton(bCheckPackage, itemFont, btnPref, new Color(160, 40, 60));
        bCheckPackage.addActionListener(ae -> { try{ new CheckPackage().setVisible(true);}catch(Exception e){} });
        items.add(bCheckPackage);

        JButton bBookPackage = new JButton("BOOK PACKAGE");
        styleButton(bBookPackage, itemFont, btnPref, new Color(160, 40, 60));
        bBookPackage.addActionListener(ae -> { try{ new BookPackage(username).setVisible(true);}catch(Exception e){} });
        items.add(bBookPackage);

        JButton bViewPackage = new JButton("VIEW PACKAGE");
        styleButton(bViewPackage, itemFont, btnPref, new Color(160, 40, 60));
        bViewPackage.addActionListener(ae -> { try{ new ViewPackage(username).setVisible(true);}catch(Exception e){} });
        items.add(bViewPackage);

        // HOTELS
        JButton bBookHotel = new JButton("BOOK HOTELS");
        styleButton(bBookHotel, itemFont, btnPref, new Color(6, 90, 140));
        bBookHotel.addActionListener(ae -> { try{ new BookHotel(username).setVisible(true);}catch(Exception e){} });
        items.add(bBookHotel);

        JButton bViewHotels = new JButton("VIEW HOTELS");
        styleButton(bViewHotels, itemFont, btnPref, new Color(6, 90, 140));
        bViewHotels.addActionListener(ae -> { try{ new CheckHotels().setVisible(true);}catch(Exception e){} });
        items.add(bViewHotels);

        JButton bViewBookedHotel = new JButton("VIEW BOOKED HOTEL");
        styleButton(bViewBookedHotel, itemFont, btnPref, new Color(6, 90, 140));
        bViewBookedHotel.addActionListener(ae -> { try{ new ViewBookedHotel(username).setVisible(true);}catch(Exception e){} });
        items.add(bViewBookedHotel);

        // DESTINATION
        JButton bDestination = new JButton("DESTINATION");
        styleButton(bDestination, itemFont, btnPref, new Color(140, 50, 30));
        bDestination.addActionListener(ae -> { try{ new Destination().setVisible(true);}catch(Exception e){} });
        items.add(bDestination);

        // PAYMENT
        JButton bPayment = new JButton("PAYMENT");
        styleButton(bPayment, itemFont, btnPref, new Color(10, 110, 70));
        bPayment.addActionListener(ae -> { try{ new Payment().setVisible(true);}catch(Exception e){} });
        items.add(bPayment);

        // UTILITY
        JButton bNotepad = new JButton("NOTEPAD");
        styleButton(bNotepad, itemFont, btnPref, new Color(90,90,90));
        bNotepad.addActionListener(ae -> { try{ Runtime.getRuntime().exec("notepad.exe");}catch(Exception e){} });
        items.add(bNotepad);

        JButton bCalculator = new JButton("CALCULATOR");
        styleButton(bCalculator, itemFont, btnPref, new Color(90,90,90));
        bCalculator.addActionListener(ae -> { try{ Runtime.getRuntime().exec("calc.exe");}catch(Exception e){} });
        items.add(bCalculator);

        // ABOUT
        JButton bAbout = new JButton("ABOUT");
        styleButton(bAbout, itemFont, btnPref, new Color(12, 60, 110));
        bAbout.addActionListener(ae -> { try{ new About().setVisible(true);}catch(Exception e){} });
        items.add(bAbout);

        JScrollPane sp = new JScrollPane(items);
        sp.setBorder(BorderFactory.createEmptyBorder());
        sp.setOpaque(false);
        sp.getViewport().setOpaque(false);
        leftCard.add(sp, BorderLayout.CENTER);

        // Right-side panel: quick cards for visual balance
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setOpaque(false);
        rightPanel.setBounds(screenW - 380, 180, 340, 560);
        background.add(rightPanel);

        JPanel statsCard = createCard("Quick Overview", 340, 180);
        statsCard.setBounds(0, 0, 340, 180);
        rightPanel.add(statsCard);

        JPanel notifCard = createCard("Notifications", 340, 140);
        notifCard.setBounds(0, 200, 340, 140);
        rightPanel.add(notifCard);

        JPanel helpCard = createCard("Support", 340, 180);
        helpCard.setBounds(0, 360, 340, 180);
        rightPanel.add(helpCard);

        getContentPane().setBackground(new Color(245,245,245));
    }

    // Helper to style buttons consistently
    private void styleButton(JButton b, Font f, Dimension pref, Color fg) {
        b.setFont(f);
        b.setPreferredSize(pref);
        b.setFocusPainted(false);
        b.setForeground(fg);
        b.setBackground(new Color(255,255,255));
        b.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220,220,220)),
                BorderFactory.createEmptyBorder(8,12,8,12)));
        b.setHorizontalAlignment(SwingConstants.LEFT);
    }

    // Simple small card factory used on the right
    private JPanel createCard(String title, int w, int h) {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.setBackground(new Color(255,255,255,230));
        p.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200,200,200), 1),
                BorderFactory.createEmptyBorder(12,12,12,12)));

        JLabel t = new JLabel(title);
        t.setFont(new Font("Segoe UI", Font.BOLD, 18));
        t.setForeground(new Color(12, 60, 110));
        p.add(t, BorderLayout.NORTH);

        JLabel body = new JLabel(" ");
        body.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        body.setBorder(BorderFactory.createEmptyBorder(8,0,0,0));
        p.add(body, BorderLayout.CENTER);

        p.setPreferredSize(new Dimension(w, h));
        return p;
    }
}
