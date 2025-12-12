package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Destination extends JFrame implements Runnable {

    JLabel l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
    Thread th;

    public void run() {
        try {
            JLabel[] labels = {l2, l3, l4, l5, l6, l7, l8, l9, l10, l11};

            for (JLabel label : labels) {
                label.setVisible(true);
                Thread.sleep(2800);
                label.setVisible(false);
            }

            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Destination() {

        setBounds(580, 220, 900, 700);
        getContentPane().setBackground(new Color(220, 250, 250));
        setLayout(null);

        th = new Thread(this);

              l2 = createLabel("C:\\Users\\User\\Desktop\\file\\Sajib python\\Travel Management System\\src\\icons\\dest1.jpeg");
        l3 = createLabel("C:\\Users\\User\\Desktop\\file\\Sajib python\\Travel Management System\\src\\icons\\dest9.jpg");
        l4 = createLabel("C:\\Users\\User\\Desktop\\file\\Sajib python\\Travel Management System\\src\\icons\\dest5.jpg");
        l5 = createLabel("C:\\Users\\User\\Desktop\\file\\Sajib python\\Travel Management System\\src\\icons\\DS1.jpg");
        l6 = createLabel("C:\\Users\\User\\Desktop\\file\\Sajib python\\Travel Management System\\src\\icons\\maldives.jpg");
        l7 = createLabel("C:\\Users\\User\\Desktop\\file\\Sajib python\\Travel Management System\\src\\icons\\dest1.jpg");
        l8 = createLabel("C:\\Users\\User\\Desktop\\file\\Sajib python\\Travel Management System\\src\\icons\\dest7.jpeg");
        l9 = createLabel("C:\\Users\\User\\Desktop\\file\\Sajib python\\Travel Management System\\src\\icons\\dest8.jpg");
        l10 = createLabel("C:\\Users\\User\\Desktop\\file\\Sajib python\\Travel Management System\\src\\icons\\dest10.jpg");
        l11 = createLabel("C:\\Users\\User\\Desktop\\file\\Sajib python\\Travel Management System\\src\\icons\\beach.jpg");

        th.start();
    }

    private JLabel createLabel(String path) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(img);
        JLabel label = new JLabel(scaledIcon);
        label.setBounds(0, 0, 900, 700);
        label.setVisible(false);
        add(label);
        return label;
    }

    public static void main(String[] args) {
        new Destination().setVisible(true);
    }
}
