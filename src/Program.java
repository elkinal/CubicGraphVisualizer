import javax.swing.*;

/**
 * Created by alxye on 29-Jun-18.
 */
public class Program {
    public static int screenHeight = 1000;
    public static int screenWidth = 1000;
    public static double scale = 1;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
//        frame.setUndecorated(true);
        frame.setTitle("Application");
        frame.add(new Content());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(screenWidth,screenHeight);
        frame.setVisible(true);


    }
}
