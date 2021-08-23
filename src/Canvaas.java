import javax.crypto.AEADBadTagException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class Canvaas extends JPanel {
    private ArrayList<Point> tacke = new ArrayList<>();
    private ArrayList<Point> broj = new ArrayList<>();
    private int maxx = 0, maxy = 0, minx = 9999999, miny = 9999999, height, width, x, y;
    public double vect1, vect2;
    public Boolean jedan = null;

    Canvaas() {
        addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                reset();
                //tacke.clear();
                tacke.add(e.getPoint());
            }

            public void mouseReleased(MouseEvent e) {
                broj.add(tacke.get(0));

                for (Point point : tacke) {
                    broj = line(broj.get(broj.size() - 1).x, broj.get(broj.size() - 1).y, point.x, point.y, broj);
                }

                broj = clean(broj);

                for (Point p : broj) {
                    if(p.x > maxx) maxx = p.x;
                    if(p.x < minx) minx = p.x;
                    if(p.y > maxy) maxy = p.y;
                    if(p.y < miny) miny = p.y;
                }

                int brPixela = 0;
                x = minx;
                y = miny;
                width = maxx-x;
                height = maxy-y;

                for (Point p : broj) {
                    if (p.y > (y + height*2 / 3)) brPixela++;
                }

                vect1 = (double) width/height;
                vect2 = (double) brPixela/broj.size();

                System.out.println(vect1 + "  cnvs  " + vect2);

                jedan = 1.25-vect1-vect2 > 0? true : false;

                repaint();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                tacke.add(e.getPoint());
                repaint();
            }
        });

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);

        for (Point p : tacke) {
            g.drawLine(p.x, p.y, p.x, p.y);
        }

        for (Point p : broj) {
            g.drawLine(p.x, p.y, p.x, p.y);
        }

        g.setColor(Color.BLUE);
        g.drawRect(x, y, width,height);

    }

    public ArrayList<Point> clean(ArrayList<Point> lst){
        ArrayList<Point> neww = new ArrayList<>();

        neww.add(lst.get(0));

        for(Point p: lst){
            if(!neww.contains(p)) neww.add(p);
        }


        return neww;
    }

    public ArrayList<Point> line(int x, int y, int x2, int y2, ArrayList<Point> ary) {
        int w = x2 - x;
        int h = y2 - y;
        int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0;
        if (w < 0) dx1 = -1;
        else if (w > 0) dx1 = 1;
        if (h < 0) dy1 = -1;
        else if (h > 0) dy1 = 1;
        if (w < 0) dx2 = -1;
        else if (w > 0) dx2 = 1;
        int longest = Math.abs(w);
        int shortest = Math.abs(h);
        if (!(longest > shortest)) {
            longest = Math.abs(h);
            shortest = Math.abs(w);
            if (h < 0) dy2 = -1;
            else if (h > 0) dy2 = 1;
            dx2 = 0;
        }
        int numerator = longest >> 1;
        for (int i = 0; i <= longest; i++) {
            if (i != 0) ary.add(new Point(x, y));
            numerator += shortest;
            if (!(numerator < longest)) {
                numerator -= longest;
                x += dx1;
                y += dy1;
            } else {
                x += dx2;
                y += dy2;
            }
        }

        return ary;
    }

    public void reset(){
        tacke.clear();
        broj.clear();
        maxx = maxy = 0;
        minx = miny = 9999999;
        x = y = 0;
        width = height = 0;
        repaint();

    }

}


