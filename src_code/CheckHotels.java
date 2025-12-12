package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckHotels extends JFrame implements Runnable {

    JLabel[] hotels = new JLabel[10];
    JLabel caption;
    Thread th;

    String[] hotelNames = {
        "JW Marriott Hotel",
        "Mandarin Oriental Hotel",
        "Four Seasons Hotel",
        "Radisson Hotel",
        "Classio Hotel",
        "The Bay Club Hotel",
        "Breeze Blows Hotel",
        "Quick Stop Hotel",
        "Happy Mornings Motel",
        "Moss View Hotel"
    };

    public void run() {
        try {
            for (int i = 0; i < hotels.length; i++) {
                hotels[i].setVisible(true);
                caption.setText(hotelNames[i]);
                hotels[i].add(caption);
                Thread.sleep(2800);
                hotels[i].setVisible(false);
            }
            this.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CheckHotels() {
        setBounds(580, 220, 900, 700);
        getContentPane().setBackground(new Color(220, 250, 250));
        setLayout(null);

        caption = new JLabel();
        caption.setBounds(50, 550, 1000, 70);
        caption.setForeground(Color.WHITE);
        caption.setFont(new Font("Tahoma", Font.PLAIN, 40));
        add(caption);

        th = new Thread(this);

        // Load hotel images using absolute paths
        for (int i = 0; i < hotels.length; i++) {
            try {
                String path = "C:\\Users\\User\\Desktop\\file\\Sajib python\\Travel Management System\\src\\icons\\hotel" + (i+1) + ".jpg";
                ImageIcon img = new ImageIcon(path);
                Image scaled = img.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
                ImageIcon finalImg = new ImageIcon(scaled);
                hotels[i] = new JLabel(finalImg);
                hotels[i].setBounds(0, 0, 900, 700);
                add(hotels[i]);
                hotels[i].setVisible(false);
            } catch (Exception e) {
                System.out.println("Image not found: hotel" + (i+1));
                e.printStackTrace();
            }
        }

        th.start();
    }

    public static void main(String[] args) {
        new CheckHotels().setVisible(true);
    }
}
