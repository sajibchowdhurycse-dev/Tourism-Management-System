package travel.management.system;

import java.awt.*;
import javax.swing.*;

public class Splash {
    public static void main(String[] args) {
        new SplashFrame().setVisible(true);
    }
}
class SplashFrame extends JFrame implements Runnable {

    Thread t1;
   private static final String IMAGE_PATH =
        "C:\\Users\\User\\Desktop\\file\\Sajib python\\Travel Management System\\src\\icons\\view.jpg";
    SplashFrame() {
        setLayout(new BorderLayout());
               ImageIcon rawIcon = new ImageIcon(IMAGE_PATH);
        if (rawIcon.getIconWidth() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Image NOT FOUND!\nCheck path:\n" + IMAGE_PATH);        }

        Image img = rawIcon.getImage().getScaledInstance(1030, 750, Image.SCALE_SMOOTH);
        ImageIcon scaled = new ImageIcon(img);

        JLabel l1 = new JLabel(scaled);
        add(l1, BorderLayout.CENTER);

        setUndecorated(true);
        setSize(600, 400);
        setLocationRelativeTo(null);

        t1 = new Thread(this);
        t1.start();

              new Thread(() -> {
            int x = 1;
            for (int i = 2; i <= 600; i += 10, x += 7) {
                setLocation(900 - ((i + x) / 2), 500 - (i / 2));
                setSize(i + x, i);
                try { Thread.sleep(10); } catch (Exception ignored) {}
            }
        }).start();
    }

    public void run() {
        try {
            Thread.sleep(7000);
            setVisible(false);
            new Login().setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}