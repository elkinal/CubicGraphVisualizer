import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by alxye on 29-Jun-18.
 */
public class Content extends JPanel implements ActionListener {
    private Timer t;
    private int range = 200;
    private int originalSize = 20;
    private double offset;
    private double gridSize;
    private static double x = 0;
    private static double y = 0;
    private static double a = 0;
    private static double b = 0;
    private static double c = 0;
    private static double d = 0;
    private static double e = 0;
    private static String[] formula;

    public Content() {

        //testing
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a");
        a = scanner.nextDouble();
        System.out.println("Enter b");
        b = scanner.nextDouble();
        System.out.println("Enter c");
        c = scanner.nextDouble();

        System.out.println("Enter the formula");

//        formula = scanner.next().split("[+-]");
        formula = scanner.next().split("");
        String formulaString = Arrays.toString(formula).replaceAll("[a-zA-Z]", "").replace("^", "");
        System.out.println(formulaString);


        System.out.println(Arrays.toString(formula));
        if(formula.length == 3) {
            System.out.println("Quadratic Equation");
            System.out.println(filterNumbers("x^2+3x-7"));
        } //+= ignored because of parsing method
        if(formula.length == 4) {
            System.out.println("Polynomial [3] Equation");
        }

        //drawPointAt(x, y);
        //testing

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
        /*graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);*/
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

        graphics2D.setColor(Color.red);
        // a * x^2 + bx + c
        //plotting points of the graph
//        int i = 0;
        /*double lastX = 0;
        double lastY = 0;*/
        x = -100;
        while (x <= 100) {
            /*if(formula.length == 2) {
                y = (a * x) + b; //straight
            }
            if(formula.length == 3) {
                y = (a * x * x) + (b * x) + c; //quadratic
            }
            if(formula.length == 4) {
                y = (a * x * x * x) + (b * x * x) + (c * x) + d; //cubical
            }
            if(formula.length == 5) {
                y = (a * x * x * x * x) + (b * x * x * x) + (c * x * x) + (d * x) + e; //polynomial
            }*/
            y = (a * x * x) + (b * x) + c;
            //System.out.println(x + "," + y);
            if(y < 100 && y > -100)
                graphics2D.drawRect((int)(Program.screenHeight / 2 + (originalSize * x * Program.scale)), (int)(Program.screenHeight - (Program.screenHeight / 2 + (originalSize * y * Program.scale))), 1, 1);

            /*graphics2D.drawLine((int)lastX, (int)lastY, (int)(Program.screenHeight / 2 + (originalSize * x * Program.scale)), (int)(Program.screenHeight / 2 + (originalSize * y * Program.scale)));
            lastX = x;
            lastY = y;*/
            x+=0.5;
        }

//        graphics2D.drawRect((int)(Program.screenHeight / 2 + (originalSize * x * Program.scale)), (int)(Program.screenHeight - (Program.screenHeight / 2 + (originalSize * y * Program.scale))), 1, 1);


    }
    public String filterNumbers(String control) {
        String result = "";
        for (int i = 0; i < control.length(); i++) {
            if(Character.isDigit(control.charAt(i))) {
                result += " " + control.charAt(i);
            }
        }
        //it actually seems to add all the numbers! fix this!
        return result;
    }






    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println(Program.scale);

    }
}
