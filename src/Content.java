import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by alxye on 29-Jun-18.
 */
public class Content extends JPanel implements ActionListener {
    private Timer t;
    private int range = 200;
    private int originalSize = 20;
    private double offset;
    private double gridSize;
    public Content() {
        t = new Timer(5, this);
        t.start();
        super.setDoubleBuffered(true);
//        addKeyListener(this);
        this.addMouseWheelListener(e -> {
            Program.scale += ((double)e.getUnitsToScroll()) / 200;
            //updating changing values
            gridSize = Program.scale * range * originalSize;
            offset = Program.screenHeight * 0.5 - (gridSize*0.5);
            repaint();
        });
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

//        g.drawRect(0, 0, 100, 100);
        graphics2D.setColor(new Color(255, 204, 0));
        for (int i = 0; i < range+1; i++) {
            for (int j = 0; j < range+1; j++) {
//                graphics2D.drawRect((int)(offset + Program.scale * originalSize * i), (int)(offset + Program.scale * originalSize * j), (int)(Program.scale * originalSize), (int)(Program.scale * originalSize));
                if(i % 25 == 0) {
                    graphics2D.setStroke(new BasicStroke(2));
                    graphics2D.setColor(new Color(179, 143, 0));
            }
                else if(i % 5 == 0) {
                    graphics2D.setStroke(new BasicStroke(2));
                    graphics2D.setColor(new Color(230, 184, 0));
                }
                else {
                    graphics2D.setStroke(new BasicStroke(1));
                    graphics2D.setColor(new Color(255, 204, 0));
                }
                //horizontal lines
                graphics2D.drawLine(0, (int)(offset + i * Program.scale * originalSize), 1000, (int)(offset + i * Program.scale * originalSize));
                //vertical lines
                graphics2D.drawLine((int)(offset + i * Program.scale * originalSize), 0, (int)(offset + i * Program.scale * originalSize), 1000);

            }
        }
        graphics2D.setColor(new Color(179, 143, 0));
        graphics2D.setStroke(new BasicStroke(2));
        graphics2D.drawLine(500, 0, 500, 1000);
        graphics2D.drawLine(0, 500, 1000, 500);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println(Program.scale);

    }
}
