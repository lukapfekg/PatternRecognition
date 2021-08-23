import javax.swing.*;
import java.awt.*;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Comands extends JPanel {
    private JButton reset, show, quit, jedan, dva;
    //private JTextField field;
    private Canvaas cnv;
    private Graph graph;
    private ArrayList<Tacka> kec, dvojka;

    public Comands(Canvaas c, Graph g) {
        setLayout(null);
        setBackground(Color.lightGray);
        cnv = c;
        graph = g;

        kec = new ArrayList<>();
        dvojka = new ArrayList<>();

        initBtnQ();
        initBtnR();
        initBtnS();
        initBtnJD();
    }

    private void initBtnR() {
        reset = new JButton("Reset");
        reset.setBounds(5, 5, 165, 165);
        reset.setBackground(Color.darkGray);
        reset.setForeground(Color.white);
        reset.addActionListener(l -> {
            cnv.reset();
        });

        add(reset);
    }

    private void initBtnQ() {
        quit = new JButton("Quit");
        quit.setBackground(Color.darkGray);
        quit.setForeground(Color.white);
        quit.setBounds(5, 690, 165, 165);
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                ((java.awt.Window) win).dispose();
            }
        });

        this.add(quit);

    }

    private void initBtnS() {
        show = new JButton("Show");
        show.setBounds(5, 200, 165, 165);
        show.setBackground(Color.darkGray);
        show.setForeground(Color.white);
        show.addActionListener(l -> {
            //    if (cnv.jedan) field.setText("1");
            //   else field.setText("2");
            SecondFrame frame = new SecondFrame(kec,  dvojka);
            frame.show();
        });
        add(show);
    }

    private void initBtnJD() {
        jedan = new JButton("1");
        jedan.setBounds(5, 200+165+10, 165, 90);
        jedan.setBackground(Color.darkGray);
        jedan.setForeground(Color.white);
        jedan.addActionListener(l ->{

            System.out.println(cnv.vect1 + "  cmnds  " + cnv.vect2);
            kec.add(new Tacka(cnv.vect1, cnv.vect2));
            graph.addJedan(new Tacka(cnv.vect1, cnv.vect2));
            cnv.reset();
        });

        dva = new JButton("2");
        dva.setBounds(5, 200+340, 165, 90);
        dva.setBackground(Color.darkGray);
        dva.setForeground(Color.white);
        dva.addActionListener(l ->{
            dvojka.add(new Tacka(cnv.vect1, cnv.vect2));
            graph.addDva(new Tacka(cnv.vect1, cnv.vect2));
            cnv.reset();
        });

        add(jedan);
        add(dva);


    }


}
