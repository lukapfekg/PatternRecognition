import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Graph extends JPanel {
    private ArrayList<Tacka> jedinice = new ArrayList<>(), dvojke = new ArrayList<>();
    private double a = 1, b = 1, c = 300;
    private boolean line = false;

    Graph(){

        setBackground(Color.black);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);


        g.setColor(Color.RED);
        for (Tacka tacka : jedinice) {
            g.fillOval((int) (tacka.x * 300-1), (int) (tacka.y * 300-1), 2, 2);
        }

        g.setColor(Color.GREEN);
        for(Tacka tacka : dvojke){
            g.fillOval((int) (tacka.x * 300-1), (int) (tacka.y * 300-1), 2, 2);
        }

        g.setColor(Color.white);
        if(line)
            for(int i = 0; i < 1000; i++){
            g.drawLine((int) (a*i), (int) (c-i), (int) (a*i), (int) (c-i));
            }


    }

    public void getC(double cc){
        c = cc;
        line = true;
        repaint();
    }

    public void getA(double aa){
        a = aa;
        line = true;
        repaint();
    }

    public void getB(double bb){
        b = bb;
        line = true;
        repaint();
    }

    public void addJedan(Tacka t){
        jedinice.add(t);
        repaint();
    }

    public void addDva(Tacka t){
        dvojke.add(t);
        repaint();
    }



}
