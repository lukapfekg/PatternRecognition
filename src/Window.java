import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

public class Window extends JPanel {
    private BufferedImage img, image;
    private File file = new File("kec7.png");
    private ArrayList<Point> arr;
    private Integer xx ,yy, width, height;
    private ArrayList<Tacka> jedinice = new ArrayList<>(), dvojke = new ArrayList<>();
    private boolean jedan = false, dva = false;
    public File[] fileKecevi, fileDvojke;
    private Canvaas cnvs;
    private Comands cmnds;
    private Graph graph;
    private Params params;

    private void init() throws IOException {
       arr = new ArrayList<>();
       nadjiSlikeKeca();
       nadjiSlikeDvojke();
       cnvs = new Canvaas();
       graph = new Graph();
       cmnds = new Comands(cnvs, graph);
       params = new Params(graph);

       params.setBounds(0,0,1010,100);
       graph.setBounds(0,100,1010,400);
       cnvs.setBounds(0,400,1010,400);
       cmnds.setBounds(1010,0,200,900);

       add(cmnds);
       add(cnvs);
       add(params);
       add(graph);
       repaint();
    }

    public Window() throws IOException {
        setLayout(null);
        setBackground(Color.black);
        init();
        repaint();
    }



    private void crniPikseli(boolean cke, File f) throws IOException {
        img = ImageIO.read(f);
        ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
        ColorConvertOp op = new ColorConvertOp(cs, null);
        img = op.filter(img, null);


        int minx = img.getWidth();
        int maxx = 1;
        int miny = img.getHeight();
        int maxy = 1;
        for(int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                int clr = img.getRGB(i, j);
                int red = (clr & 0x00ff0000) >> 16;
                int green = (clr & 0x0000ff00) >> 8;
                int blue = clr & 0x000000ff;

                if (blue < 200 && red < 200 && green < 200) {
                    arr.add(new Point(i, j));
                    if(i > maxx) maxx = i;
                    if(i < minx) minx = i;
                    if(j > maxy) maxy = j;
                    if(j < miny) miny = j;
                }
            }
        }
        xx= minx;
        yy = miny;
        width = maxx - xx;
        height = maxy - yy;

        int brPixela = 0;


        for (Point point : arr) {
            if (point.y > (yy + height / 3)) brPixela++;
        }
        System.out.println(width + "  " + height + "  " + brPixela + "  " + arr.size());


        double o1 = (double)width/height;
        double o2 = (double)brPixela/arr.size();
        System.out.println(o1 + "  " + o2);
        if(cke) jedinice.add(new Tacka(o1, o2));
        else
            dvojke.add(new Tacka(o1, o2));

        arr.clear();
    }

    private void nadjiSlikeKeca() throws IOException {
        File f = new File(System.getProperty("user.dir"));
        fileKecevi = f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith("kec") && (name.endsWith(".jpg") || name.endsWith(".png"));
            }
        });

        for(int i = 0; i < fileKecevi.length; i++){
            crniPikseli(true, fileKecevi[i]);
        }
        System.out.println("----JEDINICE----");
        for (Tacka tacka : jedinice) {
            System.out.println(tacka.x + "  " + tacka.y);
        }
    }

    private void nadjiSlikeDvojke() throws IOException {
        File f = new File(System.getProperty("user.dir"));
        fileDvojke = f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith("dvojka") && (name.endsWith(".jpg") || name.endsWith(".png"));
            }
        });

        for (File value : fileDvojke) {
            crniPikseli(false, value);
        }

        System.out.println("----Dvojke----");
        for (Tacka tacka : dvojke) {
            System.out.println(tacka.x + "  " + tacka.y);
        }
    }



/*
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.red);

        for (Tacka tacka : jedinice) {
            if(1.25-tacka.x-tacka.y > 0) g.setColor(Color.RED);
            else g.setColor(Color.BLUE);
            g.fillOval((int) (tacka.x * 200-1), (int) (tacka.y * 200-1), 2, 2);
        }

        g.setColor(Color.GREEN);

        for(Tacka tacka : dvojke){
            if(1.25-tacka.x-tacka.y < 0) g.setColor(Color.GREEN);
            else g.setColor(Color.BLUE);
            g.fillOval((int) (tacka.x * 200-1), (int) (tacka.y * 200-1), 2, 2);
        }

        g.setColor(Color.white);
        for(int i = 0; i < 400; i++){
            g.drawLine(i, 250-i, i, 250-i);
        }

    }
*/

}
